package com.company;
import org.junit.*;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;



public class BankAccountTest {

    private BankAccount account;
    private static int count;

   @BeforeClass
   public static void beforeClass() {
       System.out.println("This executes before any test cases. Count =" + count++ );
   }



    @Before
    public void setup() {
        account = new BankAccount("Beatrice","Courage", 200, BankAccount.savings);
        System.out.println("Running test");
    }



    @DisplayName("User can deposit money into bank account")
    @Test
    public void deposit() {
        double balance = account.deposit(20, true);
//        deposit method returns the new balance.
        assertEquals(220, balance, 0);
    }

    @Test
    public void withdraw_branch()  {
        double balance = account.withdraw(30,true);
        assertEquals(170, balance, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch()  {
       account.withdraw(30,false);
       fail("Should have thrown an illegal exception");
    }

//    @Test
//    public void withdraw_notBranch() {
//       try {
//           account.withdraw(30,false);
//             fail("Should have thrown an illegal argument exception");
//       } catch(IllegalArgumentException e ){
//       }
//    }
//We are expecting an exception to be thrown ^^

    @Test
    public void getBalance_deposit() {
        account.deposit(20, true);
        assertEquals(220, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() {
        account.withdraw(20, true);
        assertEquals("Test has FAILED",180, account.getBalance(), 0);
    }

    @Test
    public void checkingAccount() {
        assertTrue("Not a saving account", account.isChecking());
    }

    @AfterClass
    public static void  afterClass() {
        System.out.println("This executes after. Count = " + count++);
    }

    @After
    public void afterWardds() {
        System.out.println("Count = " + count++);
    }

}

// he delta value is indeed the "error" or "uncertainty" allowed in the comparison. Comparing floating point numbers is tricky -- exact equality is hard to come by in many cases.
// It's quite common for the delta to be much smaller than the actual values -- for no particular reason, I generally use 1e-8, and this works well.
//Delta allows for a bit of leeway in comparisons


//All we have in the test class so far are stubs, which is another word for empty methods.
//@Test
//public void getBalance1() {
//}
//So the tests should not have all passed.
//Need all our tests to call j unit fail methods, otherwise we think that we've tested applicxation when we haven't.
//Get into habit of adding a call to fail to any new test method to ensure we aren't running test stubs

//junit-
//  TEST THE OUTPUT OF A METHOD AGAINST
//  AN ASSERTION THAT WE'VE MADE ABOUT THE EXPECTED OUTPUT
// OUTPUT = EXPECTED --> PASSING TEST
// OUTPUT != EXPECTED --> FAILS


//assertequals(expected, actual_value (value we wanna test))