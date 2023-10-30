package com.fds.sistemavendas.service.impl;

import com.fds.sistemavendas.dto.OrderDTO;
import com.fds.sistemavendas.model.Budget;
import com.fds.sistemavendas.model.OrderItem;
import com.fds.sistemavendas.model.Product;
import com.fds.sistemavendas.repository.IRepBudget;

import com.fds.sistemavendas.repository.IRepProducts;
import com.fds.sistemavendas.service.DiscountCalc;
import com.fds.sistemavendas.service.SalesService;
import com.fds.sistemavendas.service.TaxCalc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceImpl implements SalesService {
    private final IRepBudget budgetRepository;
    private final IRepProducts productsRepository;
    private DiscountCalc discountCalc;
    private TaxCalc taxCalc;

    @Autowired
    public SalesServiceImpl(IRepBudget budgetRepository, IRepProducts productsRepository, TaxCalc taxCalc, DiscountCalc discountCalc) {
        this.budgetRepository = budgetRepository;
        this.productsRepository = productsRepository;
        this.discountCalc = discountCalc;
        this.taxCalc = taxCalc;
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

        int quantity = order.getItemList().stream().mapToInt(OrderItem::getAmount).sum();
        double discount = discountCalc.calculateDescount(quantity, orderCost);

        double totalCost = orderCost - discount + taxCost;

        newBudget = new Budget(order.getId(), order.getName(), orderCost, taxCost, discount, totalCost, order.getItemList());

        return budgetRepository.save(newBudget);
    }

    private Budget getBudgetByOId(Long id) {
        return budgetRepository.getAll().stream()
                .filter(budget -> budget.getId().equals(id))
                .findAny()
                .orElse(null);
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
