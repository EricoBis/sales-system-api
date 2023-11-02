package com.fds.sistemavendas.application.dto;

import java.util.List;

import com.fds.sistemavendas.domain.entities.OrderItem;

public class BudgetDTO {

    private final Long orderId;
    private final double orderCost;
    private final double taxCost;
    private final double discount;
    private final double totalCost;
    private final boolean done;
    private final Long clientId;
    private final List<OrderItem> items;

    public BudgetDTO(Long orderId, double orderCost, double taxCost, double discount, double totalCost, boolean done, Long clientId, List<OrderItem> items) {
        this.orderId = orderId;
        this.orderCost = orderCost;
        this.taxCost = taxCost;
        this.discount = discount;
        this.totalCost = totalCost;
        this.done = done;
        this.items = items;
        this.clientId = clientId;
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

    public boolean getDone() {
        return done;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Long getClientId() {
        return clientId;
    }
}
