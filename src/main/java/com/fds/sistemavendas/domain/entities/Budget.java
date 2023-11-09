package com.fds.sistemavendas.domain.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;

@Entity(name = "tb_budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "id_client")
    private Long clientId;

    @Column(name = "order_cost")
    private double orderCost;

    @Column(name = "tax_cost")
    private double taxCost;

    private double discount;

    @Column(name = "total_cost")
    private double totalCost;
    
    private boolean done;

    @Column(name = "date_time")
    private LocalDateTime date;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    public Budget(Long id, Long clientId, double orderCost, double taxCost, double discount, double totalCost, 
            LocalDateTime expirationDate, List<OrderItem> items, LocalDateTime date) {
        this.id = id;
        this.clientId = clientId;
        this.orderCost = orderCost;
        this.taxCost = taxCost;
        this.discount = discount;
        this.totalCost = totalCost;
        this.done = false;
        this.expirationDate = expirationDate;
        this.items = items;
        this.date = date;
    }

    protected Budget(){}

    public void setDone(boolean done) {
        this.done = done;
    }

    public Long getId() {
        return id;
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

    public Long getClientId() {
        return clientId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
