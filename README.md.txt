# 💰 Personal Finance Tracker - Java CLI

A command-line personal finance management application built with Java. Track your income, expenses, set budgets, and manage your finances directly from your terminal.

## 🌟 Features

- ✅ **Track Transactions**: Add income and expenses with detailed categorization
- ✅ **Transaction History**: View all your financial transactions with dates and descriptions
- ✅ **Financial Summary**: Get instant overview of total income, expenses, and net balance
- ✅ **Category Analysis**: See spending breakdown by category
- ✅ **Budget Management**: Set spending limits for different expense categories
- ✅ **Smart Warnings**: Get alerts when approaching or exceeding budget limits (80% and 100%)
- ✅ **Transaction Management**: Remove unwanted transactions by ID
- ✅ **User-Friendly CLI**: Clean, menu-driven interface with input validation

## 📋 Prerequisites

Before running this application, make sure you have:

- **Java Development Kit (JDK) 8 or higher**
  - Check your version: `java -version`
  - Download from: [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://openjdk.org/)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/issahameed/FinanceTracker-JAVA-.git
cd FinanceTracker-JAVA-
```

### 2. Compile the Project

**Option A: Using Command Line**

Navigate to the source directory and compile:
```bash
cd src/com/financetracker
javac *.java
```

**Option B: Using Eclipse**
1. Open Eclipse IDE
2. File → Import → General → Existing Projects into Workspace
3. Select the project folder
4. The project should compile automatically

**Option C: Using IntelliJ IDEA**
1. Open IntelliJ IDEA
2. File → Open → Select the project folder
3. IntelliJ will automatically detect and configure the project

### 3. Run the Application

**Option A: Command Line**
```bash
# From the src directory
java com.financetracker.Main
```

**Option B: Eclipse**
1. Right-click on `Main.java` in Package Explorer
2. Run As → Java Application

**Option C: IntelliJ IDEA**
1. Right-click on `Main.java` in Project view
2. Run 'Main.main()'

## 📖 How to Use

### Main Menu

When you start the application, you'll see:

```
=================================
  Personal Finance Tracker CLI
=================================

=== Main Menu ===
1. Add Transaction
2. View All Transactions
3. View Summary
4. View Spending by Category
5. Set Budget
6. View Budgets
7. Remove Transaction
0. Exit
```

### Usage Examples

#### Adding Income
1. Select option `1` (Add Transaction)
2. Choose `1` for Income
3. Select category (e.g., `1` for Salary)
4. Enter amount (e.g., `3000`)
5. Enter description (e.g., "Monthly salary")

#### Adding Expense
1. Select option `1` (Add Transaction)
2. Choose `2` for Expense
3. Select category (e.g., `1` for Groceries)
4. Enter amount (e.g., `150.50`)
5. Enter description (e.g., "Weekly shopping")

#### Setting Budget
1. Select option `5` (Set Budget)
2. Choose expense category
3. Enter budget limit (e.g., `500` for monthly groceries)
4. System will warn you when you reach 80% or exceed 100%

#### Viewing Summary
Select option `3` to see:
```
=== Financial Summary ===
Total Income:    +$3000.00
Total Expenses:  -$450.75
Net Balance:     $2549.25
```

## 🎨 Categories

### Income Categories
- **Salary**: Regular employment income
- **Freelance**: Independent contractor work
- **Investment**: Returns from investments
- **Other Income**: Miscellaneous income sources

### Expense Categories
- **Groceries**: Food and household items
- **Entertainment**: Movies, games, hobbies
- **Transportation**: Gas, public transit, car maintenance
- **Utilities**: Electricity, water, internet, phone
- **Healthcare**: Medical expenses, insurance
- **Dining Out**: Restaurants, takeout, coffee shops
- **Shopping**: Clothing, electronics, general purchases
- **Other Expense**: Miscellaneous expenses

## 📁 Project Structure

```
FinanceTracker-JAVA-/
└── src/
    └── com/
        └── financetracker/
            ├── Main.java            # Entry point and CLI interface
            ├── FinanceTracker.java  # Core business logic
            ├── Transaction.java     # Transaction data model
            ├── Category.java        # Category enumeration
            └── Budget.java          # Budget management
```

### File Descriptions

**Main.java**
- Handles user interface and menu navigation
- Processes user input with validation
- Manages the main application loop

**FinanceTracker.java**
- Core application logic
- Manages transaction list
- Calculates summaries and category totals
- Checks budget warnings

**Transaction.java**
- Represents a single financial transaction
- Stores amount, category, description, and date
- Auto-generates unique IDs

**Category.java**
- Enum defining all income and expense categories
- Helper methods to check if category is income or expense

**Budget.java**
- Manages budget limits for expense categories
- Stores and retrieves budget information

## 🔔 Budget Warning System

The application provides two levels of warnings:

### 80% Warning (Yellow)
```
⚠️  WARNING: You've used 85.0% of your Groceries budget ($425.00 / $500.00)
```

### 100% Warning (Red)
```
⚠️  WARNING: You've exceeded your Groceries budget! ($520.00 / $500.00)
```

## 💾 Data Persistence

**Note:** The current version stores data **in memory only**. This means:
- ✅ Data persists during the application session
- ❌ Data is lost when you close the application

### Future Enhancement: File Persistence
To add data persistence, you can:
1. Save transactions to a JSON or CSV file on exit
2. Load transactions from file on startup
3. Consider using a database (SQLite, H2) for advanced features

## 🛠️ Troubleshooting

### Common Issues

**Problem:** `javac: command not found`
- **Solution:** Install JDK and ensure it's in your system PATH

**Problem:** `Error: Could not find or load main class`
- **Solution:** Make sure you're running from the correct directory and the package structure matches

**Problem:** `package com.financetracker does not exist`
- **Solution:** Ensure all `.java` files have `package com.financetracker;` at the top

**Problem:** Eclipse shows "Main method not found"
- **Solution:** 
  1. Clean the project (Project → Clean)
  2. Ensure all files are saved
  3. Refresh the project (F5)

## 🎯 Usage Tips

1. **Start with Income**: Add your income sources first to establish your baseline
2. **Set Realistic Budgets**: Base budgets on your actual spending patterns
3. **Review Regularly**: Check your summary weekly to stay on track
4. **Use Descriptions**: Add clear descriptions to remember transactions later
5. **Monitor Warnings**: Pay attention to budget warnings to avoid overspending

## 🚀 Future Enhancements

Planned features for future versions:

- [ ] **File Persistence**: Save/load data from JSON or CSV files
- [ ] **Date Filtering**: View transactions by date range
- [ ] **Monthly Reports**: Automatic monthly summaries
- [ ] **Recurring Transactions**: Set up automatic monthly bills
- [ ] **Data Export**: Export to Excel or PDF
- [ ] **Charts**: ASCII art charts for visual representation
- [ ] **Search**: Find specific transactions
- [ ] **Categories Management**: Add custom categories
- [ ] **Multi-user Support**: Track finances for multiple people
- [ ] **Database Integration**: Use SQLite for robust data storage

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. **Fork** the repository
2. **Create** a feature branch
   ```bash
   git checkout -b feature/AmazingFeature
   ```
3. **Commit** your changes
   ```bash
   git commit -m 'Add some AmazingFeature'
   ```
4. **Push** to the branch
   ```bash
   git push origin feature/AmazingFeature
   ```
5. **Open** a Pull Request

### Coding Guidelines
- Follow Java naming conventions
- Add comments for complex logic
- Test thoroughly before submitting
- Update documentation for new features

## 📚 Learning Objectives

This project demonstrates:
- Object-Oriented Programming (OOP) principles
- Java Collections (ArrayList, HashMap)
- Enum usage
- User input handling and validation
- Date and time manipulation with LocalDate
- String formatting with printf
- Exception handling
- Package organization

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**Issa Hameed**
- GitHub: [@issahameed](https://github.com/issahameed)
- Project: [FinanceTracker-JAVA-](https://github.com/issahameed/FinanceTracker-JAVA-)

## 🙏 Acknowledgments

- Built as a learning project to practice Java programming
- Inspired by the need for simple, command-line financial tools
- Thanks to the Java community for excellent documentation

## Support 

If you encounter any issues or have questions:
1. Check the Troubleshooting section above
2. Search existing issues on GitHub
3. Open a new issue with details about your problem

---

**⭐ If you find this project helpful, please consider giving it a star on GitHub!**

**💡 Tip:** For a web-based version with persistent storage, check out the `index.html` file in this repository!