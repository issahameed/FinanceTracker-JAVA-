package com.financetracker;

import java.time.LocalDate;

public class Transaction {
    private static int idCounter = 1;
    
    private int id;
    private double amount;
    private Category category;
    private String description;
    private LocalDate date;
    
    public Transaction(double amount, Category category, String description, LocalDate date) {
        this.id = idCounter++;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }
    
    // Constructor with current date
    public Transaction(double amount, Category category, String description) {
        this(amount, category, description, LocalDate.now());
    }
    
    // Getters
    public int getId() { return id; }
    public double getAmount() { return amount; }
    public Category getCategory() { return category; }
    public String getDescription() { return description; }
    public LocalDate getDate() { return date; }
    
    public boolean isIncome() {
        return category.isIncome();
    }
    
    public boolean isExpense() {
        return category.isExpense();
    }
    
    @Override
    public String toString() {
        String type = isIncome() ? "+" : "-";
        return String.format("ID: %d | %s | %s$%.2f | %s | %s", 
            id, date, type, amount, category.getDisplayName(), description);
    }
}