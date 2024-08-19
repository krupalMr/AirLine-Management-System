
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton submit,close ,reset;
    JTextField tUserName;
    JPasswordField tPassword;
    
    public Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel LblUsername = new JLabel("Username");
        LblUsername.setBounds(20, 20,100 ,20 );
        add(LblUsername);
        
        tUserName = new JTextField();
        tUserName.setBounds(130, 20, 200, 20);
        add(tUserName);
        
        JLabel LblPassword = new JLabel("password");
        LblPassword.setBounds(20, 60,100 ,20 );
        add( LblPassword);
        
         tPassword = new JPasswordField();
        tPassword.setBounds(130,60, 200, 20);
        add(tPassword);
        
         reset = new JButton("Reset");
        reset.setBounds(40,120,120,20);
        reset.addActionListener(this);
        add(reset);
        
         submit = new JButton("submit");
        submit.setBounds(190,120,120,20);
        submit.addActionListener(this);
        add(submit);
        
         close = new JButton("close");
        close.setBounds(120,160,120,20);
         close.addActionListener(this);
        add(close);
        
        setSize(400,250);
        setLocation(600,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==reset){
            tUserName.setText("");
            tPassword.setText("");
        }
        else if (ae.getSource()==close){
            setVisible(false);
        }
        else if (ae.getSource()== submit){
            String username =tUserName.getText();
            String password= tPassword.getText();
            
            try{
                Conn c = new Conn();
               String query= "select * from login where username='"+username+"' and password='"+password+"'";
              ResultSet rs= c.s.executeQuery(query);
              
              if(rs.next()){
                    new Home();
                    setVisible(false);
              }
              else{
                  JOptionPane.showMessageDialog(null,"Invaild username or password");
                  setVisible(false);
              }
            }catch(Exception e){
                e.printStackTrace();
            }
       
            
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}

