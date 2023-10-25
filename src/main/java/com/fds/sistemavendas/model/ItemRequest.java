package com.fds.sistemavendas.model;

import jakarta.persistence.*;

@Entity(name = "tb_item_request")
public class ItemRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "product_id")
    private Long productId;
    
    private int amount;
    
    public ItemRequest(Long requestId, Long productId, int amount) {
        this.requestId = requestId;
        this.productId = productId;
        this.amount = amount;
    }

    protected ItemRequest(){}
    
    public Long getProductId() {
        return productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
