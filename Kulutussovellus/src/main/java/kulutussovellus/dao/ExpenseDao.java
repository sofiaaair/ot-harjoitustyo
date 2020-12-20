
package kulutussovellus.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kulutussovellus.domain.Expense;

/**
 * Class is responsible for connecting to the database and adding, deleting and editing expenses.
 * 
 */
public class ExpenseDao implements Dao<Expense, Integer> {
    /* ... */
    TablesDao tablesDao = new TablesDao();
    Connection connection;
    PreparedStatement s;

    /**
     * Method creates contact to the database and creates the expense.
     * @see kulutussovellus.dao.TablesDao#connectToDatabase() 
     * @param expense Expense with information about user id, amount and expense type
     * @throws SQLException 
     */
    @Override
    public void create(Expense expense) throws SQLException {

        connection = tablesDao.connectToDatabase();
        PreparedStatement s = connection.prepareStatement("INSERT INTO Expense"
            + "(amount, type, user_id)"
            + "VALUES(?,?,?)"); 
        s.setDouble(1, expense.getAmount());
        s.setString(2, expense.getType());
        s.setInt(3, expense.getUserId());
        s.executeUpdate();
        s.close();
        connection.close();

        
    }
    
    /**
     * Method contacts the database to obtain information about expense with certain id. 
     * @see kulutussovellus.dao.TablesDao#connectToDatabase() 
     * @param key expense's unique id value
     * @return expense
     * @throws SQLException 
     */
    @Override
    public Expense read(Integer key) throws SQLException {

        connection = tablesDao.connectToDatabase();
        s = connection.prepareStatement("SELECT * FROM Expense WHERE id = ?");
        s.setInt(1, key);
        ResultSet rs = s.executeQuery();
        if (!rs.next()) {
            return null;
        }
        
        Expense e = new Expense(rs.getInt("id"), rs.getDouble("amount"), rs.getString("type"), rs.getInt("user_id"));
        
        s.close();
        rs.close();
        connection.close();
        
        return e;

    }

    /**
     * Method contacts the database to update the expense information and return expense with new information.
     * @see kulutussovellus.dao.TablesDao#connectToDatabase() 
     * @param expense the expense to update
     * @return the expense with new information
     * @throws SQLException 
     */
    @Override
    public Expense update(Expense expense) throws SQLException {
        
        connection = tablesDao.connectToDatabase();
        s = connection.prepareStatement("UPDATE Expense SET amount = ?, type = ? WHERE id = ?");
        s.setDouble(1, expense.getAmount());
        s.setString(2, expense.getType());
        s.setInt(3, expense.getId());
        s.executeUpdate();
        
        Expense newExpense = read(expense.getId());
        s.close();
        connection.close();
        
        return newExpense;
        
    }

    /**
     * Method contacts the database to delete expense with certain id.
     * @see kulutussovellus.dao.TablesDao#connectToDatabase() 
     * @param key id of the expense to be deleted
     * @throws SQLException 
     */
    @Override
    public void delete(Integer key) throws SQLException {

        connection = tablesDao.connectToDatabase();
        s = connection.prepareStatement("DELETE FROM Expense WHERE id = ? ");
        s.setInt(1, key);
        s.executeUpdate();
        s.close();
        connection.close();
            

    }

    /**
     * Method contacts the database to delete all expenses.
     * @see kulutussovellus.dao.TablesDao#connectToDatabase() 
     */
    public void removeAll() {
        
        try {
            connection = tablesDao.connectToDatabase();
            s = connection.prepareStatement("DELETE FROM Expense");
            s.executeUpdate();
            s.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while removing");
        }
        
    }
    

    
    /**
     * Method contacts the database to obtain information of expenses with certain user id and returns a list of them.
     * @see kulutussovellus.dao.TablesDao#connectToDatabase() 
     * @param id id of user who created the expense
     * @return list of all expenses with certain user id
     * @throws SQLException 
     */    
    public List<Expense> list(Integer id) throws SQLException {
        List<Expense> list = new ArrayList<>();
        connection = tablesDao.connectToDatabase();
        s = connection.prepareStatement("SELECT * FROM Expense where user_id = ?");
        s.setInt(1, id);
        ResultSet rs = s.executeQuery();
        while (rs.next()) {
            list.add(new Expense(rs.getInt("id"), rs.getDouble("amount"), rs.getString("type"), rs.getInt("user_id")));
        }
        s.close();
        rs.close();
        connection.close();
        
        return list;
       
        
    }
    /**
     * Method contacts the database for obtain information of expense with certain user id and type of expense and returns a list of them.
     * @see kulutussovellus.dao.TablesDao#connectToDatabase() 
     * @param type type of expense
     * @param id id of user who added the expense
     * @return list of expenses with certain user id and type of expense
     * @throws SQLException 
     */
    public List<Expense> listUsingType(String type, Integer id) throws SQLException {
        List<Expense> list = new ArrayList<>();
        connection = tablesDao.connectToDatabase();
        s = connection.prepareStatement("SELECT * FROM Expense where type = ? AND user_id = ?");
        s.setString(1, type);
        s.setInt(2, id);
        ResultSet rs = s.executeQuery();
        while (rs.next()) {
            list.add(new Expense(rs.getInt("id"), rs.getDouble("amount"), rs.getString("type"), rs.getInt("user_id")));
        }
        s.close();
        rs.close();
        connection.close();
        
        return list;        
    }


    
}
