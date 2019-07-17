package com.company;

public class BankAccount {


    private String firstName;
    private String lastName;
    private double balance;


    public static final int savings = 200;
    public static final int notSavings = 2;

    private int accountType;

    public BankAccount(String firstName, String lastName, double balancee, int accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balancee;
        this.accountType = accountType;
    }

//    Once a final variable has been assigned, it always contains the same value. can't change value of final
//    variable once assigned.


//    The branch argument is true if the customer is performing the transaction at a branch, with a teller
//    It is false if the customer is performing the transaction at an ATM
    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }
//    Branch is an actual bank, so not at a branch means the customer is using an ATM.

    public double withdraw(double amount, boolean branch) {
        if ((amount > 25) && !branch) {
            throw new IllegalArgumentException();
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountType() {
        return accountType;
    }

    public boolean isChecking() {
        return accountType == BankAccount.savings;
    }


//    More methods that use firstName, lastName, and perform other functions.
}


//Need to add j unit library to our project.  Want to write unit tests for bank account class