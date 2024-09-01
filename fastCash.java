 
 
package okatm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
 
public class Fastcash extends JFrame implements ActionListener {
    
    JButton  Deposit, withdraw, ministatement, fastcash, balance, exit, pinchange;
    String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber =  pinnumber;
        setLayout(null);
         
    setSize(800,800);
        getContentPane().setBackground(Color.black);
    setLocation(250,0);
   // setUndecorated(true);
    setVisible(true);
    
    
    JLabel head = new JLabel("Select Your Transaction");
   // head.setForeground(color.white);
    head.setForeground(Color.white);
         head.setFont(new Font ("Raleway",Font.BOLD,37));
         head.setBounds(180,70,500,55);
         add(head);
         
Deposit = new JButton("Rs 100 ");
          Deposit.setFont(new Font ("Raleway",Font.BOLD,30));
           Deposit.setForeground(Color.blue);
          Deposit.setBounds(260,200,200,50);
             Deposit.addActionListener(this);
         add( Deposit);
         
           withdraw = new JButton("Rs 200 ");
         withdraw.setFont(new Font ("Raleway",Font.BOLD,30));
          withdraw.setForeground(Color.blue);
         withdraw.setBounds(260,270,200,50);
            withdraw.addActionListener(this);
         add(withdraw);
         
           fastcash = new JButton("Rs 500 ");
         fastcash.setFont(new Font ("Raleway",Font.BOLD,30));
          fastcash.setForeground(Color.blue);
         fastcash.setBounds(260,340,200,50);
            fastcash.addActionListener(this);
         add(fastcash);
         
           ministatement = new JButton("Rs 500");
         ministatement.setFont(new Font ("Raleway",Font.BOLD,30));
          ministatement.setForeground(Color.blue);
         ministatement.setBounds(260,410,200,50);
            ministatement.addActionListener(this);
         add(ministatement);
         
           pinchange = new JButton("Rs 1000 ");
         pinchange.setFont(new Font ("Raleway",Font.BOLD,30));
          pinchange.setForeground(Color.blue);
         pinchange.setBounds(260,480,200,50);
            pinchange.addActionListener(this);
         add(pinchange);
         
      balance = new JButton("Rs 2000 ");
         balance.setFont(new Font ("Raleway",Font.BOLD,30));
          balance.setForeground(Color.blue);
         balance.setBounds(260,550,200,50);
            balance.addActionListener(this);
         add(balance);
    
      exit = new JButton("Back ");
         exit.setFont(new Font ("Raleway",Font.BOLD,30));
          exit.setForeground(Color.blue);
         exit.setBounds(260,620,200,50);
         exit.addActionListener(this);
         add(exit);
    
    
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible (false);
            new Transactions(pinnumber).setVisible(true);
        }
        else{
            
            
        String amount =  ((JButton)ae.getSource()).getText().substring(3);
            Conn1 c = new Conn1();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '"+pinnumber+"'");
                int balance = 0; 
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                         balance -= Integer.parseInt(rs.getString("amount"));
                    }
                    
                }
                
                if(ae.getSource()!= exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffiecient Balance");
                    return;
                    
                }
                
                Date date = new Date();
                 String q = ("insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')");
                 c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                
                
                
            }
             catch(Exception e){
                System.out.println(e);
            }
            
        }
        
    }
    
    
    public static void main(String[] args){
        new Fastcash("");
    }
    
}


 
