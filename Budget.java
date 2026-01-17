package com.financetracker;

import java.util.HashMap;
import java.util.Map;

public class Budget {
    private Map<Category, Double> limits;
    
    public Budget() {
        this.limits = new HashMap<>();
    }
    
    public void setLimit(Category category, double limit) {
        if (category.isExpense()) {
            limits.put(category, limit);
        } else {
            System.out.println("Cannot set budget for income category!");
        }
    }
    
    public Double getLimit(Category category) {
        return limits.get(category);
    }
    
    public boolean hasLimit(Category category) {
        return limits.containsKey(category);
    }
    
    public void removeLimit(Category category) {
        limits.remove(category);
    }
    
    public Map<Category, Double> getAllLimits() {
        return new HashMap<>(limits);
    }
    
    public void displayBudgets() {
        if (limits.isEmpty()) {
            System.out.println("No budgets set.");
            return;
        }
        
        System.out.println("\n=== Current Budgets ===");
        for (Map.Entry<Category, Double> entry : limits.entrySet()) {
            System.out.printf("%s: $%.2f\n", 
                entry.getKey().getDisplayName(), entry.getValue());
        }
    }
}
