package com.financetracker;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FinanceTracker {
    private List<Transaction> transactions;
    private Budget budget;
    
    public FinanceTracker() {
        this.transactions = new ArrayList<>();
        this.budget = new Budget();
    }
    
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        
        // Check budget if it's an expense
        if (transaction.isExpense()) {
            checkBudgetWarning(transaction.getCategory());
        }
    }
    
    public void removeTransaction(int id) {
        transactions.removeIf(t -> t.getId() == id);
    }
    
    public List<Transaction> getAllTransactions() {
        return new ArrayList<>(transactions);
    }
    
    public List<Transaction> getTransactionsByMonth(YearMonth month) {
        return transactions.stream()
            .filter(t -> YearMonth.from(t.getDate()).equals(month))
            .collect(Collectors.toList());
    }
    
    public void displayAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions recorded.");
            return;
        }
        
        System.out.println("\n=== All Transactions ===");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
    
    public void displaySummary1() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions to summarize.");
            return;
        }
        
        double totalIncome = 0;
        double totalExpenses = 0;
        
        for (Transaction t : transactions) {
            if (t.isIncome()) {
                totalIncome += t.getAmount();
            } else {
                totalExpenses += t.getAmount();
            }
        }
        
        System.out.println("\n=== Financial Summary ===");
        System.out.printf("Total Income:    +$%.2f\n", totalIncome);
        System.out.printf("Total Expenses:  -$%.2f\n", totalExpenses);
        System.out.printf("Net Balance:     $%.2f\n", totalIncome - totalExpenses);
    }
    
    public void displaySpendingByCategory() {
        Map<Category, Double> categoryTotals = new HashMap<>();
        
        for (Transaction t : transactions) {
            if (t.isExpense()) {
                categoryTotals.merge(t.getCategory(), t.getAmount(), Double::sum);
            }
        }
        
        if (categoryTotals.isEmpty()) {
            System.out.println("No expenses recorded.");
            return;
        }
        
        System.out.println("\n=== Spending by Category ===");
        for (Map.Entry<Category, Double> entry : categoryTotals.entrySet()) {
            Category cat = entry.getKey();
            double spent = entry.getValue();
            
            System.out.printf("%s: $%.2f", cat.getDisplayName(), spent);
            
            if (budget.hasLimit(cat)) {
                double limit = budget.getLimit(cat);
                double percentage = (spent / limit) * 100;
                System.out.printf(" (%.1f%% of $%.2f budget)", percentage, limit);
            }
            System.out.println();
        }
    }
    
    private void checkBudgetWarning(Category category) {
        if (!budget.hasLimit(category)) {
            return;
        }
        
        double spent = transactions.stream()
            .filter(t -> t.getCategory() == category && t.isExpense())
            .mapToDouble(Transaction::getAmount)
            .sum();
        
        double limit = budget.getLimit(category);
        double percentage = (spent / limit) * 100;
        
        if (percentage >= 100) {
            System.out.printf("\n⚠️  WARNING: You've exceeded your %s budget! ($%.2f / $%.2f)\n", 
                category.getDisplayName(), spent, limit);
        } else if (percentage >= 80) {
            System.out.printf("\n⚠️  WARNING: You've used %.1f%% of your %s budget ($%.2f / $%.2f)\n", 
                percentage, category.getDisplayName(), spent, limit);
        }
    }
    
    public Budget getBudget() {
        return budget;
    }

	public void displaySummary() {
		// TODO Auto-generated method stub
		
	}
}