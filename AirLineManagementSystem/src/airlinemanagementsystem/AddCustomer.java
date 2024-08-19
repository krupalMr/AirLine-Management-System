

package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JTextField tframe,tnation,taadhaar,taddress,tphone;
    JRadioButton rmale, rfemale;
    public AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
       setLayout(null);
        setSize(900,600);
        setVisible(true);
    
        JLabel heading = new JLabel("Add Customer Details");
       heading.setBounds(270,20,400,25);
        heading.setFont(new Font("thoma",Font.PLAIN, 32));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel LblUsername = new JLabel("Name");
        LblUsername.setBounds(160,90,100,25);
        LblUsername.setFont(new Font("thoma",Font.PLAIN, 23));
        add(LblUsername);
        
          tframe = new JTextField();
        tframe.setBounds(270, 90, 300, 25);
        add(tframe);
        
        JLabel LblNationality = new JLabel("Nationality");
        LblNationality.setBounds(160,140,200,25);
        LblNationality.setFont(new Font("thoma",Font.PLAIN, 20));
        add(LblNationality);
        
          tnation = new JTextField();
        tnation.setBounds(270, 140, 300, 25);
        add(tnation);
        
        JLabel LblAadhaar = new JLabel("Aadhaar");
        LblAadhaar.setBounds(160,190,200,25);
        LblAadhaar.setFont(new Font("thoma",Font.PLAIN, 20));
        add(LblAadhaar);
        
          taadhaar = new JTextField();
        taadhaar.setBounds(270, 190, 300, 25);
        add(taadhaar);
        
         JLabel Lbladdress = new JLabel("address");
        Lbladdress.setBounds(160,240,200,25);
        Lbladdress.setFont(new Font("thoma",Font.PLAIN, 20));
        add(Lbladdress);
        
          taddress = new JTextField();
        taddress.setBounds(270, 240, 300, 25);
        add(taddress);
        
        ButtonGroup buttongroup = new ButtonGroup();
        
        JLabel Lblgender = new JLabel("gender");
        Lblgender.setBounds(160,290,200,25);
        Lblgender.setFont(new Font("thoma",Font.PLAIN, 20));
        add(Lblgender);
        
         rmale = new JRadioButton("Male");
        rmale.setBounds(300,290,70,25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
          rfemale = new JRadioButton("Female");
        rfemale.setBounds(400,290,70,25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        buttongroup.add(rmale);
        buttongroup.add(rfemale);
        
        JLabel Lblphone = new JLabel("Number");
        Lblphone.setBounds(160,340,300,25);
        Lblphone.setFont(new Font("thoma",Font.PLAIN, 20));
        add(Lblphone);
        
          tphone = new JTextField();
        tphone.setBounds(270, 340, 300, 25);
        add(tphone);
        
        JButton button= new JButton("SAVE");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setBounds(320,410,150,30);
        add(button);
        button.addActionListener(this);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lab = new JLabel(img);
        lab.setBounds(650,80,280,380);
        add(lab);
}
     public void actionPerformed(ActionEvent ae){
         String name = tframe.getText();
         String nationality = tnation.getText();
         String aadhaar=taadhaar.getText();
         String phone = tphone.getText();
         String address = taddress.getText();
         String gender=null;
         if(rmale.isSelected())
         {
             gender= "Male";
         }
         else{
             gender="Female";
         }
     
         try{
        Conn conn = new Conn();
        String query= "insert into passanger values('"+name+"','"+nationality+"','"+aadhaar+"','"+phone+"','"+address+"','"+gender+"')";
        conn.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"customer details added successfully");
        setVisible(false);
     } catch(Exception e)
     {
         e.printStackTrace();
     }
     }   
    
    public static void main(String[] args) {
        new AddCustomer();
    }
}
