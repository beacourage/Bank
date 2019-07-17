package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello we are printing ");
        BankAccount account = new BankAccount("Bea","Courage", 200, BankAccount.savings);
        System.out.println(BankAccount.savings);
//        Account has already been initialised.
        System.out.println(account.getAccountType());

        BankAccount account2 = new BankAccount("Beatrice","Courage", 200, BankAccount.savings);

        account2.withdraw(30, false);
        System.out.println(account2.getBalance());
    }
}
