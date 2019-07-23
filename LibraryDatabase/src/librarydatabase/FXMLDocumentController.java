/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarydatabase;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Monirujjaman musa
 */
public class FXMLDocumentController implements Initializable {
    
    Statement statement;
    @FXML
    private TextField addBorrowerIdField;
    @FXML
    private TextField addBorrowerNameField;
    @FXML
    private TextField addBorrowerPhoneField;
    @FXML
    private Label statusLabel;
    
   
    String DB_URL="jdbc:mysql://127.0.0.1/demodb";
      String DB_USER="monir";
      String DB_PASS="1234";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Connection connection=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             statement=connection.createStatement();
            
            statusLabel.setText("Connected...");
            
        } catch (SQLException ex) {
              statusLabel.setText("Connection to the database...");
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleResetAction(ActionEvent event) {
    }

    @FXML
    private void handleAddAction(ActionEvent event)  {
        try {
            int id=Integer.parseInt(addBorrowerIdField.getText());
            String name=addBorrowerNameField.getText();
            String phone=addBorrowerPhoneField.getText();
            
            String queryString="insert into borrower values("+id+",'"+name+"','"+phone+"');";
            statement.executeUpdate(queryString);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
