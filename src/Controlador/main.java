/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Histogram;
import Modelo.Mail;
import Vista.HistogramDisplay;
import Vista.MailHistogramBuilder;
import Vista.MailListReaderDDBB;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static List<Mail> mails;
    public static Histogram<String> histogram;
    public static HistogramDisplay histoDisplay;
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        execute();
        }

    private static void execute() throws FileNotFoundException, IOException {
        input();
        process();
        output();
     }

    private static void input() throws FileNotFoundException, IOException {
           mails= new ArrayList<Mail>();
           mails = MailListReaderDDBB.read();
    }

    private static void process() {
         histogram= MailHistogramBuilder.build(mails);}

    private static void output() {
        histoDisplay = new HistogramDisplay(histogram);  
        histoDisplay.execute();}
        
    }

