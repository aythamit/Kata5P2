package Vista;

import Modelo.Mail;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailListReaderDDBB {
    
     public static List<Mail> read() {
         List<Mail> mails = new ArrayList<Mail>();
         String query;
         query="SELECT Mail FROM MAIL";
         
         try {
             
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:KATA5.db");
            Statement statement = connection.createStatement();      
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
            mails.add(new Mail(rs.getString("Mail")));    
            }
            return mails;
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(MailListReaderDDBB.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(MailListReaderDDBB.class.getName()).log(Level.SEVERE, null, ex);
         }

        
         return null;
     }
    
    
}
