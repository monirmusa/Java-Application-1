/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biggeningcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Monirujjaman musa
 */
public class FXMLDocumentController implements Initializable {
     float oldNumber;
     String operation;
     
    @FXML
    private TextField displayField;
        
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleDizitAction(ActionEvent event) {
          String oldtext=displayField.getText();
     Button b=(Button)event.getSource();
     String dizit=b.getText();
    String newText=oldtext+dizit;
    displayField.setText(newText);
    
    
    }

    @FXML
    private void handleOperation(ActionEvent event) {
        String oldText=displayField.getText();
        oldNumber=Float.parseFloat(oldText);
        displayField.setText("");
        Button b=(Button)event.getSource();
        operation=b.getText();
      
    }

    @FXML
    private void handleEqualOperation(ActionEvent event) {
          String newText=displayField.getText();
        float newNumber=Float.parseFloat(newText);
        float result=0.00f;
        if(operation.equals("+"))
             result=oldNumber+newNumber;
       else if(operation.equals("-"))
             result=oldNumber-newNumber;
        
       else if(operation.equals("*"))
             result=oldNumber*newNumber;
        
       else if(operation.equals("/"))
             result=oldNumber/newNumber;
        
        
        
        
        
        displayField.setText(""+ result);
    }

    @FXML
    private void handleDotitAction(ActionEvent event) {
      String oldtext=displayField.getText();
     if(!oldtext.contains(".")){
      Button b=(Button)event.getSource();
     String dizit=b.getText();
    String newText=oldtext+dizit;
    displayField.setText(newText);
    
     }
    }

    @FXML
    private void handleClearAction(ActionEvent event) {
        String oldText=displayField.getText();
        String newText=oldText.substring(0, oldText.length()-1);
        displayField.setText(newText);
    }

    @FXML
    private void handleAllclearAction(ActionEvent event) {
     displayField.setText("");
    }
    
}
