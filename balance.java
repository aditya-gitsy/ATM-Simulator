package okatm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
 

public class Balance  extends JFrame implements ActionListener{
    String pinnumber;
    JButton back;
    Balance(String pinnumber){
        this.pinnumber = pinnumber;
         setLayout(null);
        
        back = new JButton("Back");
        back.setBounds(340,360,150,30);
         back.setFont(new Font("Osward", Font.BOLD, 25));
           
          back.setForeground(Color.blue);
        back.addActionListener(this);
        add(back);
         Conn1 c = new Conn1();
         int balance =0;
          try{
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                         balance -= Integer.parseInt(rs.getString("amount"));
                    }
                    
                }
          }
                
                catch(Exception e){
                        System.out.println(e);
                        }
        
          JLabel text = new JLabel ("Current Balance is "+ balance);
          text.setForeground(Color.WHITE);
          text.setBounds(250,300,580,30);
           text.setFont(new Font("Osward", Font.BOLD, 40));
          add(text);
          
        setSize(900,900);
        setLocation(300,0);
        getContentPane().setBackground(Color.black);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
         


    }
    
    public static void main(    String [] args){
        new Balance("");
    }
    
}
