package com.skcoder.interviewpoints.oops;

import static java.lang.IO.println;

// Example of Encapsulation in Java
class BankAccount {
    // Private variables (data hidden from outside)
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public getter method (controlled access)
    public double getBalance() {
        return balance;
    }

    // Public method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Public method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}

public class EncapsulationMain {
    void main() {
        BankAccount account = new BankAccount("Alice", 1000);
        // Accessing data only through public methods
        println("Initial Balance: " + account.getBalance());
        account.deposit(500);
        account.withdraw(300);
        println("Final Balance: " + account.getBalance());
    }
}
