package com.fds.sistemavendas.domain.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fds.sistemavendas.domain.entities.Budget;
import com.fds.sistemavendas.domain.services.IDiscount2023;

@Service
public class Discount2023Impl implements IDiscount2023 {
    
    @Override
    public double calculateDiscount(double orderCost, List<Budget> clientsBudgets) {
        // valor médio de suas últimas 3 compras superior a R$ 10 mil recebem 10% de desconto
        // a cada R$ 10 mil adicionais 5% adicionais até um limite de 30% de desconto
        double discount = 0;
        double avg = 0;

        // List<Budget> lastThreeBudgets = new ArrayList<Budget>();
        if(clientsBudgets.size() >= 3) {
            for(int i = clientsBudgets.size() - 1; i > clientsBudgets.size() - 4; i--) {
                avg += clientsBudgets.get(i).getTotalCost();
                // lastThreeBudgets.add(clientsBudgets.get(i));
            }
        }
        else {
            for(int i = 0; i < clientsBudgets.size(); i++) {
                avg += clientsBudgets.get(i).getTotalCost();
                // lastThreeBudgets.add(clientsBudgets.get(i));
            }
        }

        // for(int i = 0; i < lastThreeBudgets.size(); i++) {
        //     avg += lastThreeBudgets.get(i).getTotalCost();
        // }

        avg = avg / clientsBudgets.size();

        if(avg > 10000) {
            discount = 10;
            avg -= 10000;

            if((avg / 10000) <= 5) {
                discount += Math.floor((avg / 10000) * 5);
            }
            else {
                discount = 30;
            }
        }

        // Clientes com mais de 10 compras nos últimos 6 meses recebem desconto de 25%, indiferente do valor
        if(discount < 25) {
            List<Budget> lastSixMonths = clientsBudgets.stream()
                                                    .filter(budget -> budget.getDate().isAfter(LocalDateTime.now().minusMonths(6)))
                                                    .toList();
            
            if(lastSixMonths.size() > 10) discount = 25;
        }

        return orderCost * discount;
    }
    
}
