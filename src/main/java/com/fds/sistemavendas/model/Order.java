package com.fds.sistemavendas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> itemList;

    public Order(Long id, String name, List<OrderItem> itemList) {
        this.id = id;
        this.name = name;
        this.itemList = itemList;
    }

    protected Order() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }
}
