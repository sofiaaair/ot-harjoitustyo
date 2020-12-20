/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daotests;


import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import kulutussovellus.domain.DaoService;
import kulutussovellus.dao.ExpenseDao;
import kulutussovellus.dao.TablesDao;
import kulutussovellus.dao.UserDao;
import kulutussovellus.domain.Expense;
import kulutussovellus.domain.User;
import org.junit.After;
import org.junit.Before;
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
    Expense expense;
    User user;
    
    public DaoServiceTest() {
    }
    

    
    @Before
    public void setUp() {
        
        daoService = new DaoService();
        expenseDao = new ExpenseDao();
        userDao = new UserDao();
        expenseDao.removeAll();
        userDao.removeAll();
        tablesDao = new TablesDao();
        expense = new Expense(400, "housing", 1);
        user = new User(1, "Mikko Mallikas", "Mikk088", "12345");
        
    }
    
    @After
    public void tearDown(){
        expenseDao.removeAll();
        userDao.removeAll();
    }
    
    
    @Test
    public void deleteUserDeletesUser() throws Exception {
        daoService.deleteUser(1);
        assertTrue(daoService.listAllExpenses(1).isEmpty());
    }
    
    @Test
    public void deleteExpenseDeletesExpense() throws Exception {
        daoService.createExpense("400", "Housing", "1");
        daoService.createExpense("500", "food", "1");
        daoService.deleteExpense(1);
        assertTrue(daoService.totalSumOfExpenses(1)==500);
    }
    
    @Test
    public void listAllExpensesReturnsRightSum() throws Exception {
        daoService.createExpense("300", "housing", "2");
        daoService.createExpense("5.5", "food", "2");
        daoService.createExpense("65", "food", "2");
        
        assertTrue(daoService.totalSumOfExpenses(2) == 370.5);
    }
    
    @Test
    public void loginUserReturnsRightValue() throws Exception {
        userDao.create(user);
        int number = daoService.loginUser("Mikk088", "12345");
        
        assertTrue(number==1);
    }
    


    @Test
    public void listExpenseListsCorrectly() throws Exception {
        
        userDao.create(user);
        expenseDao.create(expense);
        daoService.createExpense("500", "housing", "1");
        daoService.createExpense("500", "food", "1");
        daoService.createExpense("500", "other", "1");
        daoService.createExpense("500", "housing", "1");
        
        assertTrue(daoService.listAllExpenses(1).size() == 5);
        
    }
    
    @Test
    public void readReturnsRigthName() throws Exception {
        userDao.create(user);
        User anotherUser = userDao.read(1);
        assertTrue(user.getName().equals(anotherUser.getName()));
        
    }
    
    @Test
    public void createUserCreatesUser() throws Exception {
        
        daoService.createUser("Sara", "Gamer88", "12345");
        daoService.createUser("Fia", "Fisu", "skfm23");
        assertFalse(userDao.read(2).getName().isEmpty());
        
    }
    
    @Test
    public void listByExpenseReturnsRigthString() throws Exception{
        
        userDao.create(user);
        daoService.createExpense("500", "housing", "1");
        daoService.createExpense("500", "food", "1");
        daoService.createExpense("500", "other", "1");
        daoService.createExpense("500", "housing", "1");
        
        assertEquals("\n500.0 housing\n500.0 housing\nTotal sum: 1000.0", daoService.listExpense("housing", 1));
    }

    
    
}
