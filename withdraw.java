
package okatm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*; 

public class Withdraw extends JFrame implements ActionListener{
    
    JTextField amount;
    JLabel head;
    JButton Withdraw,Back;
    String pinnumber;
    Withdraw(String pinnumber){
        
         setSize(800,800);
        //setUndecorated(true);
        setLocation(500,0);
         getContentPane().setBackground(Color.GRAY);
        setVisible(true);
        this.pinnumber = pinnumber;
         
        setLayout(null);
        
        
        
             head = new JLabel("Enter an amount to Withdraw");
         head.setFont(new Font ("Raleway",Font.BOLD,37));
         head.setBounds(180,70,600,55);
         add(head);
        
           amount = new JTextField();
         amount.setFont(new Font("Raleway", Font.BOLD, 23));
         amount.setBounds(240,200,300,50);
         add(amount);
         
        
          Withdraw = new JButton("Withdraw");
         Withdraw.setFont(new Font("Raleway", Font.BOLD, 23));
         Withdraw.setForeground(Color.RED);
         Withdraw.setBounds(290,390,140,25);
         Withdraw.addActionListener(this);
         add(Withdraw);
        
        
           Back = new JButton("Back");
         Back.setFont(new Font("Raleway", Font.BOLD, 23));
         Back.setForeground(Color.RED);
         Back.setBounds(290,420,140,25);
         Back.addActionListener(this);
         add(Back);
        
        
        
        
     
        
        
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amnt = amount.getText();
            Date date = new Date();
            if(ae.getSource()==Withdraw){
                if(amount.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter an amount to Withdraw");
                }else{
                               Conn1 c = new Conn1();
                    String query = ("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+amnt+"')");
                     c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+amnt+" Withdraw Successfully");
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
