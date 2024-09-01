 
package okatm;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.*;

 
public class Signup3 extends JFrame implements ActionListener {
    
    JRadioButton r1,r2,r3,r4;
    JButton submit, cancel;
    String formno;
    
    Signup3(String formno){
        this.formno = formno;
    
    setLayout(null);
    
    JLabel l1 = new JLabel("Account details");
    l1.setFont(new Font ("Raleway",Font.BOLD,22));
    l1.setBounds(280,40,400,40);
    add(l1);
    
    JLabel type = new JLabel("Account Type");
    type.setFont(new Font ("Raleway",Font.BOLD,22));
    type.setBackground(Color.BLACK);
    type.setForeground(Color.WHITE);
    type.setOpaque(true);
    type.setBounds(100,140,200,30);
    add(type);
    
    r1 = new JRadioButton("Saving Account");
    r1.setFont(new Font ("Raleway",Font.BOLD,15));
    r1.setBounds(100,180,150,20);
    add(r1);
    
      r2 = new JRadioButton("FD  Account");
    r2.setFont(new Font ("Raleway",Font.BOLD,15));
    r2.setBounds(350,180,150,20);
    add(r2);
    
      r3 = new JRadioButton("Cuurent Account");
    r3.setFont(new Font ("Raleway",Font.BOLD,15));
    r3.setBounds(100,220,150,20);
    add(r3);
    
      r4 = new JRadioButton("RD Account");
    r4.setFont(new Font ("Raleway",Font.BOLD,15));
    r4.setBounds(350,220,150,20);
    add(r4);
    
    ButtonGroup bgrp = new ButtonGroup();
    bgrp.add(r1);
    bgrp.add(r2);
    bgrp.add(r3);
    bgrp.add(r4);
    
      JLabel card = new JLabel("Card NO.");
    card.setFont(new Font ("Raleway",Font.BOLD,22));
     card.setBackground(Color.BLACK);
    card.setForeground(Color.WHITE);
    card.setOpaque(true);
    card.setBounds(100,300,200,30);
    add(card);
    
     JLabel number = new JLabel("XXXX-XXXX-XXXX-4145");
    number.setFont(new Font ("Raleway",Font.BOLD,22));
    number.setBounds(330,300,300,30);
    add(number);
    
     JLabel pin= new JLabel("PIN");
    pin.setFont(new Font ("Raleway",Font.BOLD,22));
     pin.setBackground(Color.BLACK);
    pin.setForeground(Color.WHITE);
    pin.setOpaque(true);
    pin.setBounds(100,370,200,30);
    add(pin);
    
     JLabel pnumber = new JLabel("XXXX");
    pnumber.setFont(new Font ("Raleway",Font.BOLD,22));
    pnumber.setBounds(330,370,300,30);
    add(pnumber);
  
    JCheckBox c = new JCheckBox("All details enterd by me is correct and accurate");
    c.setBackground(Color.black);
    c.setForeground(Color.white);
    c.setFont(new Font("Raleway", Font.BOLD, 15));
    c.setBounds(100,440,400,30);
    add(c);
    
    submit = new JButton("Submit");
     submit.setBackground(Color.red);
    submit.setForeground(Color.white);
    submit.setFont(new Font("Raleway", Font.BOLD, 15));
    submit.setBounds(100,560,100,30);
    submit .addActionListener(this);
    add(submit);
    
     cancel = new JButton("Cancel");
     cancel.setBackground(Color.red);
    cancel.setForeground(Color.white);
    cancel.setFont(new Font("Raleway", Font.BOLD, 15));
    cancel.setBounds(350,560,100,30);
    cancel .addActionListener(this);
    add(cancel);
    
    getContentPane().setBackground(Color.GRAY);
    
    setSize(850,820);
    setLocation(350,0);
    setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String acctype = null;
            if(r1.isSelected()){
                acctype = "Saving Account";
            }
            else if(r2.isSelected()){
                acctype = "FD Account";
            }
             else if(r3.isSelected()){
                acctype = "Current Account";
            }
             else if(r4.isSelected()){
                acctype = "RD Account";
            }
            
            Random r = new Random();
            String  cardnumber = "" + Math.abs((r.nextLong()%90000000L) + 5040936000000000L);
            String pinnumber = ""+Math.abs((r.nextLong()%9000L)+1000L);
            
             try{
           Conn1 c = new Conn1();
            String query = "insert into signup3 values('"+formno+"','"+acctype+"','"+cardnumber+"','"+pinnumber+"' )";
              String q2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
              
                c.s.executeUpdate(query);
                  c.s.executeUpdate(q2);
                     JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin:"+ pinnumber);
              
                  setVisible(false);
                   new Deposit(pinnumber).setVisible(true);
            
            
            
              
        }
        catch(Exception e){
            
            System.out.println(e);
            
        }
            
            
            
        }
        
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
            
        }
        
        
        
        
        
        
        
        
        
        
         
        
    }
    
    public static void main(String args[]){
         new Signup3("").setVisible(true);
        
    }
    
}
