package com.fds.sistemavendas.dto;

import java.util.List;

import com.fds.sistemavendas.model.OrderItem;

public class OrderDTO {

    private Long budgetId;
    private String name;
    private List<OrderItem> itemList;

    public OrderDTO(Long budgetId, String name, List<OrderItem> itemList) {
        this.budgetId = budgetId;
        this.name = name;
        this.itemList = itemList;
    }
    
    public Long getId() {
        return budgetId;
    }

    public String getName() {
        return name;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }
}
