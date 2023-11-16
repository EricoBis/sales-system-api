package com.fds.sistemavendas.domain.services;

import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.entities.OrderItem;
import com.fds.sistemavendas.domain.entities.Product;
import com.fds.sistemavendas.domain.repositories.IRepBudget;
import com.fds.sistemavendas.domain.repositories.IRepProducts;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class SalesServiceTest {
    @Mock
    private IRepBudget budgetRepository;

    @Mock
    private IRepProducts productsRepository;

    @Mock
    private IDiscountCalc discountCalc;

    @Mock
    private ITaxCalc taxCalc;

    @Mock
    private StorageService storageService;

    @InjectMocks
    private SalesService salesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        salesService = new SalesService(budgetRepository, productsRepository, taxCalc, discountCalc, storageService);

        when(productsRepository.getById(anyLong()))
                .thenReturn(Optional.of(new Product(2L, "", 19.99, "")));
        when(budgetRepository.save(any(Budget.class))).thenAnswer(i -> i.getArguments()[0]);
        when(taxCalc.calculateTax(anyDouble())).thenAnswer(i -> 0.1 * (Double) i.getArguments()[0]);

    }

    @Test
    public void shouldCreateBudgetAndReturnCorrectTotalCost(){
        List<OrderItem> items = new ArrayList<OrderItem>();
        items.add(new OrderItem(1L, 2L, 2));

        OrderDTO order = new OrderDTO(31L, items);
        double value = salesService.createBudget(order).getTotalCost();
        Assertions.assertEquals(43.977999999999994,value);
    }
}