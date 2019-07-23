/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasedemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *192.168.110.1
 * @author Monirujjaman musa
 */
public class DatabaseDemo {
     
    String DB_DRIVER="com.mysql.jdbc.Driver";
     String DB_URL="jdbc:mysql://103.204.81.95/demodb";
     String DB_USER="monir";
     String DB_PASS="1234";

    public DatabaseDemo() {
        try {
            Class.forName(DB_DRIVER);
            Connection connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
            Statement statement=connection.createStatement();
           ResultSet result= statement.executeQuery("select * from borrower");
            System.out.println("connected");
            while(result.next()){
            System.out.println(result.getString("email"));
            
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
          
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new DatabaseDemo(); 
    }
    
}
