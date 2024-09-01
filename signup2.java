  
package okatm;
 
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.*;
 
 
 
public class Signup2 extends JFrame implements ActionListener {
    
    
    JTextField   adhartf,   phtf;
    JButton submit;
    //JRadioButton male,fmale;
             JComboBox incometf;
             JComboBox qualtf;
               JComboBox jobtf;
    
    String formno;
   // long random;
    
    
     Signup2(String formno){
         this.formno = formno;
         setLayout(null);
         
         JLabel form = new JLabel("More Details");
         form.setFont(new Font ("Raleway",Font.BOLD,37));
         form.setBounds(290,30,500,55);
          
         add(form);
         
         JLabel income = new JLabel("Income: ");
         income.setFont(new Font ("Raleway",Font.BOLD,20));
          income.setForeground(Color.WHITE);
             income.setBackground(Color.BLACK);
             income.setOpaque(true);
         income.setBounds(40,140,100,30);
         add(income);
         
         String incomeselect[] = {"No Income", "1 lakh", "2 lakh", "5 lakh", "7 lakh", "< 10 lakh"};
          incometf = new JComboBox(incomeselect);
         incometf.setBounds(300,140,300,30);
         //incometf.setBackground(Color.WHITE);
         add(incometf);
       //  incometf.setBounds(300,140,300,30);
          
         
          
       //  ed.setBounds(40,190,200,30);
         
         
              
      //   edtf.setBounds(300,190,300,30);
          
         
         JLabel qual = new JLabel("qualification: ");
         qual.setFont(new Font ("Raleway",Font.BOLD,20));
          qual.setForeground(Color.WHITE);
             qual.setBackground(Color.BLACK);
             qual.setOpaque(true);
         qual.setBounds(40,190,100,30);
         add(qual);
         
           
          String qualselect[] = {"Matrix", "High School", "UG", "PG", "PHD"};
          qualtf = new JComboBox(qualselect);
         qualtf.setBounds(300,190,300,30);
         //incometf.setBackground(Color.WHITE);
         add(qualtf);
         //qualtf.setBounds(300,240,200,30);
        // add(qualtf);
         
         
          
         
           
         
         
                   JLabel occup = new JLabel("Occupation: ");
         occup.setFont(new Font ("Raleway",Font.BOLD,20));
          occup.setForeground(Color.WHITE);
         occup.setOpaque(true);
         occup.setBackground(Color.BLACK);
         occup.setBounds(40,240,100,30);
         add(occup);
         
         String jobselect[] = {"Student", "Business", "Corporate", "IT", "Govt"};
          jobtf = new JComboBox(jobselect);
         jobtf.setBounds(300,240,300,30);
         //incometf.setBackground(Color.WHITE);
         add(jobtf);
         
           JLabel ph = new JLabel("Phone No.: ");
         ph.setFont(new Font ("Raleway",Font.BOLD,20));
         ph.setBounds(40,290,200,30);
           ph.setForeground(Color.WHITE);
         ph.setOpaque(true);
         ph.setBackground(Color.BLACK);
         add(ph);
         
          phtf = new JTextField();
         phtf.setBounds(300,290,300,30);
         add(phtf);
         
              
         
               JLabel  adhar = new JLabel("Adhar No.: ");
         adhar.setFont(new Font ("Raleway",Font.BOLD,20));
         adhar.setBounds(40,340,200,30);
          adhar.setForeground(Color.WHITE);
         adhar.setOpaque(true);
         adhar.setBackground(Color.BLACK);
         add(adhar);
         
            adhartf = new JTextField();
         adhartf.setFont(new Font("Sariff",Font.BOLD,14));
         adhartf.setBounds(300,340,300,30);
         add(adhartf);
         
                
         
                 
         
                 
         
           submit = new JButton("Submit");
         submit.setForeground(Color.red);
         submit.setBounds(420,460,80,30);
         submit.addActionListener(this);
         add(submit);
         
         getContentPane().setBackground(Color.black);
         
         setSize(850,600);
         setLocation(370,10);
         setVisible(true);
         
     }
     
     public void actionPerformed(ActionEvent ae){
      
      // String formno = "" + random;
        String  income = (String)incometf.getSelectedItem();
          String  qualification = (String)qualtf.getSelectedItem();
            String  occupation = (String)jobtf.getSelectedItem();
         String phone = phtf.getText();
         String adhar = adhartf.getText();
         
         try{
             Conn1 c = new Conn1();
             String query = "insert into signup2 values( '"+formno+"','"+income+"','"+qualification+"','"+occupation+"','"+phone+"','"+adhar+"')";
             c.s.executeUpdate(query);
             
              setVisible(false);
              new Signup3(formno).setVisible(true);
         }catch(Exception e){
             System.out.println(e);
             
              
             
     
         }
         
         
         
         
     }


public static void main(String args[]){
new Signup2("");
}

}

