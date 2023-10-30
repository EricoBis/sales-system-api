package com.fds.sistemavendas.service.impl;

import com.fds.sistemavendas.model.Order;
import com.fds.sistemavendas.model.Budget;
import com.fds.sistemavendas.model.OrderItem;
import com.fds.sistemavendas.model.Product;
import com.fds.sistemavendas.repository.IRepBudget;
import com.fds.sistemavendas.repository.IRepProducts;
import com.fds.sistemavendas.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {

    private static final double TAX = 0.10;
    private static final int DISCOUNT_AMOUNT = 5;
    private static final double DISCOUNT = 0.05;

    private final IRepBudget budgetRepository;
    private final IRepProducts productsRepository;

    @Autowired
    public SalesServiceImpl(IRepBudget budgetRepository, IRepProducts productsRepository) {
        this.budgetRepository = budgetRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public Budget createOrUpdateBudget(Order order) {
        Budget newBudget; // = getBudgetByOrderId(order.getId());



        double orderCost = order.getItemList().stream().mapToDouble(item -> {
            int amount = item.getAmount();
            double price = getProductById(item.getProductId()).getPrice();

            return price * amount;
        }).sum();

        double taxCost = orderCost * TAX;
        double discount = order.getItemList().stream().mapToInt(OrderItem::getAmount).sum() > DISCOUNT_AMOUNT
                ? orderCost * DISCOUNT
                : 0.0;
        double totalCost = orderCost - discount + taxCost;

        newBudget = new Budget(order.getId(), order.getName(), orderCost, taxCost, discount, totalCost, order.getItemList());

        return budgetRepository.save(newBudget);
    }

    @Override
    public Budget saveBudget(Budget budget) {
        return null;
    }

    private Budget getBudgetByOrderId(Long orderId) {
        return budgetRepository.getAll().stream()
                .filter(budget -> budget.getOrderId().equals(orderId))
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
