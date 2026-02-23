package com.skcoder.interviewpoints.oops;

import static java.lang.IO.println;

// Abstract class representing an ATM
abstract class ATM {
    // Abstract methods (no implementation here)
    abstract void withdraw(double amount);
    abstract void deposit(double amount);
    abstract void checkBalance();
}

// Concrete class implementing the abstract ATM
class BankATM extends ATM {
    private double balance;

    public BankATM(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            println("Insufficient funds!");
        }
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    void checkBalance() {
        println("Current Balance: " + balance);
    }
}

public class AbstractionMain {
    void main() {
        ATM myATM = new BankATM(1000); // abstraction: we use ATM reference
        myATM.deposit(500);
        myATM.withdraw(300);
        myATM.checkBalance();
    }
}
