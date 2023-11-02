package com.fds.sistemavendas.application.dto;

import java.util.List;

import com.fds.sistemavendas.domain.entities.OrderItem;

public class OrderDTO {

    private Long budgetId;
    private String name;
    private Long clientId;
    private List<OrderItem> itemList;

    public OrderDTO(Long budgetId, String name, Long clientId, List<OrderItem> itemList) {
        this.budgetId = budgetId;
        this.name = name;
        this.clientId = clientId;
        this.itemList = itemList;
    }
    
    public Long getId() {
        return budgetId;
    }

    public String getName() {
        return name;
    }

    public Long getClientId() {
        return clientId;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }
}
