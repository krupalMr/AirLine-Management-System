
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener{
  
    public Home(){
        
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ImageIcon  I1= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image = new JLabel(I1);
        image.setBounds(0,0,1900,800);
        add(image);
        
        JMenuBar menuBar= new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu details = new JMenu("Details");
        menuBar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("FlightDetails");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("add customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem reservationDetails = new JMenuItem("Add reservation Details");
        details.add(reservationDetails);
        
        JMenuItem BookFlight = new JMenuItem("BookFlight");
        details.add(BookFlight);
        
        JMenuItem journeyDetails = new JMenuItem("journeyDetails");
        details.add(journeyDetails);
        
        JMenuItem cancellationDetails = new JMenuItem("cancel ticket");
        details.add(cancellationDetails);
        
        JMenu ticket = new JMenu("ticket");
        menuBar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("boardingPass");
        ticket.add(boardingPass);
        
        JLabel heading= new JLabel("AIR INDIA WElCOMES YOU");
        heading.setBounds(500,40,900,40);
        image.add(heading);
        heading.setForeground(Color.blue);
        heading.setFont(new Font("Tahoma",Font.PLAIN,36));
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String text= ae.getActionCommand();
        
        if(text.equals("FlightDetails")){
            new flightInfo();
        }
        else if (text.equals("add customer Details")){
            new AddCustomer();
        }
    }
    
    public static void main(String[] args) {
        new Home();
    }
}

