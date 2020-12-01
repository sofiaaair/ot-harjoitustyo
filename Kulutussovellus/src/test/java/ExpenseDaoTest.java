/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kulutussovellus.dao.ExpenseDao;
import kulutussovellus.domain.Expense;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author airassof
 */
public class ExpenseDaoTest {
    
    ExpenseDao expenseDao;
    Expense expense;
  
    
    public ExpenseDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        expenseDao = new ExpenseDao();
        expense = new Expense(1, 500, "Asuminen");
      
       
    }
    
    @After
    public void tearDown() {
    }


    
    
    @Test
    public void createMethodWorks() throws Exception{
        
        expenseDao.removeAll();
        expenseDao.create(new Expense(50, 480, "Vapaa-aika"));
        assertEquals(480, expenseDao.read(50).getAmount());
        expenseDao.removeAll();
        


    }
    
    @Test
    public void readMethodWorks() throws Exception{
        expenseDao.removeAll();
        expenseDao.create(expense);
        Expense another = expenseDao.read(1);
        int id = another.getId();
        assertEquals(expense.getId(), id);
        expenseDao.removeAll();
    }
    
    @Test
    public void deleteMethodWorks() throws Exception{
        expenseDao.removeAll();
        
        expenseDao.create(expense);
        expenseDao.create(new Expense(2, 100, "Ruoka"));
        expenseDao.create(new Expense(3, 600, "Asuminen"));
   
        expenseDao.delete(2);
        
        assertEquals(null, expenseDao.read(2));
        
        expenseDao.removeAll();
        
      
    }
    
    @Test
    public void updateChangesAmount() throws Exception{
        expenseDao.removeAll();
        
        expenseDao.create(new Expense(40, 500, "Asuminen"));
        Expense newExpense = new Expense(40, 400, "Ruoka");
        expenseDao.update(newExpense);
        assertEquals(400, expenseDao.read(40).getAmount());
        expenseDao.removeAll();
        
    }
    
    @Test
    public void updateChangesType() throws Exception{
        expenseDao.removeAll();
        
        expenseDao.create(new Expense(40, 500, "Asuminen"));
        Expense newExpense = new Expense(40, 400, "Ruoka");
        expenseDao.update(newExpense);
        assertEquals("Ruoka", expenseDao.read(40).getType());
        expenseDao.removeAll();
        
        
    }
    
    @Test
    public void removeAllRemovesAll() throws Exception{
        expenseDao.create(expense);
        expenseDao.create(new Expense(2, 500, "Ruoka"));
        expenseDao.create(new Expense(3, 780, "Ostokset"));
        expenseDao.removeAll();
        assertEquals(0, expenseDao.list().size());
        
    }
    
    @Test
    
    public void listReturnsRigtSize() throws Exception{
        
        expenseDao.removeAll();
        expenseDao.create(expense);
        expenseDao.create(new Expense(2, 200, "Ruoka"));
        expenseDao.create(new Expense(3, 300, "Ostokset"));
        expenseDao.create(new Expense(4, 500, "Asuminen"));
        
        List<Expense> expenseList = expenseDao.list();
        
        assertEquals(4, expenseList.size());
        expenseDao.removeAll();
    }
    
    @Test
    public void listReturnsRightExpense() throws Exception{
        
        expenseDao.removeAll();
        expenseDao.create(expense);
        List<Expense> expenseList = expenseDao.list();
        
        assertEquals(expense.toString(), expenseList.get(0).toString());
        expenseDao.removeAll();
        
        
    }
    
}
