package com.fds.sistemavendas.model;

public class StorageItem {

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

    
}
