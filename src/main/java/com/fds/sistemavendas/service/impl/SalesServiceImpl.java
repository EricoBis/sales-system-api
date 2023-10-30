package com.fds.sistemavendas.service.impl;

import com.fds.sistemavendas.model.Order;
import com.fds.sistemavendas.model.Budget;
import com.fds.sistemavendas.model.OrderItem;
import com.fds.sistemavendas.model.Product;
import com.fds.sistemavendas.repository.IRepBudget;
import com.fds.sistemavendas.repository.IRepOrder;
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
    private final IRepOrder orderRepository;
    private final DiscountCalc discount;
    private final TaxCalc tax;

    @Autowired
    public SalesServiceImpl(IRepBudget budgetRepository, IRepProducts productsRepository, IRepOrder orderRepository, TaxCalc tax, DiscountCalc discount) {
        this.budgetRepository = budgetRepository;
        this.productsRepository = productsRepository;
        this.orderRepository = orderRepository;
        this.discount = discount;
        this.tax = tax;
    }

    @Override
    public Budget createOrUpdateBudget(Order order) {
        // if (order.getId() == null) {
        //     orderRepository.save(order);
        // }

        Budget newBudget; // = getBudgetByOrderId(order.getId());

        double orderCost = order.getItemList().stream().mapToDouble(item -> {
            int amount = item.getAmount();
            double price = getProductById(item.getProductId()).getPrice();

            return price * amount;
        }).sum();

        double taxCost = tax.calculateTax(orderCost);
        int quantity = order.getItemList().stream().mapToInt(OrderItem::getAmount).sum();
        double d = discount.calculateDescount(quantity, orderCost);
        double totalCost = orderCost - d + taxCost;

        newBudget = new Budget(order.getId(), order.getName(), orderCost, taxCost, d, totalCost, order.getItemList());

        return budgetRepository.save(newBudget);
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
