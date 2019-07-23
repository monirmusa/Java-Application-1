/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *103.204.81.95===from http://www.myipaddress.com/what-is-my-ip-address/
 *sir == 127.0.0.1
 * pc= 192.168.0.105
 * @author Monirujjaman musa
 */
public class DbConnection {

   private final String USERNAME="monir";
   private final String PASSWORD= "1234";
   private final String HOSTNAME="127.0.0.1";
   private final String DBNAME="demodb";
   private final String DBURL="jdbc:mysql://"+HOSTNAME +"/"+DBNAME;
 //CREATE USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pa$$word';
    public DbConnection() {
    
       try {
           System.out.println("Connecting to the database...");
           Connection connection=DriverManager.getConnection(DBURL , USERNAME, PASSWORD);
              System.out.println("Connection ok ");
              String query="insert into borrower values('5','Habiba','habiba@gmail.com','0177781'); ";
              Statement statement=connection.createStatement();
              statement.executeLargeUpdate(query);
               System.out.println("Values are inserted ");
              
       } catch (SQLException sqle) {
          System.err.println("some error happend" +sqle);
       }
    
    
    }
    
    
    
    
    public static void main(String[] args) {
        DbConnection a= new DbConnection();
    }
    
}
