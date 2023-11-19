package com.fds.sistemavendas.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.entities.OrderItem;
import com.fds.sistemavendas.domain.services.impl.Discount2023Impl;

public class Discount2023ImplTest {

    private IDiscountCalc discountCalc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        discountCalc = new Discount2023Impl();
    }

    // no discount
    @Test
    public void shouldCalculateNoDiscount() {
        List<Budget> budgets = createBudgets(1000, 500, 8000, 540);
        List<OrderItem> items = new ArrayList<OrderItem>();
        items.add(new OrderItem(1L, 2L, 2));
        OrderDTO order = new OrderDTO(1L, null);
        double orderCost = 1000;

        double discount = discountCalc.calculateDiscount(budgets, order, orderCost);

        assertEquals(0, discount);
    }

    @Test
    public void shouldCalculate10PercentDiscountForAverageOver10000() {
        List<Budget> budgets = createBudgets(12000, 15000, 8000);
        List<OrderItem> items = new ArrayList<OrderItem>();
        items.add(new OrderItem(1L, 2L, 2));
        OrderDTO order = new OrderDTO(budgets.get(0).getClientId(), items);
        double orderCost = 1000;

        double discount = discountCalc.calculateDiscount(budgets, order, orderCost);

        assertEquals(0.1 * orderCost, discount);
    }

    @Test
    public void shouldCalculate15PercentDiscountForAverage20000() {
        List<Budget> budgets = createBudgets(20000, 20000, 20000);
        List<OrderItem> items = new ArrayList<OrderItem>();
        items.add(new OrderItem(1L, 2L, 2));
        OrderDTO order = new OrderDTO(budgets.get(0).getClientId(), items);
        double orderCost = 1000;

        double discount = discountCalc.calculateDiscount(budgets, order, orderCost);

        assertEquals(0.15 * orderCost, discount);
    }

    @Test
    public void shouldCalculate25PercentDiscountForOver10Budgets() {
        // client id 1 has 3 budgets of 20000
        // Arrange
        List<Budget> budgets = createBudgets(500, 250, 700, 1000, 2000, 2500, 100, 900, 125, 100, 800);
        List<OrderItem> items = new ArrayList<OrderItem>();
        items.add(new OrderItem(1L, 2L, 2));
        OrderDTO order = new OrderDTO(budgets.get(0).getClientId(), items);
        double orderCost = 1000;

        // Act
        double discount = discountCalc.calculateDiscount(budgets, order, orderCost);

        // Assert
        assertEquals(0.25 * orderCost, discount);
    }

    @Test
    public void shouldCalculate30PercentDiscountForAverageOver50000() {
        // client id 1 has 3 budgets of 20000
        // Arrange
        List<Budget> budgets = createBudgets(60000, 55000, 48000);
        List<OrderItem> items = new ArrayList<OrderItem>();
        items.add(new OrderItem(1L, 2L, 2));
        OrderDTO order = new OrderDTO(budgets.get(0).getClientId(), items);
        double orderCost = 1000;

        // Act
        double discount = discountCalc.calculateDiscount(budgets, order, orderCost);

        // Assert
        assertEquals(0.3 * orderCost, discount);
    }

    // Add more test cases as needed...

    private List<Budget> createBudgets(double... totalCosts) {
        List<Budget> budgets = new ArrayList<>();
        for (double totalCost : totalCosts) {
            Budget budget = mock(Budget.class);
            when(budget.getTotalCost()).thenReturn(totalCost);
            when(budget.getDate()).thenReturn(LocalDateTime.now());
            when(budget.isDone()).thenReturn(true);
            budgets.add(budget);
        }
        return budgets;
    }
}
