package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener{
  JTextField tfaadhar;
 JLabel  lbldate,tfname,lblfcode,tfnationality,tfaddress,labelgender,labelfname,labelfcode;
    JButton  fetchButton,flight,bookflight;
    Choice source,destination;
     JDateChooser dedate;
    public BookFlight() {
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
              
     JLabel heading= new JLabel("Book Flight");
        heading.setBounds(420,20,500,35);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        add(heading);
    
        JLabel lblaadhar= new JLabel("Aadhar Number");
       lblaadhar.setBounds(60,80,150,25);
       lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfaadhar= new JTextField();
      tfaadhar.setBounds(220,80,150,25);
         add(tfaadhar);
         
         fetchButton=new JButton("Fetch User");
         fetchButton.setBackground(Color.BLACK);
          fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80,120,25);
          fetchButton.addActionListener(this);
        add( fetchButton);
        
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(60,130,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
         tfname= new JLabel();
        tfname.setBounds(220,130,150,25);
         add(tfname);
         
         JLabel lblnationanlity= new JLabel("Nationality");
       lblnationanlity.setBounds(60,180,150,25);
        lblnationanlity.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationanlity);
        
        tfnationality= new JLabel();
        tfnationality.setBounds(220,180,150,25);
         add(tfnationality);
        
        
         
          JLabel lbladdress= new JLabel("Address");
       lbladdress.setBounds(60,230,150,25);
      lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress= new JLabel();
      tfaddress.setBounds(220,230,150,25);
         add(tfaddress);
        
         JLabel lblgender= new JLabel("Gender");
       lblgender.setBounds(60,280,150,25);
      lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
           labelgender= new JLabel("Gender");
      labelgender.setBounds(220,280,150,25);
        add(labelgender);
       
          JLabel lblsource= new JLabel("Source");
        lblsource.setBounds(60,330,150,25);
       lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
        add( lblsource);
        
         source =new Choice();
        source.setBounds(220,330,150,25);
        add(source);
        
         JLabel lbldest= new JLabel("Destination");
       lbldest.setBounds(60,380,150,25);
      lbldest.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldest);
         
          destination =new Choice();
       destination.setBounds(220,380,150,25);
        add(destination);
         try{
             Conn c= new Conn();
             String query ="select * from flight";
              ResultSet rs = c.s.executeQuery(query);
       while(rs.next()){
           source.add(rs.getNString("source"));
            destination.add(rs.getNString("destination"));
       }
       
         }
         catch(Exception e){
              e.printStackTrace();
         }
         flight= new JButton("Fetch Flights");
          flight.setBackground(Color.BLACK);
           flight.setForeground(Color.WHITE);
           flight.setBounds(380,379,120,24);
           flight.addActionListener(this);
          add( flight);
          
          
         
          JLabel lblfname= new JLabel("Flight Name");
       lblfname.setBounds(60,420,150,25);
     lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfname);
        
       labelfname= new JLabel();
    labelfname.setBounds(220,420,150,25);
         add(labelfname);
         
         
         
           lblfcode= new JLabel("Flight Code");
       lblfcode.setBounds(60,460,150,25);
      lblfcode.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfcode);
        
        labelfcode= new JLabel();
      labelfcode.setBounds(220,460,150,25);
         add(labelfcode);
        
         lbldate= new JLabel("Date of travel");
      lbldate.setBounds(60,500,150,25);
      lbldate.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldate);
        
       dedate= new JDateChooser();
     dedate.setBounds(200,500,150,25);
         add( dedate);
        
          ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
          Image i2 =i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
          ImageIcon image =new ImageIcon(i2);
          JLabel lblimage= new JLabel(image);
       lblimage.setBounds(500,80,500,400);
       add(lblimage);
          
         bookflight=new JButton("Book Flight");
         bookflight.setBackground(Color.BLACK);
          bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(200, 560,150,25);
         bookflight.addActionListener(this);
        add( bookflight);
        
        
        setSize(1050,700);
         setLocation(200, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
   if(ae.getSource()== fetchButton){
        
    String aadhar= tfaadhar.getText();
    
    try{
        Conn conn = new Conn();
        
       String query = "select * from  passenger where aadhar =('" + aadhar + "')";
    ResultSet rs =conn.s.executeQuery(query);
   if(rs.next()){
       tfname.setText(rs.getString("name"));
        tfnationality.setText(rs.getString("nationality"));
         tfaddress.setText(rs.getString("address"));
         labelgender.setText(rs.getString("gender"));
   }else{
        JOptionPane.showMessageDialog(null,"Please enter correct aadhar");
   }
    
    }catch(Exception e){
        e.printStackTrace();
    }
   }else if(ae.getSource()== flight){
        
    String src= source.getSelectedItem();
    String dest= destination.getSelectedItem();
    
    try{
        Conn conn = new Conn();
        String query = "SELECT * FROM flight WHERE source = '" + src + "' AND destination = '" + dest + "'";

     //  String query = "select * from  flight where source =('" +src+ "'and destination=('" +dest+  "')";
    ResultSet rs =conn.s.executeQuery(query);
   if(rs.next()){
       labelfname.setText(rs.getString("f_name"));
        labelfcode.setText(rs.getString("f_code"));
      }else{
        JOptionPane.showMessageDialog(null,"No Flights Found");
   }
    
    }catch(Exception e){
        e.printStackTrace();
    }
    }else{ 
       Random random =new Random();
       String aadhar=tfaadhar.getText();
     String  name = tfname.getText();
  String   nationality =  tfnationality.getText();
   String flightname =labelfname.getText();
    String  flightcode = labelfcode.getText();
         
    String src= source.getSelectedItem();
    String dest= destination.getSelectedItem();
    String ddate=((JTextField)dedate.getDateEditor().getUiComponent()).getText();
  
     try{
        Conn conn = new Conn();
        //String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', "+aadhar+",' "+name+"' , '"+nationality+"', '"+flightname+"','"+flightcode+",'""source = '" + src + "' AND destination = '" + dest +"',"+ddate+ "')";
     //  String query = "select * from  flight where source =('" +src+ "'and destination=('" +dest+  "')";
  String query = "INSERT INTO reservation (PNR, Ticket, Aadhar,name, Nationality, flightname,flightcode, src, des, ddate) VALUES ('PNR-" + random.nextInt(1000000) + "', 'TIC-" + random.nextInt(10000) + "', '" + aadhar + "', '" + name + "', '"+ nationality + "', '" + flightname + "', '" + flightcode+ "', '" +src + "', '" + dest + "', '" + ddate + "')";

    conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Ticket Booked Successfully");
  
           setVisible(false);
    }catch(Exception e){
        e.printStackTrace();
    }
   }
    }
    
     public static void main (String[] args){
    new BookFlight();
}
    
}
