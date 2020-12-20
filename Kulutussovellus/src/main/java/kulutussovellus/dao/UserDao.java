
package kulutussovellus.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import kulutussovellus.domain.User;


public class UserDao implements Dao<User, Integer> {
    
    TablesDao tablesDao = new TablesDao();
    Connection connection;
    PreparedStatement statement;
           

    @Override
    public void create(User user) throws SQLException {
        

        connection = tablesDao.connectToDatabase();
        statement = connection.prepareStatement("INSERT INTO User"
        + "(id ,name, username, password)"
        + "VALUES(?,?,?,?)");
        statement.setInt(1, user.getId());
        statement.setString(2, user.getName());
        statement.setString(3, user.getUsername());
        statement.setString(4, user.getPassword());
        
        statement.executeUpdate();
        statement.close();
        connection.close();

    }

    @Override
    public User read(Integer key) throws SQLException {
        connection = tablesDao.connectToDatabase();
        statement = connection.prepareStatement("SELECT * FROM User WHERE id = ?");
        statement.setInt(1, key);
        ResultSet rs = statement.executeQuery();
        if (!rs.next()) {
            return null;
        }
        
        User e = new User(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("password"));
        
        statement.close();
        rs.close();
        connection.close();
        
        return e;
    }

    @Override
    public User update(User user) throws SQLException {
        
        
        connection = tablesDao.connectToDatabase();
        statement = connection.prepareStatement("UPDATE User SET name = ?, username = ?, password = ? WHERE id = ?");
        statement.setString(1, user.getName());
        statement.setString(2, user.getUsername());
        statement.setString(3, user.getPassword());
        statement.setInt(4, user.getId());
        statement.executeUpdate();
        
        User newUser = read(user.getId());
        statement.close();
        connection.close();
        
        return newUser;
    }

    @Override
    public void delete(Integer key) throws SQLException {

        connection = tablesDao.connectToDatabase();
        statement = connection.prepareStatement("DELETE FROM User WHERE id= ? ");
        statement.setInt(1, key);
        statement.executeUpdate();
        statement.close();
        connection.close();
            
      
        
    }

    
    public List<User> list() throws SQLException {
        List<User> list = new ArrayList<>();
        connection = tablesDao.connectToDatabase();
        statement = connection.prepareStatement("SELECT * FROM User");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            list.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("password")));
        }
        statement.close();
        rs.close();
        connection.close();
        
        return list;
       
    }
    
    public User readUsingUsername(String name, String password) throws SQLException {
        
        connection = tablesDao.connectToDatabase();
        statement = connection.prepareStatement("SELECT * FROM User where username = ?");
        statement.setString(1, name);
        ResultSet rs = statement.executeQuery();
        if (!rs.next()) {
            return null;
        }
        
        User user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("password"));
        
        statement.close();
        rs.close();
        connection.close();
        if (password.equals(user.getPassword())) {
            return user;
        }
        
        return null;

    }
    
    
    public void removeAll() {
        
        try {
            connection = tablesDao.connectToDatabase();
            statement = connection.prepareStatement("DELETE FROM User");
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            
        }
        
    }
    
}
