
package okatm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pin extends JFrame implements ActionListener{
    
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel l1,l2,l3;
    String pinnumber;
    Pin(String pinnumber){
        this.pinnumber = pinnumber;
 
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 45));
        l1.setForeground(Color.white);
        
        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 19));
        l2.setForeground(Color.white);
        
        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 19));
        l3.setForeground(Color.white);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 17));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 17));
        
        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(null);
        
        l1.setBounds(230,230,800,35);
        add(l1);
        
        l2.setBounds(200,390,150,35);
        add(l2);
        
        l3.setBounds(200,440,200,35);
        add(l3);
        
        t1.setBounds(395,390,180,25);
        add(t1);
        
        t2.setBounds(395,440,180,25);
        add(t2);
        
        b1.setBounds(390,528,150,35);
        b1.setForeground(Color.red);
        add(b1);
        
        b2.setBounds(390,573,150,35);
        b2.setForeground(Color.red);
        add(b2);
        
        setSize(960,1080);
        setLocation(500,0);
         getContentPane().setBackground(Color.black);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String npin = t1.getText();
            String rpin = t2.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            if(ae.getSource()==b1){
                if (t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                if (t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                }
                
               Conn1 c = new Conn1();
                String q1 = "update bank set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String q2 = "update login set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";
                String q3 = "update signup3 set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"' ";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
            }else if(ae.getSource()==b2){
                new Transactions(pinnumber).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Pin("").setVisible(true);
    }
}
