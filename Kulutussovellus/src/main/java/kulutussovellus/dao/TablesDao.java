
package kulutussovellus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static javafx.application.Application.launch;

/**
 * Class is responsible for creating and connecting to the database.
 *
 */

public class TablesDao {
    /* ... */
    
   /**
    * Method creates connection to SQL database and creates tables that are used in the program.
    */
    public void create() {
       
        try {
            Connection db = DriverManager.getConnection("jdbc:sqlite:database.db");         
            Statement s = db.createStatement();
            s.execute("BEGIN TRANSACTION");
            s.execute("PRAGMA foreign_keys = ON");
            s.execute("CREATE TABLE User (id INTEGER PRIMARY KEY, name TEXT, username TEXT UNIQUE, password TEXT )");
            s.execute("CREATE TABLE Expense (id INTEGER PRIMARY KEY, amount DOUBLE, type TEXT, user_id INTEGER REFERENCES User(id))");
            s.execute("COMMIT");
        } catch (SQLException e) {
            System.out.println("Missing database or database already exists");
        }
    }
    
    /**
     * Method contacts the database used in the program and returns Connection object
     * @return Connection object
     * @throws SQLException 
     */
    public Connection connectToDatabase() throws SQLException {
        Connection db = DriverManager.getConnection("jdbc:sqlite:database.db");
        return db;
 
    }  
    
}
    

