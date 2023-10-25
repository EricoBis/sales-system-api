package com.fds.sistemavendas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StorageItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long productId;
    private int currQuantity;
    private int minQuantity;
    private int maxQuantity;

    public StorageItem(Long id, Long productId, int currQuantity, int minQuantity, int maxQuantity) {
        this.id = id;
        this.productId = productId;
        this.currQuantity = currQuantity;
        this.minQuantity = minQuantity;
        this.maxQuantity = maxQuantity;
    }

    protected StorageItem(){}

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getCurrQuantity() {
        return currQuantity;
    }

    public void setCurrQuantity(int currQuantity) {
        this.currQuantity = currQuantity;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    
}
