 
package okatm;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
 
 
public class Signup extends JFrame implements ActionListener {
    
    
    JTextField nametf,fnametf,addresstf,emailtf,citytf,statetf,pintf;
    JButton submit;
    JRadioButton male,fmale;
    JDateChooser date;
    long random;
    
    
     Signup(){
         
         setLayout(null);
         
         Random r = new Random();
          random = Math.abs((r.nextLong() % 9000L)+1000L);
          
         
         
         
          JLabel  l1 = new JLabel("APPLICATION FORM NO. "+random);
        l1.setFont(new Font("Raleway", Font.BOLD, 23));
         setLayout(null);
        l1.setBounds(150,8,600,40);
        add(l1);
         
         /*  JLabel formno = new JLabel("Form ID: " + random);
         formno.setFont(new Font ("Raleway",Font.BOLD,15));
         formno.setBounds(10,10,500,55);
         add(formno);
         */
         
         JLabel form = new JLabel("Applicant  Details");
         form.setFont(new Font ("Raleway",Font.BOLD,37));
         form.setBounds(290,30,500,55);
         add(form);
         
         JLabel name = new JLabel("Name: ");
         name.setFont(new Font ("Raleway",Font.BOLD,20));
           name.setForeground(Color.WHITE);
             name.setBackground(Color.BLACK);
              name.setOpaque(true);
         name.setBounds(40,140,100,30);
         add(name);
         
           nametf = new JTextField();
         nametf.setFont(new Font("Sariff",Font.BOLD,14));
         nametf.setBounds(300,140,300,30);
         add(nametf);
         
         JLabel fname = new JLabel("Father's Name: ");
           fname.setForeground(Color.WHITE);
             fname.setBackground(Color.BLACK);
              fname.setOpaque(true);
         fname.setFont(new Font ("Raleway",Font.BOLD,20));
         fname.setBounds(40,190,200,30);
         add(fname);
         
             fnametf = new JTextField();
         fnametf.setFont(new Font("Sariff",Font.BOLD,14));
         fnametf.setBounds(300,190,300,30);
         add(fnametf);
         
         JLabel dob = new JLabel("Date of birth: ");
           dob.setForeground(Color.WHITE);
             dob.setBackground(Color.BLACK);
              dob.setOpaque(true);
         dob.setFont(new Font ("Raleway",Font.BOLD,20));
         dob.setBounds(40,240,200,30);
         add(dob);
         
           date = new JDateChooser();
         date.setBounds(300,240,200,30);
         add(date);
         
         
          JLabel gender = new JLabel("Gender: ");
            gender.setForeground(Color.WHITE);
         gender.setFont(new Font ("Raleway",Font.BOLD,20));
           gender.setBackground(Color.BLACK);
            gender.setOpaque(true);
         gender.setBounds(40,290,200,30);
         add(gender);
         
           male = new JRadioButton("Male");
         male.setBounds(300,290,60,30);
         add(male);
           fmale = new JRadioButton("Female");
         fmale.setBounds(450,290,90,30);
         add(fmale);
         
         ButtonGroup maleFemale = new ButtonGroup();
         maleFemale.add(male);
         maleFemale.add(fmale);
         
         
                   JLabel address = new JLabel("Address: ");
         address.setFont(new Font ("Raleway",Font.BOLD,20));
          address.setForeground(Color.WHITE);
         address.setOpaque(true);
        address.setBackground(Color.BLACK);
         address.setBounds(40,340,200,30);
         add(address);
         
                     addresstf = new JTextField();
         addresstf.setFont(new Font("Sariff",Font.BOLD,14));
         addresstf.setBounds(300,340,300,30);
         add(addresstf);
         
               JLabel  email = new JLabel("Email: ");
         email.setFont(new Font ("Raleway",Font.BOLD,20));
         email.setBounds(40,390,200,30);
          email.setForeground(Color.WHITE);
         email.setOpaque(true);
        email.setBackground(Color.BLACK);
         add(email);
         
            emailtf = new JTextField();
         emailtf.setFont(new Font("Sariff",Font.BOLD,14));
         emailtf.setBounds(300,390,300,30);
         add(emailtf);
         
               JLabel city = new JLabel("City: ");
         city.setFont(new Font ("Raleway",Font.BOLD,20));
         city.setBounds(40,440,200,30);
         city.setForeground(Color.WHITE);
         city.setOpaque(true);
        city.setBackground(Color.BLACK);
         add(city);
         
           citytf = new JTextField();
         citytf.setFont(new Font("Sariff",Font.BOLD,14));
         citytf.setBounds(300,440,300,30);
         add(citytf);
         
                  JLabel state = new JLabel("State: ");
         state.setFont(new Font ("Raleway",Font.BOLD,20));
         state.setBounds(40,490,200,30);
         state.setForeground(Color.WHITE);
         state.setOpaque(true);
          state.setBackground(Color.BLACK);
         add(state);
         
            statetf = new JTextField();
         statetf.setFont(new Font("Sariff",Font.BOLD,14));
         statetf.setBounds(300,490,300,30);
         add(statetf);
         
                    JLabel pincode = new JLabel("Pin-Code");
         pincode.setFont(new Font ("Raleway",Font.BOLD,20));
         pincode.setBounds(40,540,200,30);
         pincode.setForeground(Color.WHITE);
         pincode.setOpaque(true);
         pincode.setBackground(Color.BLACK);
         add(pincode);
         
         
                     pintf = new JTextField();
         pintf.setFont(new Font("Sariff",Font.BOLD,14));
         pintf.setBounds(300,540,300,30);
         add(pintf);
         
           submit = new JButton("Submit");
         submit.setForeground(Color.red);
         submit.setBounds(440,610,80,30);
         submit.addActionListener(this);
         add(submit);
         
         
         getContentPane().setBackground(Color.GRAY);
         
         setSize(850,700);
         setLocation(350,10);
         setVisible(true);
         
     }
     
     public void actionPerformed(ActionEvent ae){
         String formno = "" + random;
         String name = nametf.getText();
         String fname = fnametf.getText();
         String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
         String gender = null;
         if(male.isSelected()){
             gender = "Male";
         }
         else if(fmale.isSelected()){
             gender = "Female";
         }
         
         String address = addresstf.getText();
         String email = emailtf.getText();
         String city = citytf.getText();
         String state = statetf.getText();
         String pin = pintf.getText();
         
         try{
             if(name.equals("")){
                 JOptionPane.showMessageDialog(null, "Fieldd is required");
                 
             }
             else{
                 Conn1 c = new Conn1();
                    String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+address+"','"+email+"' , '"+city+"','"+state+"','"+pin+"')";
                    c.s.executeUpdate(query);
                    
                    setVisible(false);
                    new Signup2(formno).setVisible(true);
             }
             
         }
         catch(Exception e){
             System.out.println(e);
         }
         
     }
 


public static void main(String args[]){
new Signup();
}

}

