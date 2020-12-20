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
import kulutussovellus.dao.TablesDao;
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
    
    TablesDao tablesDao;
    ExpenseDao expenseDao;
    Expense expense;
  
    
    public ExpenseDaoTest() {
    }

    @Before
    public void setUp() {
        expenseDao = new ExpenseDao();
        tablesDao = new TablesDao();
        tablesDao.create();
        expenseDao.removeAll();
        expense = new Expense(1, 500, "Asuminen",1);
        tablesDao.create();
      
       
    }
    
    @After
    public void tearDown() {
        expenseDao.removeAll();
    }


    
    
    @Test
    public void createMethodWorks() throws Exception{
        
        Expense e = new Expense(1, 480, "Vapaa-aika", 2);
        expenseDao.create(e);
        assertTrue(expenseDao.read(1).getAmount()==480);
        
        


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
        Expense e = new Expense(100.00, "Ruoka",2);
        Expense e2 = new Expense(600.80, "Asuminen", 3);
        expenseDao.create(e);
        expenseDao.create(e2);
   
        expenseDao.delete(2);
        
        assertEquals(null, expenseDao.read(2));
        
        
        
      
    }
    
    @Test
    public void updateChangesAmount() throws Exception{
        
        Expense expense1 = new Expense(1, 500, "Asuminen", 2);
        expenseDao.create(expense1);
        Expense expense2 = new Expense(1, 400, "Ruoka", 2);
        expenseDao.update(expense2);
        assertTrue(expenseDao.read(1).getAmount() == 400);
        
        
    }
    
    @Test
    public void updateChangesType() throws Exception{
        
        
        Expense oldExpense = new Expense(1, 500, "Asuminen", 2);
        expenseDao.create(oldExpense);
        Expense newExpense = new Expense(1, 400, "Ruoka", 3);
        expenseDao.update(newExpense);
        assertEquals("Ruoka", expenseDao.read(1).getType());
        
        
        
    }
    
    @Test
    public void removeAllRemovesAll() throws Exception{
        expenseDao.create(expense);
        expenseDao.create(new Expense(500, "Ruoka", 1));
        expenseDao.create(new Expense(780, "Ostokset", 1));
        expenseDao.removeAll();
        assertEquals(0, expenseDao.list(1).size());
        
    }
    
    @Test
    
    public void listReturnsRigtSize() throws Exception{
        
       
        expenseDao.create(expense);
        expenseDao.create(new Expense(200, "Ruoka", 1));
        expenseDao.create(new Expense(300, "Ostokset", 1));
        expenseDao.create(new Expense(500, "Asuminen", 1));
        
        List<Expense> expenseList = expenseDao.list(1);
        
        assertEquals(4, expenseList.size());
        
    }
    
    @Test
    public void listReturnsRightExpense() throws Exception {
        
       
        expenseDao.create(expense);
        List<Expense> expenseList = expenseDao.list(1);
        
        assertEquals(expense.toString(), expenseList.get(0).toString());
        
        
        
    }
    
    @Test
    public void listUsingIdReturnsRigthSize() throws Exception {
        
        expenseDao.create(expense);
        expenseDao.create(new Expense(200, "Ruoka", 1));
        expenseDao.create(new Expense(300, "Ostokset", 1));
        expenseDao.create(new Expense(500, "Asuminen", 2));
        
        List<Expense> expenseList = expenseDao.list(1);
        assertTrue(expenseList.size()==3);
        
    }
    
    
    @Test
    public void listUsingIdSizeIsZero() throws Exception {
        List<Expense> expenseList = expenseDao.list(1);
        assertEquals(0, expenseList.size());
    }
}
