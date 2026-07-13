package com.sanz.xpensto.controller;

import com.sanz.xpensto.model.ExpenseModel;
import com.sanz.xpensto.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping("/add")
    public ExpenseModel addExpense(@RequestBody ExpenseModel expense){
        return expenseService.addExpense(expense);
    }
    @GetMapping
    public List<ExpenseModel> getAllExpense(){
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public ExpenseModel getExpenseById(@PathVariable Long id){
        return expenseService.getExpensebyId(id)
                .orElseThrow(() -> new RuntimeException("Expense not found with id: "+id));
    }

    @PutMapping("/{id}")
    public ExpenseModel updateExpense(@PathVariable Long id,@RequestBody ExpenseModel updatedExpense){
        return expenseService.updateExpense(id, updatedExpense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpenseById(@PathVariable Long id){
        expenseService.deleteExpense(id);
    }






}
