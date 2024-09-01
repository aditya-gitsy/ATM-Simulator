 
package okatm;

import java.sql.*;  

public class Conn1{
    Connection c;
    Statement s;
    public Conn1(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///newatm","root","user123");    
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
 
