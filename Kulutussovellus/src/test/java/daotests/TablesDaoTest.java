/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daotests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import kulutussovellus.dao.TablesDao;
import org.sqlite.jdbc4.JDBC4Connection;

public class TablesDaoTest {
    
    TablesDao tablesDao;
    
    public TablesDaoTest() {
    }
    
    
    
    @Before
    public void setUp() {
        tablesDao = new TablesDao();
        
    }
    

    @Test
    public void connectToDataBaseReturnsConnection() throws Exception {
        
        assertEquals(JDBC4Connection.class, tablesDao.connectToDatabase().getClass());
        
    }
}
