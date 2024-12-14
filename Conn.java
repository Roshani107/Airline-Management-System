package airlinemanagementsystem;

import java.sql.*;
public class Conn {
    Connection c;
    Statement  s;
    
   public Conn(){
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
       /* c = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "");*/
       c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "Roshani@1234");

         s= c.createStatement();
    }catch(Exception e){
    e.printStackTrace();
    }
   }
}
