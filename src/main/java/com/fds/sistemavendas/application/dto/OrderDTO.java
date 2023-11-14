package com.fds.sistemavendas.application.dto;

import java.util.List;

import com.fds.sistemavendas.domain.entities.OrderItem;

public class OrderDTO {
    private Long clientId;
    private List<OrderItem> itemList;

    public OrderDTO(Long clientId, List<OrderItem> itemList) {
        this.clientId = clientId;
        this.itemList = itemList;
    }

    public Long getClientId() {
        return clientId;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }
}
