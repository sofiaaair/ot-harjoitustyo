
package kulutussovellus.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import kulutussovellus.domain.Expense;
import kulutussovellus.domain.User;


public class DaoService {
    
    private ExpenseDao expenseDao;
    private UserDao userDao;
    private TablesDao tablesDao;
    
    public DaoService() {
        expenseDao = new ExpenseDao();
        userDao = new UserDao();
        tablesDao = new TablesDao();
    }
    
    public DaoService(ExpenseDao expenseDao, UserDao userDao, TablesDao tablesDao) {
        this.expenseDao = expenseDao;
        this.userDao = userDao;
        this.tablesDao = tablesDao;
    }
    
    public void createExpense(String amount, String type, String id) throws SQLException {
            
            
        int number = expenseDao.list().size() + 1;
        Expense e = new Expense(number, Double.valueOf(amount), type, Integer.valueOf(id));
        expenseDao.create(e);
        
    }
    
    
    public String listExpense() throws SQLException {
        
        String textToAdd = "";
        List<Expense> expensesOnTheList = expenseDao.list();
        for (Expense e: expensesOnTheList) {
            textToAdd = "" + textToAdd + "\n" + e.getAmount() + " " + e.getType();
        }
                
        return textToAdd;        
        
    }

    
    public String listExpense(int id) throws SQLException {
        

        String textToAdd = "";
        List<Expense> expensesOnTheList = expenseDao.listUsingId(id);
        for (Expense e: expensesOnTheList) {
            textToAdd = "" + textToAdd + "\n" + e.getAmount() + " " + e.getType();
        }
                
        return textToAdd;

    }
    
    public void createTablesDao() throws SQLException {

        tablesDao.create();
       
    }
    
    public Connection connectToTablesDao() throws SQLException {
        
        Connection connection = tablesDao.connectToDatabase();
        return connection;

        
    }
    
    public void createUser(String name, String username, String password) throws SQLException {
        
        userDao.create(new User(userDao.list().size() + 1, name, username, password));
        
        
    }
    
    public User readUser(Integer key) throws SQLException {
        return userDao.read(key);
    }
    
    public int loginUser(String username, String password) throws SQLException {
        
        User user = userDao.readUsingUsername(username, password);
        if (user.getPassword().equals(password)) {
            return user.getId();
        }
        
        return -999;
    }
    
    
}
