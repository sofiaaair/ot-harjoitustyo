
package kulutussovellus.domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import kulutussovellus.dao.ExpenseDao;
import kulutussovellus.dao.TablesDao;
import kulutussovellus.dao.UserDao;
import kulutussovellus.domain.Expense;
import kulutussovellus.domain.User;

/**
 * Class is responsible for the communication between the user interface and the application logic.
 */
public class DaoService {
    /* ...*/
    private ExpenseDao expenseDao;
    private UserDao userDao;
    private TablesDao tablesDao;
    
    
    /**
     * Constructor for DaoService object
     */
    public DaoService() {
        expenseDao = new ExpenseDao();
        userDao = new UserDao();
        tablesDao = new TablesDao();
        
    }
    
    /**
     * Constructor with parameters for DaoService object
     * @see kulutussovellus.dao.ExpenseDao
     * @see kulutussovellus.dao.UserDao
     * @see kulutussovellus.dao.TablesDao
     * @param expenseDao the class responsible for retrieving, deleting and storing Expense object's data.
     * @param userDao the class responsible for retrieving, deleting and storing User object's data.
     * @param tablesDao the class responsible for creating SQL database.
     */
    
    public DaoService(ExpenseDao expenseDao, UserDao userDao, TablesDao tablesDao) {
        this.expenseDao = expenseDao;
        this.userDao = userDao;
        this.tablesDao = tablesDao;
    }
    
    /**
     * This method creates Expense object and passes it to expenseDao object, which adds the object to the database
     *
     * @see kulutussovellus.dao.ExpenseDao#create(kulutussovellus.domain.Expense)
     * @param amount desired amount of expense
     * @param type desired type of expense
     * @param id the unique id of the object
     * @throws SQLException 
     */
    public void createExpense(String amount, String type, String id) throws SQLException {
              
        Expense e = new Expense(Double.valueOf(amount), type, Integer.valueOf(id));
        expenseDao.create(e);
        
    }
    
    /**
     * 
     * 
     * @see kulutussovellus.dao.ExpenseDao
     * This method contacts the expenseDao object, which deletes Expense object from the database.
     * @param id the unique id of the object
     * @throws SQLException 
     */
    public void deleteExpense(int id) throws SQLException {
        expenseDao.delete(id);
    }
    

    
 
    /**
     * This method contacts the ExpenseDao to obtain information about the Expense object by type and given user id and returns a list.
     * @see kulutussovellus.dao.ExpenseDao#listUsingType(java.lang.String, java.lang.Integer) 
     * @param type type of expense
     * @param id id of the user who added the expense
     * @return list of all expenses with certain id and type
     * @throws SQLException 
     */
    public String listExpense(String type, int id) throws SQLException {
        double summa = 0;
        String listByType = "";
        List<Expense> expensesOnTheList = expenseDao.listUsingType(type, id);
        for (Expense e: expensesOnTheList) {
            summa += e.getAmount();
            listByType = "" + listByType + "\n" + e.getAmount() + " " + e.getType();
        }
        listByType = listByType + "\n" + "Total sum: " + summa;
        return listByType;
    }
    
    
    /**
     * This method contacts the ExpenseDao object to obtain information about all the expenses with given id and returns total sum of them.
     * 
     * @see kulutussovellus.dao.ExpenseDao#list(java.lang.Integer) 
     * @param id id of the user who added the expense
     * @return sum of all expenses
     * @throws SQLException 
     */
    public double totalSumOfExpenses(int id) throws SQLException {
        double summa = 0;
        List<Expense> expensesOnTheList = expenseDao.list(id);
        for (Expense e: expensesOnTheList) {
            summa += e.getAmount();
        }
        
        return summa;
    }
    
    /**
     * This method contacts to expenseDao to obtain information about all the expenses with given user id and returns a list of them.
     * @param id
     * @see kulutussovellus.dao.ExpenseDao#list(java.lang.Integer) 
     * @return
     * @throws SQLException 
     */
    public List listAllExpenses(int id) throws SQLException {
    
        List<Expense> list = expenseDao.list(id);
        return list;
    }
    
    
    /**
     * This method contacts to tablesDao that creates the database to be used in the application.
     * 
     * @see kulutussovellus.dao.TablesDao#create() 
     * @throws SQLException 
     */
    public void createTablesDao() throws SQLException {

        tablesDao.create();
       
    }
    
    /**
     * This method contacts to userDao to create the new user
     * @see kulutussovellus.dao.UserDao#create(kulutussovellus.domain.User) 
     * @see kulutussovellus.dao.UserDao#list() 
     * @param name user's name
     * @param username desired username
     * @param password user's password
     * @throws SQLException 
     */
    public void createUser(String name, String username, String password) throws SQLException {
        
        userDao.create(new User(userDao.list().size() + 1, name, username, password));
        
        
    }
    
    /** 
     * This method contacts to userDao to obtain the User object with certain id and returns it.
     * 
     * @see kulutussovellus.dao.UserDao#read(java.lang.Integer) 
     * 
     * @param key user's unique id value
     * @return User object with desired id
     * @throws SQLException 
     */
    public User readUser(Integer key) throws SQLException {
        return userDao.read(key);
        
    }
    
    /**
     * Method contacts to userDao to determine if the user's password and username are correct and returns user id if the information is correct, otherwise -999.
     * @see kulutussovellus.dao.UserDao#readUsingUsername(java.lang.String, java.lang.String)
     * @see kulutussovellus.domain.User#getId() 
     * @see kulutussovellus.domain.User#getPassword()
     * @param username user's username
     * @param password user's password
     * @return user's id if username and password are correct, otherwise -999
     * @throws SQLException 
     */
    public int loginUser(String username, String password) throws SQLException {
        
        User user = userDao.readUsingUsername(username, password);
        if (user.getPassword().equals(password)) {
            return user.getId();
        }
        
        return -999;
    }
    
    /**
     * Method contacts to userDao that deletes user with certain id from database.
     * @see kulutussovellus.dao.UserDao#delete(java.lang.Integer) 
     * @param id user's id
     * @throws SQLException 
     */
    public void deleteUser(int id) throws SQLException {
        userDao.delete(id);
    }
    
    
    
}
