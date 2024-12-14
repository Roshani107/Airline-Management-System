package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
  JTextField tfpnr;
 JLabel  lblsrc,lbldest,labeldate,lbldate,tfname,lblfcode,tfnationality,labelfname,labelfcode;
    JButton  fetchButton;
   
    
     
    public BoardingPass() {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
              
     JLabel heading= new JLabel("AIR INDIA");
        heading.setBounds(380,5,450,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
     JLabel subheading= new JLabel("Boarding Pass");
        subheading.setBounds(350,40, 300,30);
        subheading.setForeground(Color.BLUE);
        subheading.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(subheading);
    
        JLabel lblaadhar= new JLabel("PNR DETAILS");
       lblaadhar.setBounds(60,100,150,25);
       lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfpnr= new JTextField();
      tfpnr.setBounds(220,100,150,25);
         add(tfpnr);
         
         fetchButton=new JButton("Enter");
         fetchButton.setBackground(Color.BLACK);
          fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100,120,25);
          fetchButton.addActionListener(this);
        add( fetchButton);
        
        JLabel lblname= new JLabel("NAME");
        lblname.setBounds(60,140,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
         tfname= new JLabel();
        tfname.setBounds(220,140,150,25);
         add(tfname);
         
         JLabel lblnationanlity= new JLabel("NATIONALITY");
       lblnationanlity.setBounds(60,175,150,25);
        lblnationanlity.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationanlity);
        
        tfnationality= new JLabel();
        tfnationality.setBounds(220,175,150,25);
         add(tfnationality);
        
        
         
          JLabel lbladdress= new JLabel("SOURCE");
       lbladdress.setBounds(60,210,150,25);
      lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        lblsrc= new JLabel();
      lblsrc.setBounds(220,210,150,25);
         add(lblsrc);
        
         JLabel lblgender= new JLabel("DESTINATION");
       lblgender.setBounds(380,250,150,25);
      lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
           lbldest= new JLabel();
      lbldest.setBounds(530,250,150,25);
        add(lbldest);
       
          
         
          JLabel lblfname= new JLabel("FLIGHT NAME");
       lblfname.setBounds(60,250,150,25);
     lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfname);
        
       labelfname= new JLabel();
    labelfname.setBounds(220,250,150,25);
         add(labelfname);
         
         
         
           lblfcode= new JLabel("FLIGHT CODE");
       lblfcode.setBounds(60,290,150,25);
      lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfcode);
        
        labelfcode= new JLabel();
      labelfcode.setBounds(220,290,150,25);
         add(labelfcode);
        
         lbldate= new JLabel("DATE ");
      lbldate.setBounds(60,320,150,25);
      lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
       labeldate= new JLabel();
   labeldate.setBounds(220,320,150,25);
         add( labeldate);
        
          ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
          Image i2 =i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
          ImageIcon image =new ImageIcon(i2);
          JLabel lblimage= new JLabel(image);
       lblimage.setBounds(600,0,300,300);
       add(lblimage);
          
        
        setSize(940,400);
         setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
    String pnr= tfpnr.getText();
    
    try{
        Conn conn = new Conn();
        
       String query = "select * from  reservation where PNR =('" + pnr + "')";
    ResultSet rs =conn.s.executeQuery(query);
   if(rs.next()){
       tfname.setText(rs.getString("name"));
        tfnationality.setText(rs.getString("Nationality"));
          lblsrc.setText(rs.getString("src"));
          lbldest.setText(rs.getString("des"));
         labelfname.setText(rs.getString("flightname"));
         labelfcode.setText(rs.getString("flightcode"));
          labeldate.setText(rs.getString("ddate"));
   
   }else{
        JOptionPane.showMessageDialog(null,"No  BOOked Flights Found");
   }
    
    }catch(Exception e){
        e.printStackTrace();
    }
   }
    
     public static void main (String[] args){
    new BoardingPass();
}
    
}
