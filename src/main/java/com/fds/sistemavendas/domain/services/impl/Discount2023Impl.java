package com.fds.sistemavendas.domain.services.impl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.fds.sistemavendas.application.dto.OrderDTO;
import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.services.IDiscountCalc;

@Service
@Primary
public class Discount2023Impl implements IDiscountCalc {
    
    @Override
    public double calculateDiscount(List<Budget> clientsBudgets, OrderDTO order, double orderCost) {
        // valor médio de suas últimas 3 compras superior a R$ 10 mil recebem 10% de desconto
        // a cada R$ 10 mil adicionais 5% adicionais até um limite de 30% de desconto
        double discount = 0;
        double avg = 0;

        if(clientsBudgets.isEmpty()) return 0.0;
        
        if (clientsBudgets.size() > 2) {
            Collections.sort(clientsBudgets, new Comparator<Budget>() {
                @Override
                public int compare(Budget b1, Budget b2) {
                    return b2.getDate().compareTo(b1.getDate());
                }
            });

            int nBudgetsInAvg = 0;
            for(int i = 0; i < clientsBudgets.size(); i++) {
                // add only done budgets
                if (clientsBudgets.get(i).isDone()) {
                    avg += clientsBudgets.get(i).getTotalCost();
                    nBudgetsInAvg++;
                }

                if (nBudgetsInAvg == 3)
                    break;
            }

            avg = avg / 3;

            if (avg >= 50000) discount = 30;
            else if(avg > 10000) {
                discount = 10;
                avg -= 10000;
    
                double iMax = avg / 10000;
    
                for(int i = 0; i < iMax; i++) {
                    if(avg <= 0) break;
                    if((avg / 10000) <= 4) {
                        discount += Math.floor((avg / 10000) * 5);
                        avg -= 10000;
                    }
                }
            }
        }
        
        // Clientes com mais de 10 compras nos últimos 6 meses recebem desconto de 25%, indiferente do valor
        if(discount < 25) {
            List<Budget> lastSixMonths = clientsBudgets.stream()
                                                    .filter(budget -> budget.getDate().isAfter(LocalDateTime.now().minusMonths(6)))
                                                    .toList();
            
            if(lastSixMonths.size() > 10) discount = 25;
        }

        return orderCost * (discount/100);
    }
    
}
