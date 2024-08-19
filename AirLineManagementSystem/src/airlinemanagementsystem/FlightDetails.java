
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightDetails extends JFrame{
  public FlightDetails(){
      setLayout(null);
      getContentPane().setBackground(Color.WHITE);
      setSize(800,500);
      setLocation(400,200);
      setVisible(true);
      
      JTable tablet = new JTable();
      try{
          
          Conn conn= new Conn();
         ResultSet rs= conn.s.executeQuery("select * from flight");
          tablet.setModel(DbUtils.resultSetToTableModel(rs));
          
      }catch(Exception e)
      {
          e.printStackTrace();
      }
      JScrollPane jsp = new JScrollPane(tablet);
      jsp.setBounds(0,0,800,500);
      add(jsp);
  }
    public static void main(String[] args) {
        new FlightDetails();
    }
}
