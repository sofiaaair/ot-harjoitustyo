
package kulutussovellus.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.List;
import kulutussovellus.domain.User;


public class UserDao implements Dao<User, Integer>{
    
   /* void connectToDatabase() throws SQLException{
        Connection db = DriverManager.getConnection("jdbc:sqlite:database.db"); 
        Statement s = db.createStatement();
    }*/

    @Override
    public void create(User user) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        PreparedStatement statement = connection.prepareStatement("INSERT INTO USER"
        + "(name, username, password)"
        + "VALUES(?,?,?)");
        statement.setString(1, user.getName());
        statement.setString(2, user.getUsername());
        statement.setString(3, user.getPassword());
        
        statement.executeUpdate();
        statement.close();
        connection.close();
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
