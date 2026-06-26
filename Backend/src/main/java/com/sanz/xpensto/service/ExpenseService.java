package com.sanz.xpensto.service;

import com.sanz.xpensto.model.ExpenseModel;
import com.sanz.xpensto.repository.ExpenseRepo;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class ExpenseService {
        private final ExpenseRepo expenseRepository;
        public ExpenseService(ExpenseRepo expenseRepository){
            this.expenseRepository = expenseRepository;
        }
        public ExpenseModel addExpense(ExpenseModel expense){
            return expenseRepository.save(expense);
        }
    }







