
package kulutussovellus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import kulutussovellus.domain.Expense;


public class ExpenseDao implements Dao<Expense, Integer>{

    @Override
    public void create(Expense object) throws SQLException {
       /* Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement s = connection.createStatement();
        s.execute("INSERT INTO Expense(id, amount, type)")*/
        
        
    }

    @Override
    public Expense read(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
