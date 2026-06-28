package com.sanz.xpensto.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    Coloumn(nullable = false, unique = true)
    Private String email;
    @Coloumn(nullable = false)
    private String password;
    private String role; // to set roles like admin/user later on
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExpenseModel> expenses = new ArrayList<>();

    public UserModel(){
    }
    public UserModel(String name, String email, String password, string role){
        this.name = name;
        this.email= email;
        this.password = password;
        this.role = role;
    }

    @PrePersist
    public void PrePersist(){
        this.createdAt = LocalDateTime.now();
        if( this.role == null || this.role.isBlank()){
            this.role = "USER";
        }
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public List<ExpenseModel> getExpenses(){
        return expenses;
    }
    public void setExpenses(List<ExpenseModel> expenses){
        this.expenses = expenses;
    }
}