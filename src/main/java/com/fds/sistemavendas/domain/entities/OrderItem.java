package com.fds.sistemavendas.domain.entities;

import jakarta.persistence.*;

@Entity(name = "tb_order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "product_id")
    private Long productId;
    
    private int amount;
    
    public OrderItem(Long id, Long productId, int amount) {
        this.id = id;
        this.productId = productId;
        this.amount = amount;
    }

    protected OrderItem(){}

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }
    
    public int getAmount() {
        return amount;
    }


}
