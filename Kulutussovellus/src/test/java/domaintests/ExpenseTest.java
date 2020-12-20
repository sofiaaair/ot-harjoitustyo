package domaintests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import kulutussovellus.domain.Expense;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ExpenseTest {
    
    Expense expense;
    
    public ExpenseTest() {
    }

    
    @Before
    public void setUp() {
        expense = new Expense(1, 500.0, "Asuminen", 1);
    }
    

    @Test
    public void constructorSetCorrectValues() {
        assertEquals("500.0 Asuminen", expense.toString());
    }
    
    @Test
    public void typeUpdateWorks(){
        expense.setType("Ruoka");
        assertEquals("500.0 Ruoka", expense.toString());
    }
    
    @Test
    public void amountUpdateWorks(){
        expense.setAmount(50.0);
        assertEquals("50.0 Asuminen", expense.toString());
    }
    
    @Test
    public void amountGetterWorks(){
        assertTrue(expense.getAmount()==500.0);
    }
    
    @Test
    public void idGetterWorks(){
        assertEquals(1, expense.getId());
    }
    
    @Test
    public void typeGetterWorks(){
        assertEquals("Asuminen", expense.getType());
    }
    
    @Test
    public void anotherConstructerWorks(){
        Expense anotherExpense = new Expense(2, 100.5, "Ruoka",2);
        assertTrue(anotherExpense.getAmount() == 100.5);
        assertEquals("Ruoka", anotherExpense.getType());
    }
}
