package com.fds.sistemavendas.model;

import jakarta.persistence.*;

// TODO - Provavelmente essa classe precisa de alguma alteração em relação ao Banco de Dados
@Entity(name = "tb_order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
