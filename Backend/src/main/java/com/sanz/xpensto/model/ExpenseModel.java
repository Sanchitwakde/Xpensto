package com.sanz.xpensto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity //entity class that tells that this class should be mapped to db table
@Table(name = "Expenses")
public class ExpenseModel {
    @Id // to set primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // to auto generate id's
    private long id;
    private double amount;
    private String item;
    private String category;
    private LocalDate date; // date of purchase
    private LocalTime time; //time of item purchase

    public ExpenseModel(double amount, String item, String category, LocalDate date, LocalTime time){
        this.amount = amount;
        this.item = item;
        this.category = category;
        this.date = date;
        this.time = time;
    }

    public ExpenseModel() { //empty constructor so that jpa can fill the fields
    }

    //getter methods to read values
    //setter methods to update values
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public double getAmount(){
        return amount;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public String getItem(){
        return item;
    }
    public void setItem(String item){
        this.item = item;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }
    public LocalTime getTime(){
        return time;
    }
    public void setTime(LocalTime time){
        this.time = time;
    }
}
