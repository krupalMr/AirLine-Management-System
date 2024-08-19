

package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
    JTextField taadhaar;
    JLabel tname,tphone,tnation,taddress,Lblgender,tsource,tdest,Lblfname,Lblfcode;
    JButton fbutton,button,flights;
    Choice source ,dest;
    JDateChooser jdate;
    
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE);
       setLayout(null);
        setSize(900,600);
        setVisible(true);
    
        JLabel heading = new JLabel("Book Flight");
       heading.setBounds(420,20,400,25);
        heading.setFont(new Font("thoma",Font.PLAIN, 32));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel LblAadhaar = new JLabel("Aadhaar");
        LblAadhaar.setBounds(160,90,100,25);
        LblAadhaar.setFont(new Font("thoma",Font.PLAIN, 20));
        add(LblAadhaar);
        
          taadhaar = new JTextField();
        taadhaar.setBounds(270, 90, 200, 25);
        add(taadhaar);
        
         button= new JButton("Fetch");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        button.setBounds(490,90,100,25);
        button.addActionListener(this);
        add(button);
       
        
        JLabel LblName = new JLabel("Name");
        LblName.setBounds(160,140,100,25);
        LblName.setFont(new Font("thoma",Font.PLAIN, 20));
        add(LblName);
        
          tname = new JLabel();
        tname.setBounds(270, 140, 200, 25);
        add(tname);
        
        JLabel LblNationality = new JLabel("Nationality");
        LblNationality.setBounds(160,190,200,25);
        LblNationality.setFont(new Font("thoma",Font.PLAIN, 20));
        add(LblNationality);
        
          tnation = new JLabel();
        tnation.setBounds(270, 190, 300, 25);
        add(tnation);
        
        
        
         JLabel Lbladdress = new JLabel("address");
        Lbladdress.setBounds(160,240,200,25);
        Lbladdress.setFont(new Font("thoma",Font.PLAIN, 20));
        add(Lbladdress);
        
          taddress = new JLabel();
        taddress.setBounds(270, 240, 300, 25);
        add(taddress);
        
       
       
         Lblgender = new JLabel("gender");
        Lblgender.setBounds(160,290,200,25);
         Lblgender.setFont(new Font("thoma",Font.PLAIN, 20));
         add(Lblgender);
        
          tsource = new JLabel("Source");
        tsource.setBounds(160,340,100,25);
         tsource.setFont(new Font("thoma",Font.PLAIN, 20));
         add(tsource);
         
          source = new Choice();
         source.setBounds(300,340,200,25);
         add(source);
         
        tdest = new JLabel("Destination");
        tdest.setBounds(160,390,140,25);
         tdest.setFont(new Font("thoma",Font.PLAIN, 20));
         add(tdest);
         
        dest = new Choice();
         dest.setBounds(300,390,200,25);
         add(dest);
        
          flights= new JButton("Fetch Flights");
        flights.setBackground(Color.BLACK);
        flights.setForeground(Color.white);
        flights.setBounds(520,390,150,25);
        flights.addActionListener(this);
        add(flights);
        
          JLabel fname = new JLabel("Flight Code");
        fname.setBounds(160,440,140,25);
        fname.setFont(new Font("thoma",Font.PLAIN, 20));
        add(fname);
        
          Lblfname = new JLabel();
        Lblfname.setBounds(320, 440, 140, 25);
        add(Lblfname);
               
        JLabel fcode = new JLabel("Flight Code");
        fcode.setBounds(160,490,140,25);
        fcode.setFont(new Font("thoma",Font.PLAIN, 20));
        add(fcode);
        
          Lblfcode = new JLabel();
        Lblfcode.setBounds(320, 490, 140, 25);
        add(Lblfcode);
        
        JLabel fdate = new JLabel("Date of travel");
        fdate.setBounds(160,540,140,25);
        fdate.setFont(new Font("thoma",Font.PLAIN, 20));
        add(fdate);
        
         jdate = new JDateChooser();
        jdate.setBounds(320,540,140,25);
        add(jdate);
             
   
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lab = new JLabel(image);
        lab.setBounds(850,80,500,380);
        add(lab);
        
         fbutton= new JButton("Book Flight");
        fbutton.setBackground(Color.BLACK);
        fbutton.setForeground(Color.white);
        fbutton.setBounds(320,600,150,30);
        add(fbutton);
        fbutton.addActionListener(this);
        
        try{
            Conn conn = new Conn();
            String query = "select *from flight";
            ResultSet rs= conn.s.executeQuery(query);
            
            while(rs.next())
            {
             source.add(rs.getString("source"));
             dest.add(rs.getString("dest"));
               
            }
        }catch(Exception e){
            e.printStackTrace();
        }
       
}
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource()==button){
         String aadhar= taadhaar.getText();
         try{
        Conn conn = new Conn();
        String query= "select * from  passanger where aadhaar='"+aadhar+"'";
        ResultSet rs=  conn.s.executeQuery(query);
        
        if(rs.next()){
           tname.setText(rs.getString("name"));
           tnation.setText(rs.getString("nationality"));
           taddress.setText(rs.getString("address"));
           Lblgender.setText(rs.getString("gender"));
        }else{
            JOptionPane.showMessageDialog(null,"Please update correct aadhar");
            setVisible(false);
        }
        
     } catch(Exception e)
     {
         e.printStackTrace();
     }
     }   
         
         
      else  if(ae.getSource()==flights){
           String src= source.getSelectedItem();
           String des = dest.getSelectedItem();
         try{
        Conn conn = new Conn();
        String query= "select * from  flight where source='"+src+"' and dest='"+des+"'" ;
        ResultSet rs=  conn.s.executeQuery(query);
        
        if(rs.next()){
           Lblfname.setText(rs.getString("f_name"));
            Lblfcode.setText(rs.getString("f_code"));
        }else{
            JOptionPane.showMessageDialog(null,"No Flights found");
        }
    
     } catch(Exception e)
     {
         e.printStackTrace();
     }             
     }
      else{
          Random random = new Random();
           String aadhar= taadhaar.getText();
           String name = tname.getText();
           String nationality= tnation.getText();
           String flightname= Lblfname.getText();
           String flightcode = Lblfcode.getText();
           String src= source.getSelectedItem();
           String des= dest.getSelectedItem();
           String ddate=((JTextField) jdate.getDateEditor().getUiComponent()).getText();
           
          try{
        Conn conn = new Conn();
        String query= "insert into reservation values('PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(1000000)+"','"+name+"','"+nationality+"','"+aadhar+"','"+flightname+"','"+flightcode+"','"+src+"','"+des+"')";
        conn.s.executeUpdate(query);
        JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");
       
     } catch(Exception e)
     {
         e.printStackTrace();
     }          
      }
     }
     
    public static void main(String[] args) {
        new BookFlight();
    }
}
