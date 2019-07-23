/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
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
    private ArrayList<Book>books;
    private ArrayList<Borrower>borrowers;
    private Label label;
    @FXML
    private TextField BookField;
    @FXML
    private TextField BorrowerField;
    @FXML
    private TextField returnDateField;
    @FXML
    private TextField BorrowDateField;
    @FXML
    private Label statusLabel;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        books = new ArrayList<Book>();
        borrowers=new ArrayList<Borrower>();
        try {                    //at first full file will be read;
        RandomAccessFile input=new RandomAccessFile("book.txt","r");
        String line;
        int id;             //2= id,name will be read;
        String name;
        
        while((line=input.readLine())!=null){  //3= all line (name,id) will be read untill null
             if(line.length()==0)
                 continue;         //4=if get empty line then skip this line
        id=Integer.parseInt(line);    //conver to string from int
        line=input.readLine();      //1=to read line by line
        name=line;
        //System.out.println(id+","+name);
        Book b=new Book(id,name); //instantiate a book object where id,name is content
                                 //basically we will work on book file//3/4/....book
                                 //this book we will put on the array List
        books.add(b);  //this book will go to store in the arrayList
        }
        statusLabel.setText("book "+books.size()+" is readed");
        
       //////////////for borrower////////////////// 
         input=new RandomAccessFile("borrower.txt","r");
        while((line=input.readLine())!=null){  //3= all line (name,id) will be read untill null
             if(line.length()==0)
                 continue;         //4=if get empty line then skip this line
        id=Integer.parseInt(line);    //conver to string from int
        line=input.readLine();      //1=to read line by line
        name=line;
        //System.out.println(id+","+name);
        Borrower b=new Borrower(id,name); //instantiate a book object where id,name is content
                                 //basically we will work on book file//3/4/....book
                                 //this book we will put on the array List
        borrowers.add(b);  //this book will go to store in the arrayList
        }
        
        
        statusLabel.setText("borrower "+borrowers.size()+" is readed");
        
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }    

    @FXML
    private void handleResetAction(ActionEvent event) {
    }

    @FXML
    private void handleSubmitAction(ActionEvent event)  {
        try {
            RandomAccessFile output=new RandomAccessFile("transaction.txt","rw");
        output.seek(output.length());//at the time of new new submittion prevous data will not
                                   //change.previous data will not change
        int bookId=Integer.parseInt(BookField.getText());     
        int borrowerId=Integer.parseInt(BorrowerField.getText()); 
        String borrowDate= BorrowDateField.getText();
        String returnDate=returnDateField.getText();
        
        boolean found=false;
        for(int i=0;i<books.size();i++)
            if(books.get(i).getId()==bookId)
                found=true;
        if(!found)
             statusLabel.setText("you have entered wrong book");
     
        else{
        output.writeBytes(bookId+ "\n");   //to write the line
        output.writeBytes(borrowerId+"\n");  // 4 line will be written on transaction file
        output.writeBytes(borrowDate +"\n");
        output.writeBytes(returnDate +"\n");
        statusLabel.setText("Recorded Transaction for"+bookId+","+borrowerId);
        
        } 
        } 
        
        
        catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
