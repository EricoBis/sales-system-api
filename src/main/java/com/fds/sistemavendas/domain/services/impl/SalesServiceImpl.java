package com.fds.sistemavendas.domain.services.impl;

import com.fds.sistemavendas.adapters.repositories.IRepBudget;
import com.fds.sistemavendas.adapters.repositories.IRepProducts;
import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.entities.OrderItem;
import com.fds.sistemavendas.domain.entities.Product;
import com.fds.sistemavendas.domain.services.IDiscount2023;
import com.fds.sistemavendas.domain.services.IDiscountCalc;
import com.fds.sistemavendas.domain.services.ISalesService;
import com.fds.sistemavendas.domain.services.ITaxCalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SalesServiceImpl implements ISalesService {
    private final IRepBudget budgetRepository;
    private final IRepProducts productsRepository;
    private IDiscountCalc discountCalc;
    private IDiscount2023 discount2023;
    private ITaxCalc taxCalc;

    @Autowired
    public SalesServiceImpl(IRepBudget budgetRepository, IRepProducts productsRepository, ITaxCalc taxCalc, IDiscountCalc discountCalc, IDiscount2023 discount2023) {
        this.budgetRepository = budgetRepository;
        this.productsRepository = productsRepository;
        this.discountCalc = discountCalc;
        this.taxCalc = taxCalc;
        this.discount2023 = discount2023;
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

        int quantity = order.getItemList().stream().mapToInt(OrderItem::getAmount).sum();
        // double discount = discountCalc.calculateDescount(quantity, orderCost);
        double discount = discount2023.calculateDiscount(orderCost, clientsBudgets);

        double totalCost = orderCost - discount + taxCost;

        newBudget = new Budget(order.getId(), order.getName(), order.getClientId(), orderCost, taxCost, discount, totalCost, order.getItemList());

        return budgetRepository.save(newBudget);
    }

    @Override
    public Budget executeOrder(Long id) {
        Budget budgetToUpdate = getBudgetById(id);
        budgetToUpdate.setDone(true); // :D
        return budgetRepository.save(budgetToUpdate);
    }

    private Budget getBudgetById(Long id) {
        return budgetRepository.getAll().stream()
                .filter(budget -> budget.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    private List<Budget> getBudgetsByClientId(Long clientId) {
        return budgetRepository.getAll().stream()
                .filter(budget -> budget.isDone() == true)
                .filter(budget -> budget.getClientId().equals(clientId))
                .collect(Collectors.toList());
    }

    private Product getProductById(Long id) {
        var product = productsRepository.getById(id);
        return product.orElse(null);
    }

    // private List<Product> getProductsList(List<OrderItem> itemList) {
    // return itemList.stream()
    // .map(orderItem -> productsRepository.getById(orderItem.getProductId()))
    // .filter(Optional::isPresent)
    // .map(Optional::get)
    // .toList();
    // }
}
