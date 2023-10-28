package com.fds.sistemavendas.model;

import java.util.List;

import jakarta.persistence.*;

@Entity(name = "tb_budget")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // TODO - Verificar se requestId é realmente necessário aqui
    private Long requestId;

    @Column(name = "request_cost")
    private double requestCost;

    @Column(name = "tax_cost")
    private double taxCost;

    private double discount;

    @Column(name = "total_cost")
    private double totalCost;
    
    private boolean done;

    @OneToMany(cascade = CascadeType.ALL)
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

    protected Budget(){}

    public void setDone(boolean done) {
        this.done = done;
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
