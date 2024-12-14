package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;

import java.sql.*;
import net.proteanit.sql.DbUtils;


public class FlightInformation extends JFrame {
    public FlightInformation(){
    getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JTable table =new JTable();
         try{
                Conn conn= new Conn();
               
              
             ResultSet rs = conn.s.executeQuery("select* from flight");
           
             table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch(Exception e){
                e.printStackTrace();
            }
         JScrollPane jsp=new JScrollPane(table);
         jsp.setBounds(0,0,800, 500);
         add(jsp);
    setSize(800,450);
         setLocation(350, 150);
        setVisible(true);
    /*setSize(800,500);
         setLocation(400, 250);
        setVisible(true);*/
    }
     public static void main (String[] args){
    new FlightInformation();
}
    
}
