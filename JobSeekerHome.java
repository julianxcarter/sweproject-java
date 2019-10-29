import javax.swing.*;

import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

import java.awt.*;
import java.lang.*;
import java.net.URI;

class JobSeekerHome{
    public static void main(String args[]){
        //create the frame
       JFrame frame = new JFrame("Home Page");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(1000,1000);
    
       //Create search panel
       JPanel panel = new JPanel();
       JTextField universalSearchBox = new JTextField("Search Company", 20);
       JButton search = new JButton("Search");
       panel.add(universalSearchBox);
       panel.add(search);


       //section header
       JLabel jobListings = new JLabel("Recommended Jobs for You");
       //job listings panels
       JTextArea jobListing1 = new JTextArea(5, 20);
       jobListing1.setPreferredSize(new Dimension(200,5));
       jobListing1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
       StringBuffer jobList1 = new StringBuffer();
       jobList1.append("Comcast");
       jobList1.append("\nSoftware Engineer - Xfi Team");
       jobList1.append("\nDescription?");
       jobList1.append("\nhttps://jobs.comcast.com");

       jobListing1.setText(jobList1.toString());
       panel.add(jobListings);

       JTextArea jobListing2 = new JTextArea(5, 20);
       jobListing2.setPreferredSize(new Dimension(200,5));
       jobListing2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
       StringBuffer jobList2 = new StringBuffer();
       jobList2.append("Adobe");
       jobList2.append("\nUX Design");
       jobList2.append("\nDescription?");
       jobList2.append("\nhttps://www.adobe.com/careers.html");

       jobListing2.setText(jobList2.toString());

       
       JTextArea jobListing3 = new JTextArea(5,20);
       jobListing3.setPreferredSize(new Dimension(200,5));
       jobListing3.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
       StringBuffer jobList3 = new StringBuffer();
       jobList3.append("Google");
       jobList3.append("\nEngineering Rotational Program");
       jobList3.append("\nDescription?");
       jobList3.append("\nhttps://careers.google.com");

       jobListing3.setText(jobList3.toString());

       //top rated companies panel
       JTextArea topCompany1 = new JTextArea(5, 20);
       topCompany1.setPreferredSize(new Dimension(200,5));
       topCompany1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
       StringBuffer company1 = new StringBuffer();
       company1.append("Adobe");
       company1.append("\nSeattle, WA");


       jobListing1.setText(jobList1.toString());

       //Add components to the frame
       frame.getContentPane().add(BorderLayout.NORTH, panel);
       frame.getContentPane().add(BorderLayout.LINE_START,jobListing1);
       frame.getContentPane().add(BorderLayout.CENTER,jobListing2);
       frame.getContentPane().add(BorderLayout.LINE_END,jobListing3);
       frame.getContentPane().add(BorderLayout.AFTER_LAST_LINE, topCompany1);
       //frame.getContentPane().add(BorderLayout.CENTER, ta);
       frame.setVisible(true);
    }
}