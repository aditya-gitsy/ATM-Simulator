 
package okatm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
 
public class Transactions extends JFrame implements ActionListener {
    
    JButton Deposit, withdraw, ministatement, fastcash, balance, exit, pinchange;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber =  pinnumber;
        setLayout(null);
         
    setSize(800,800);
    setLocation(250,0);
   // setUndecorated(true);
    setVisible(true);
    
    
    JLabel head = new JLabel("Select Your Transaction");
         head.setFont(new Font ("Raleway",Font.BOLD,37));
         head.setBounds(180,70,500,55);
         add(head);
         
           Deposit = new JButton("Deposit ");
         Deposit.setFont(new Font ("Raleway",Font.BOLD,30));
         Deposit.setBackground(Color.RED);
         Deposit.setForeground(Color.WHITE);
         Deposit.setBounds(260,200,200,50);
            Deposit.addActionListener(this);
         add(Deposit);
         
           withdraw = new JButton("Withdraw ");
         withdraw.setFont(new Font ("Raleway",Font.BOLD,30));
         withdraw.setBounds(260,270,200,50);
         withdraw.setBackground(Color.ORANGE);
         withdraw.setForeground(Color.WHITE);
            withdraw.addActionListener(this);
         add(withdraw);
         
           fastcash = new JButton("Fast Cash ");
         fastcash.setFont(new Font ("Raleway",Font.BOLD,30));
         fastcash.setBounds(260,340,200,50);
         fastcash.setBackground(Color.YELLOW);
         fastcash.setForeground(Color.WHITE);
            fastcash.addActionListener(this);
         add(fastcash);
         
           ministatement = new JButton("Mini Statement ");
         ministatement.setFont(new Font ("Raleway",Font.BOLD,30));
         ministatement.setBounds(260,410,200,50);
          ministatement.setBackground(Color.GREEN);
         ministatement.setForeground(Color.WHITE);
            ministatement.addActionListener(this);
         add(ministatement);
         
           pinchange = new JButton("Pin Change ");
         pinchange.setFont(new Font ("Raleway",Font.BOLD,30));
         pinchange.setBounds(260,480,200,50);
          pinchange.setBackground(Color.BLUE);
         pinchange.setForeground(Color.WHITE);
            pinchange.addActionListener(this);
         add(pinchange);
         
      balance = new JButton("Balance ");
         balance.setFont(new Font ("Raleway",Font.BOLD,30));
         balance.setBounds(260,550,200,50);
          balance.setBackground(Color.PINK);
         balance.setForeground(Color.WHITE);
            balance.addActionListener(this);
         add(balance);
    
      exit = new JButton("Exit ");
         exit.setFont(new Font ("Raleway",Font.BOLD,30));
         exit.setBounds(260,620,200,50);
         //  exit.setBackground(Color.PINK);
         exit.setForeground(Color.RED);
         exit.addActionListener(this);
         add(exit);
    
    
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if (ae.getSource()==Deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdraw)    {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }
         else if(ae.getSource()==fastcash)    {
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange)    {
            setVisible(false);
            new Pin(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==balance)    {
            setVisible(false);
            new Balance(pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String[] args){
        new Transactions("");
    }
    
}
