package com.fds.sistemavendas.domain.services;

import com.fds.sistemavendas.adapters.controller.exception.SaleNotDoneException;
import com.fds.sistemavendas.domain.repositories.IRepBudget;
import com.fds.sistemavendas.domain.repositories.IRepProducts;
import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.entities.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SalesService {
    private final IRepBudget budgetRepository;
    private final IRepProducts productsRepository;
    private final IDiscountCalc discountCalc;
    private final ITaxCalc taxCalc;
    private final StorageService storageService;

    @Autowired
    public SalesService(IRepBudget budgetRepository, IRepProducts productsRepository, ITaxCalc taxCalc, IDiscountCalc discountCalc, StorageService storageService) {
        this.budgetRepository = budgetRepository;
        this.productsRepository = productsRepository;
        this.discountCalc = discountCalc;
        this.taxCalc = taxCalc;
        this.storageService = storageService;
    }

    public Budget createBudget(OrderDTO order) {
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

        newBudget = new Budget(order.getClientId(), orderCost, taxCost, discount, totalCost, expirationDate, order.getItemList(), now);

        return budgetRepository.save(newBudget);
    }

    public Budget executeOrder(Long id) {
        Budget budgetToUpdate = getBudgetById(id);
        if(budgetToUpdate.isDone()){
            throw new SaleNotDoneException("Budget already done");
        }
        if (!storageService.ProductsAreAvailable(budgetToUpdate.getItems())) {
            throw new SaleNotDoneException("Items not available");
        }
        if (!budgetToUpdate.getExpirationDate().isAfter(LocalDateTime.now())) {
            throw new SaleNotDoneException("Budget already expired");
        }
        storageService.UpdateStorage(budgetToUpdate.getItems());
        budgetToUpdate.setDone(true);
        return budgetRepository.save(budgetToUpdate);
    }

    private Budget getBudgetById(Long id) {
        return budgetRepository.getById(id).get();
    }

    private List<Budget> getBudgetsByClientId(Long clientId) {
        return budgetRepository.getByClientId(clientId).stream()
                .filter(Budget::isDone)
                .collect(Collectors.toList());
    }

    private Product getProductById(Long id) {
        var product = productsRepository.getById(id);
        return product.orElse(null);
    }
}
