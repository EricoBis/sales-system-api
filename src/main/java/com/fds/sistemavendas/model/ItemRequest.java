package com.fds.sistemavendas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ItemRequest {
    @Id
    private Long productId;
    private int amount;
    
    public ItemRequest(Long productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }
    
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
