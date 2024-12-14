
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {
    
    
    public Home(){
        
       setLayout(null);
       ImageIcon il= new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
       JLabel image= new JLabel(il);
       image.setBounds(0,0,1290,650);
       add(image); 
       
        JLabel heading= new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(400,20,1000,35);
        heading.setForeground(Color.blue);
        heading.setFont(new Font("Tahoma",Font.PLAIN,34));
        image.add(heading);
        
        JMenuBar menubar =new JMenuBar();
        setJMenuBar(menubar);
        
         JMenu details =new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails =new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
          JMenuItem customerDetails =new JMenuItem("Add Customer Details");
         customerDetails.addActionListener(this);
          details.add(customerDetails);
          
           JMenuItem bookFlight =new JMenuItem(" Book Flight ");
        bookFlight.addActionListener(this);
           details.add(bookFlight );
        
        
        JMenuItem journeyDetails =new JMenuItem("Journey Details");
       journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
          JMenuItem ticketCancelation =new JMenuItem("Cancel Ticket");
           ticketCancelation.addActionListener(this);
        details.add(ticketCancelation);
        
        JMenu ticket =new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass =new JMenuItem("Boarding Pass");
           boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
         
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
       String text = ae.getActionCommand();
       if(text.equals("Add Customer Details")){
              new AddCostumer();
       } 
       else if(text.equals("Flight Details")){
             new FlightInformation();
               }
       else if(text.equals(" Book Flight ")){
             new BookFlight();
               }
       else if(text.equals("Journey Details")){
             new JourneyDetails();
               }
        else if(text.equals("Cancel Ticket")){
             new Cancel();
               }
        else if(text.equals("Boarding Pass")){
             new BoardingPass();
               }
    }
    public static void main (String[] args){
    new Home();
}
}
