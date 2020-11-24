/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kulutussovellus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import static javafx.application.Application.launch;

/**
 *
 * @author airassof
 */
public class TablesDao{

    
   
   public void create() throws SQLException{
       
       try{
       Connection db = DriverManager.getConnection("jdbc:sqlite:database.db");         
        Statement s = db.createStatement();
        s.execute("BEGIN TRANSACTION");
        s.execute("PRAGMA foreign_keys = ON");
        s.execute("CREATE TABLE Expense (id INTEGER AUTO_INCREMENT PRIMARY KEY, amount INTEGER, type TEXT)");
        s.execute("CREATE TABLE Plan(id INTEGER AUTO_INCREMENT PRIMARY KEY, type TEXT, amount INTEGER)");
        s.execute("COMMIT");
                }catch(SQLException e){
                    System.out.println("Virhe tietokannan luomisessa");
                }
       
        }
       
   }
    

