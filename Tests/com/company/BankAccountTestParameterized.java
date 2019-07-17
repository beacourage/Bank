package com.company;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount myaccount;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Before
    public void setup() {
        myaccount = new BankAccount("Beatrice","Courage", 1000, BankAccount.savings);
        System.out.println("Running test");
    }


    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {100, true, 1100},
                {200, true, 1200},
                {325, true, 1325},
                {489.94, true, 1489.94},
                {1000, true, 2000},

        });
    }

    @Test
    public void deposit() {
        myaccount.deposit(amount, branch);
        assertEquals(expected, myaccount.getBalance(), 0);
    }









}
//We need to tell j unit that this is not a normal test class.
// We are gonna tell Junit the parameters we want to use,
//    by adding a static method annotated with at parameters notation and that method meeds to return a collection.

//    Shows set of parameters we want to test followed by the expected value
//    When we run the parameterize test, j unit will create a new instance of bank account test parameterised class for each set of test data
//      and j unit will use the class constructor to set instance variavles to the values specidied
//    1. need to add instrance variables for the deposit amount, branch value, expected amount.
//    2. need to add a constructor that accepts the values and sets the instance variables.

// Thats how we run a bunch or tests on the same methods, work to set up, cuts down on amount of test code we have to maintain.