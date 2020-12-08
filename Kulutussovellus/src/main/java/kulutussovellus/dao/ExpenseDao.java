
package kulutussovellus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kulutussovellus.domain.Expense;


public class ExpenseDao implements Dao<Expense, Integer> {
    
    TablesDao tablesDao = new TablesDao();
    Connection connection;
    PreparedStatement s;
    SQLException e = new SQLException();

    @Override
    public void create(Expense expense) throws SQLException {

        connection = tablesDao.connectToDatabase();
        PreparedStatement s = connection.prepareStatement("INSERT INTO Expense"
            + "(id, amount, type, user_id)"
            + "VALUES(?,?,?,?)"); 
        s.setInt(1, expense.getId());
        s.setDouble(2, expense.getAmount());
        s.setString(3, expense.getType());
        s.setInt(4, expense.getUserId());
        s.executeUpdate();
        s.close();
        connection.close();

        
    }

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

    @Override
    public void delete(Integer key) throws SQLException {

        connection = tablesDao.connectToDatabase();
        s = connection.prepareStatement("DELETE FROM Expense WHERE id = ? ");
        s.setInt(1, key);
        s.executeUpdate();
        s.close();
        connection.close();
            

    }

    @Override
    public List<Expense> list() throws SQLException {
        List<Expense> list = new ArrayList<>();
        connection = tablesDao.connectToDatabase();
        s = connection.prepareStatement("SELECT * FROM Expense");
        ResultSet rs = s.executeQuery();
        while (rs.next()) {
            list.add(new Expense(rs.getInt("id"), rs.getDouble("amount"), rs.getString("type"), rs.getInt("user_id")));
        }
        s.close();
        rs.close();
        connection.close();
        
        return list;
       
        
    }
    
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
    
    public List<Expense> listUsingId(int id) throws SQLException {
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
    
}
