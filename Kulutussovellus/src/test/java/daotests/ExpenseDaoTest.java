package daotests;

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
    

    
    @Before
    public void setUp() {
        expenseDao = new ExpenseDao();
        expense = new Expense(1, 500, "Asuminen",1);
      
       
    }
    
    @After
    public void tearDown() {
        expenseDao.removeAll();
    }


    
    
    @Test
    public void createMethodWorks() throws Exception{
        
        
        expenseDao.create(new Expense(50, 480, "Vapaa-aika",2));
        assertTrue(expenseDao.read(50).getAmount()==480);
        
        


    }
    
    @Test
    public void readMethodWorks() throws Exception{
        
        expenseDao.create(expense);
        Expense another = expenseDao.read(1);
        int id = another.getId();
        assertEquals(expense.getId(), id);
        
    }
    
    @Test
    public void deleteMethodWorks() throws Exception{
        
        
        expenseDao.create(expense);
        expenseDao.create(new Expense(2, 100.00, "Ruoka",2));
        expenseDao.create(new Expense(3, 600.80, "Asuminen",3));
   
        expenseDao.delete(2);
        
        assertEquals(null, expenseDao.read(2));
        
        
        
      
    }
    
    @Test
    public void updateChangesAmount() throws Exception{
        
        
        expenseDao.create(new Expense(40, 500, "Asuminen",2));
        Expense newExpense = new Expense(40, 400, "Ruoka",3);
        expenseDao.update(newExpense);
        assertTrue(expenseDao.read(40).getAmount()==400);
        
        
    }
    
    @Test
    public void updateChangesType() throws Exception{
        
        
        expenseDao.create(new Expense(40, 500, "Asuminen", 2));
        Expense newExpense = new Expense(40, 400, "Ruoka", 3);
        expenseDao.update(newExpense);
        assertEquals("Ruoka", expenseDao.read(40).getType());
        
        
        
    }
    
    @Test
    public void removeAllRemovesAll() throws Exception{
        expenseDao.create(expense);
        expenseDao.create(new Expense(2, 500, "Ruoka", 2));
        expenseDao.create(new Expense(3, 780, "Ostokset", 3));
        expenseDao.removeAll();
        assertEquals(0, expenseDao.list().size());
        
    }
    
    @Test
    
    public void listReturnsRigtSize() throws Exception{
        
       
        expenseDao.create(expense);
        expenseDao.create(new Expense(2, 200, "Ruoka", 2));
        expenseDao.create(new Expense(3, 300, "Ostokset", 2));
        expenseDao.create(new Expense(4, 500, "Asuminen", 3));
        
        List<Expense> expenseList = expenseDao.list();
        
        assertEquals(4, expenseList.size());
        
    }
    
    @Test
    public void listReturnsRightExpense() throws Exception {
        
       
        expenseDao.create(expense);
        List<Expense> expenseList = expenseDao.list();
        
        assertEquals(expense.toString(), expenseList.get(0).toString());
        
        
        
    }
    
    @Test
    public void listUsingIdReturnsRigthSize() throws Exception {
        
        expenseDao.create(expense);
        expenseDao.create(new Expense(2, 200, "Ruoka", 1));
        expenseDao.create(new Expense(3, 300, "Ostokset", 1));
        expenseDao.create(new Expense(4, 500, "Asuminen", 2));
        
        List<Expense> expenseList = expenseDao.listUsingId(1);
        assertTrue(expenseList.size()==3);
        
    }
    
    
    @Test
    public void listUsingIdSizeIsZero() throws Exception {
        List<Expense> expenseList = expenseDao.listUsingId(1);
        assertEquals(0, expenseList.size());
    }
}
