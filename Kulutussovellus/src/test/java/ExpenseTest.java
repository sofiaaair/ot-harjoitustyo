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
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        expense = new Expense(1, 500, "Asuminen");
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void constructorSetCorrectValues() {
        assertEquals("1 500 Asuminen", expense.toString());
    }
    
    @Test
    public void typeUpdateWorks(){
        expense.setType("Ruoka");
        assertEquals("1 500 Ruoka", expense.toString());
    }
    
    @Test
    public void amountUpdateWorks(){
        expense.setAmount(50);
        assertEquals("1 50 Asuminen", expense.toString());
    }
    
    @Test
    public void amountGetterWorks(){
        assertEquals(500, expense.getAmount());
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
        Expense anotherExpense = new Expense(100, "Ruoka");
        assertEquals(100, anotherExpense.getAmount());
        assertEquals("Ruoka", anotherExpense.getType());
    }
}
