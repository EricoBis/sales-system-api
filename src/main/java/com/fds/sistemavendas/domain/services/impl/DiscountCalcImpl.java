package com.fds.sistemavendas.domain.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.entities.OrderItem;
import com.fds.sistemavendas.domain.services.IDiscountCalc;

@Service
public class DiscountCalcImpl implements IDiscountCalc {
    private static final double DISCOUNT = 0.05;
    private static final int DISCOUNT_AMOUNT = 5;

    @Override
    public double calculateDiscount(List<Budget> clientsBudgets, OrderDTO order, double orderCost) {
        int quantity = order.getItemList().stream().mapToInt(OrderItem::getAmount).sum();

        return  quantity > DISCOUNT_AMOUNT
                ? orderCost * DISCOUNT
                : 0.0;
    }

}
