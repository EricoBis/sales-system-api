package com.fds.sistemavendas.domain.services.impl;

import com.fds.sistemavendas.adapters.controller.exception.SaleNotDoneException;
import com.fds.sistemavendas.adapters.repositories.IRepBudget;
import com.fds.sistemavendas.adapters.repositories.IRepProducts;
import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.entities.Product;
import com.fds.sistemavendas.domain.services.IDiscountCalc;
import com.fds.sistemavendas.domain.services.ISalesService;
import com.fds.sistemavendas.domain.services.IStorageService;
import com.fds.sistemavendas.domain.services.ITaxCalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SalesServiceImpl implements ISalesService {
    private final IRepBudget budgetRepository;
    private final IRepProducts productsRepository;
    private IDiscountCalc discountCalc;
    private ITaxCalc taxCalc;
    private IStorageService storageService;

    @Autowired
    public SalesServiceImpl(IRepBudget budgetRepository, IRepProducts productsRepository, ITaxCalc taxCalc, IDiscountCalc discountCalc, IStorageService storageService) {
        this.budgetRepository = budgetRepository;
        this.productsRepository = productsRepository;
        this.discountCalc = discountCalc;
        this.taxCalc = taxCalc;
        this.storageService = storageService;
    }

    @Override
    public Budget createOrUpdateBudget(OrderDTO order) {
        Budget newBudget;

        double orderCost = order.getItemList().stream().mapToDouble(item -> {
            int amount = item.getAmount();
            double price = getProductById(item.getProductId()).getPrice();

            return price * amount;
        }).sum();

        double taxCost = taxCalc.calculateTax(orderCost);

        List<Budget> clientsBudgets = getBudgetsByClientId(order.getClientId());

        double discount = discountCalc.calculateDiscount(clientsBudgets, order, orderCost);

        double totalCost = orderCost - discount + taxCost;

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime expirationDate;

        if(now.getMonth().equals(Month.JANUARY) || now.getMonth().equals(Month.FEBRUARY)) {
            expirationDate = now.plusDays(35);
        }
        else {
            expirationDate = now.plusDays(21);
        }

        newBudget = new Budget(order.getId(), order.getClientId(), orderCost, taxCost, discount, totalCost, expirationDate, order.getItemList(), now);

        return budgetRepository.save(newBudget);
    }

    @Override
    public Budget executeOrder(Long id) {
        Budget budgetToUpdate = getBudgetById(id);
        if (storageService.ProductsAreAvailable(budgetToUpdate.getItems()) && budgetToUpdate.getExpirationDate().isAfter(LocalDateTime.now())) {
            storageService.UpdateStorage(budgetToUpdate.getItems());
            budgetToUpdate.setDone(true); // :D
            return budgetRepository.save(budgetToUpdate);
        }
        throw new SaleNotDoneException("Unable to complete purchase.");
    }

    private Budget getBudgetById(Long id) {
        return budgetRepository.getById(id).get();
    }

    private List<Budget> getBudgetsByClientId(Long clientId) {
        return budgetRepository.getByClientId(clientId).stream()
                .filter(budget -> budget.isDone() == true)
                .collect(Collectors.toList());
    }

    private Product getProductById(Long id) {
        var product = productsRepository.getById(id);
        return product.orElse(null);
    }
}
