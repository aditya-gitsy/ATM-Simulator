
package okatm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JLabel head;
    JButton deposit,Back;
    String pinnumber;
    Deposit(String pinnumber){
        
         setSize(700,700);
        //setUndecorated(true);
        setLocation(500,0);
        getContentPane().setBackground(Color.black);
        
        setVisible(true);
        this.pinnumber = pinnumber;
         
        setLayout(null);
        
        
        
             head = new JLabel("Enter amount to deposit");
 head.setForeground(Color.white);
         head.setFont(new Font ("Raleway",Font.BOLD,37));
         head.setBounds(150,70,500,55);
         add(head);
        
           amount = new JTextField();
         amount.setFont(new Font("Raleway", Font.BOLD, 23));
         amount.setBounds(220,200,250,40);
         add(amount);
         
        
          deposit = new JButton("Deposit");
         deposit.setFont(new Font("Raleway", Font.BOLD, 23));
         deposit.setBounds(290,290,120,25);
         deposit.setForeground(Color.blue);
         deposit.addActionListener(this);
         add(deposit);
        
        
           Back = new JButton("Back");
         Back.setFont(new Font("Raleway", Font.BOLD, 23));
         Back.setBounds(290,330,120,25);
         Back.setForeground(Color.blue);
         Back.addActionListener(this);
         add(Back);
        
        
        
        
     
        
        
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amnt = amount.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                if(amount.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                               Conn1 c = new Conn1();
                    String query = ("insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+amnt+"')");
                     c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+amnt+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
            }else if(ae.getSource()==Back){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
    }
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
}
