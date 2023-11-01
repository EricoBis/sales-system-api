package com.fds.sistemavendas.model;

import jakarta.persistence.*;

@Entity(name = "tb_order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long orderId;

    @Column(name = "product_id")
    private Long productId;
    
    private int amount;
    
    public OrderItem(Long orderId, Long productId, int amount) {
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
    }

    protected OrderItem(){}
    
    public Long getProductId() {
        return productId;
    }
    
    public int getAmount() {
        return amount;
    }
    
}
