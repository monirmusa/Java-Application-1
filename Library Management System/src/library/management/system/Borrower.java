/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

/**
 *
 * @author Monirujjaman musa
 */
public class Borrower {
    private  int id;
    private String name;
    
    public Borrower(int id,String name){
    
    this.id=id;
    this.name=name; 
    }
    public int getId(){
    return id; 
    }
    public String getname(){
    return name;
    }
    public void setname(String name){
    this.name=name;
   }
    
    
    
}
