
package kulutussovellus.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.List;
import kulutussovellus.domain.User;


public class UserDao implements Dao<User, Integer>{

    @Override
    public void create(User object) throws SQLException {
    /*    Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        Statement s = connection.createStatement();
        s.execute()*/
        
       
    }

    @Override
    public User read(Integer key) throws SQLException {
  /*      String output = "";
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM User");
        ResultSet resultSet = statement.executeQuery();
        
*/ return null;
    }

    @Override
    public User update(User object) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        
    }

    @Override
    public List<User> list() throws SQLException {
        return null;
    }
    
}
