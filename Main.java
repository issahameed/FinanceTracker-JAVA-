package com.financetracker;

import java.util.Scanner;

public class Main {
    private static FinanceTracker tracker = new FinanceTracker();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("  Personal Finance Tracker CLI");
        System.out.println("=================================\n");
        
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addTransaction();
                    break;
                case 2:
                    tracker.displayAllTransactions();
                    break;
                case 3:
                    tracker.displaySummary();
                    break;
                case 4:
                    tracker.displaySpendingByCategory();
                    break;
                case 5:
                    setBudget();
                    break;
                case 6:
                    tracker.getBudget().displayBudgets();
                    break;
                case 7:
                    removeTransaction();
                    break;
                case 0:
                    System.out.println("Thank you for using Finance Tracker. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Add Transaction");
        System.out.println("2. View All Transactions");
        System.out.println("3. View Summary");
        System.out.println("4. View Spending by Category");
        System.out.println("5. Set Budget");
        System.out.println("6. View Budgets");
        System.out.println("7. Remove Transaction");
        System.out.println("0. Exit");
    }
    
    private static void addTransaction() {
        System.out.println("\n=== Add Transaction ===");
        System.out.println("Type: 1 for Income, 2 for Expense");
        int type = getIntInput("Enter type: ");
        
        Category category;
        if (type == 1) {
            category = selectIncomeCategory();
        } else if (type == 2) {
            category = selectExpenseCategory();
        } else {
            System.out.println("Invalid type.");
            return;
        }
        
        double amount = getDoubleInput("Enter amount: $");
        if (amount <= 0) {
            System.out.println("Amount must be positive.");
            return;
        }
        
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        
        Transaction transaction = new Transaction(amount, category, description);
        tracker.addTransaction(transaction);
        
        System.out.println("Transaction added successfully!");
    }
    
    private static Category selectIncomeCategory() {
        System.out.println("\nIncome Categories:");
        System.out.println("1. Salary");
        System.out.println("2. Freelance");
        System.out.println("3. Investment");
        System.out.println("4. Other Income");
        
        int choice = getIntInput("Select category: ");
        switch (choice) {
            case 1: return Category.SALARY;
            case 2: return Category.FREELANCE;
            case 3: return Category.INVESTMENT;
            case 4: return Category.OTHER_INCOME;
            default: 
                System.out.println("Invalid choice, defaulting to Other Income");
                return Category.OTHER_INCOME;
        }
    }
    
    private static Category selectExpenseCategory() {
        System.out.println("\nExpense Categories:");
        System.out.println("1. Groceries");
        System.out.println("2. Entertainment");
        System.out.println("3. Transportation");
        System.out.println("4. Utilities");
        System.out.println("5. Healthcare");
        System.out.println("6. Dining Out");
        System.out.println("7. Shopping");
        System.out.println("8. Other Expense");
        
        int choice = getIntInput("Select category: ");
        switch (choice) {
            case 1: return Category.GROCERIES;
            case 2: return Category.ENTERTAINMENT;
            case 3: return Category.TRANSPORTATION;
            case 4: return Category.UTILITIES;
            case 5: return Category.HEALTHCARE;
            case 6: return Category.DINING;
            case 7: return Category.SHOPPING;
            case 8: return Category.OTHER_EXPENSE;
            default: 
                System.out.println("Invalid choice, defaulting to Other Expense");
                return Category.OTHER_EXPENSE;
        }
    }
    
    private static void setBudget() {
        System.out.println("\n=== Set Budget ===");
        Category category = selectExpenseCategory();
        double limit = getDoubleInput("Enter budget limit: $");
        
        if (limit <= 0) {
            System.out.println("Budget must be positive.");
            return;
        }
        
        tracker.getBudget().setLimit(category, limit);
        System.out.printf("Budget set for %s: $%.2f\n", category.getDisplayName(), limit);
    }
    
    private static void removeTransaction() {
        tracker.displayAllTransactions();
        if (tracker.getAllTransactions().isEmpty()) {
            return;
        }
        
        int id = getIntInput("\nEnter transaction ID to remove (0 to cancel): ");
        if (id == 0) {
            return;
        }
        
        tracker.removeTransaction(id);
        System.out.println("Transaction removed successfully!");
    }
    
    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
    
    private static double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}