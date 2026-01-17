package com.financetracker;

public enum Category {
    // Expense categories
    GROCERIES("Groceries"),
    ENTERTAINMENT("Entertainment"),
    TRANSPORTATION("Transportation"),
    UTILITIES("Utilities"),
    HEALTHCARE("Healthcare"),
    DINING("Dining Out"),
    SHOPPING("Shopping"),
    OTHER_EXPENSE("Other Expense"),
    
    // Income categories
    SALARY("Salary"),
    FREELANCE("Freelance"),
    INVESTMENT("Investment"),
    OTHER_INCOME("Other Income");
    
    private final String displayName;
    
    Category(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
    
    public boolean isIncome() {
        return this == SALARY || this == FREELANCE || 
               this == INVESTMENT || this == OTHER_INCOME;
    }
    
    public boolean isExpense() {
        return !isIncome();
    }
}
