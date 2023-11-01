package com.fds.sistemavendas.domain.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity(name = "tb_budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "order_cost")
    private double orderCost;

    @Column(name = "tax_cost")
    private double taxCost;

    private double discount;

    @Column(name = "total_cost")
    private double totalCost;
    
    private boolean done;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Budget(Long id, String name, double orderCost, double taxCost, double discount, double totalCost,
            List<OrderItem> items) {
        this.id = id;
        this.name = name;
        this.orderCost = orderCost;
        this.taxCost = taxCost;
        this.discount = discount;
        this.totalCost = totalCost;
        this.done = false;
        this.items = items;
    }

    protected Budget(){}

    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public boolean isDone() {
        return done;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
