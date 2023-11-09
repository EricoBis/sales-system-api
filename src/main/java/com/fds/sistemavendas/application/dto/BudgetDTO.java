package com.fds.sistemavendas.application.dto;

import java.time.LocalDateTime;
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
    private final LocalDateTime date;
    private final LocalDateTime expirationDate;
    private final List<OrderItem> items;

    public BudgetDTO(Long orderId, double orderCost, double taxCost, double discount, double totalCost, boolean done, Long clientId, List<OrderItem> items, LocalDateTime date, LocalDateTime expirationDate) {
        this.orderId = orderId;
        this.orderCost = orderCost;
        this.taxCost = taxCost;
        this.discount = discount;
        this.totalCost = totalCost;
        this.done = done;
        this.items = items;
        this.clientId = clientId;
        this.date = date;
        this.expirationDate = expirationDate;
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

    public LocalDateTime getDate() {
        return date;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
