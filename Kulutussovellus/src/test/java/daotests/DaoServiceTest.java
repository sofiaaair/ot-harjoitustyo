/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daotests;


import java.sql.SQLException;
import kulutussovellus.dao.DaoService;
import kulutussovellus.dao.ExpenseDao;
import kulutussovellus.dao.TablesDao;
import kulutussovellus.dao.UserDao;
import kulutussovellus.domain.Expense;
import kulutussovellus.domain.User;
import static org.hamcrest.CoreMatchers.isA;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.sqlite.jdbc4.JDBC4Connection;

/**
 *
 * @author airassof
 */
public class DaoServiceTest {
    
    DaoService daoService;
    ExpenseDao expenseDao;
    UserDao userDao;
    TablesDao tablesDao;
    
    public DaoServiceTest() {
    }
    

    
    @Before
    public void setUp() {
        daoService = new DaoService();
        expenseDao = new ExpenseDao();
        userDao = new UserDao();
        tablesDao = new TablesDao();
    }
    
    


    @Test
    public void connectToTablesDaoReturnsConnection() throws Exception {
    
        assertEquals(JDBC4Connection.class, daoService.connectToTablesDao().getClass());
        
        
    }
    
    @Test
    public void listExpenseReturnsString() throws Exception {
        
        String testedString = daoService.listExpense();
        assertThat(testedString,isA(String.class));
        
    }
    

    
    
}
