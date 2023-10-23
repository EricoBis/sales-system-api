package com.fds.sistemavendas.model;

import java.util.List;

import jakarta.persistence.Id;

public class Budget {
    @Id
    private Long id;
    private Long requestId;
    private double requestCost;
    private double taxCost;
    private double discount;
    private double totalCost;
    private boolean done;
    private List<ItemRequest> items;

    public Budget(Long id, Long requestId, double requestCost, double taxCost, double discount, double totalCost,
            List<ItemRequest> items) {
        this.id = id;
        this.requestId = requestId;
        this.requestCost = requestCost;
        this.taxCost = taxCost;
        this.discount = discount;
        this.totalCost = totalCost;
        this.done = false;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public boolean isDone() {
        return done;
    }

    
}
