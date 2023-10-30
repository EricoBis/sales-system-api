package com.fds.sistemavendas.dto;

import com.fds.sistemavendas.model.OrderItem;
import jakarta.persistence.Column;

import java.util.List;

public class BudgetDTO {

    private final Long orderId;
    private final double orderCost;
    private final double taxCost;
    private final double discount;
    private final double totalCost;
    private final List<OrderItem> items;

    public BudgetDTO(Long orderId, double orderCost, double taxCost, double discount, double totalCost, List<OrderItem> items) {
        this.orderId = orderId;
        this.orderCost = orderCost;
        this.taxCost = taxCost;
        this.discount = discount;
        this.totalCost = totalCost;
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public double getOrderCost() {
        return orderCost;
    }

    public double getTaxCost() {
        return taxCost;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
