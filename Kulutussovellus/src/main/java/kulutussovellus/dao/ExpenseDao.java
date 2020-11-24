
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


public class ExpenseDao implements Dao<Expense, Integer>{

    @Override
    public void create(Expense expense) throws SQLException {
       Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        PreparedStatement s = connection.prepareStatement("INSERT INTO Expense"
        + "(amount, type)"
        + "VALUES(?,?)"); 
        s.setInt(1, expense.getAmount());
        s.setString(2, expense.getType());
        s.executeUpdate();
        s.close();
        connection.close();
        
        
    }

    @Override
    public Expense read(Integer key) throws SQLException {
       Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        PreparedStatement s= connection.prepareStatement("SELECT* FROM Expense WHERE id = ?");
        s.setInt(1, key);
        ResultSet rs = s.executeQuery();
        if(!rs.next()){
            return null;
        }
        
        Expense e = new Expense(rs.getInt("id"),rs.getInt("amount"), rs.getString("type"));
        s.close();
        rs.close();
        
        return e;
    }

    @Override
    public Expense update(Expense object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Expense> list() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        PreparedStatement s = connection.prepareStatement("SELECT * FROM Expense");
        ResultSet rs = s.executeQuery();
        if(!rs.next()){
            return null;
        }
        
        List<Expense> list = new ArrayList<>();
        while(rs.next()){
                list.add(new Expense(rs.getInt("id"), rs.getInt("amount"), rs.getString("type")));
        }
        s.close();
        rs.close();
        
        return list;
        
        
    }
    
}
