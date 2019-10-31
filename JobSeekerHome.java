import javax.swing.*;

//import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

import java.awt.*;
import java.lang.*;
import java.net.URI;

class JobSeekerHome{
    public static void main(String args[]){
        //create the frame
       JFrame frame = new JFrame("Home Page");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(500,500);
    
       //Create search panel
       JPanel panel = new JPanel();
       JButton profile = new JButton("Profile");
       JTextField universalSearchBox = new JTextField("Search Company", 20);
       JButton search = new JButton("Search");
       panel.add(profile);
       panel.add(universalSearchBox);
       panel.add(search);

       //section header
       //JPanel jText = new JPanel();
       JLabel jobListings = new JLabel("Recommended Jobs for You");
       JLabel blank = new JLabel("");
       JLabel anotherBlank = new JLabel("");
       //jText.add(jobListings);
       
       
       JPanel jobRecPanel = new JPanel();
       jobRecPanel.setLayout(new GridLayout(2,3));
       //job listing panels
       JTextArea jobListing1 = new JTextArea(5, 20);
       jobListing1.setPreferredSize(new Dimension(200,5));
       jobListing1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
       StringBuffer jobList1 = new StringBuffer();
       jobList1.append("Comcast");
       jobList1.append("\nSoftware Engineer - Xfi Team");
       jobList1.append("\nPhiladelphia, PA");
       jobList1.append("\nDescription?");
       jobList1.append("\nhttps://jobs.comcast.com");

       jobListing1.setText(jobList1.toString());
       //jobRecPanel.add(jobListing1);

       JTextArea jobListing2 = new JTextArea(5, 20);
       jobListing2.setPreferredSize(new Dimension(200,5));
       jobListing2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
       StringBuffer jobList2 = new StringBuffer();
       jobList2.append("Adobe");
       jobList2.append("\nUX Design");
       jobList2.append("\nSan Fransisco, CA");
       jobList2.append("\nDescription?");
       jobList2.append("\nhttps://www.adobe.com/careers.html");

       jobListing2.setText(jobList2.toString());

       
       JTextArea jobListing3 = new JTextArea(5,20);
       jobListing3.setPreferredSize(new Dimension(200,5));
       jobListing3.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
       StringBuffer jobList3 = new StringBuffer();
       jobList3.append("Google");
       jobList3.append("\nEngineering Rotational Program");
       jobList3.append("\nNew York City, New York");
       jobList3.append("\nDescription?");
       jobList3.append("\nhttps://careers.google.com");

       jobListing3.setText(jobList3.toString());
       jobRecPanel.add(jobListings);
       jobRecPanel.add(blank);
       jobRecPanel.add(anotherBlank);
       jobRecPanel.add(jobListing1);
       jobRecPanel.add(jobListing2);
       jobRecPanel.add(jobListing3);
        
       //top rated companies panel
       JPanel topComPanel = new JPanel();
       topComPanel.setLayout(new GridLayout(2,3));
       JLabel topCompanies = new JLabel("Top Companies");
       JLabel thisBlank = new JLabel("");
       JLabel thatBlank = new JLabel("");
       JTextArea topCompany1 = new JTextArea(5, 20);
       topCompany1.setPreferredSize(new Dimension(200,5));
       topCompany1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
       StringBuffer company1 = new StringBuffer();
       company1.append("Adobe");
       company1.append("\nSeattle, WA");


       topCompany1.setText(company1.toString());

        JTextArea topCompany2 = new JTextArea(5, 20);
        topCompany2.setPreferredSize(new Dimension(200,5));
        topCompany2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        StringBuffer company2 = new StringBuffer();
        company2.append("Pivotal");
        company2.append("\nNew York, NY");


        topCompany2.setText(company2.toString());

        //top rated companies panel
       JTextArea topCompany3 = new JTextArea(5, 20);
       topCompany3.setPreferredSize(new Dimension(200,5));
       topCompany3.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
       StringBuffer company3 = new StringBuffer();
       company3.append("Coca-cola");
       company3.append("\nAtlanta, GA");


       topCompany3.setText(company3.toString());
       topComPanel.add(topCompanies);
       topComPanel.add(thisBlank);
       topComPanel.add(thatBlank);
       topComPanel.add(topCompany1);
       topComPanel.add(topCompany2);
       topComPanel.add(topCompany3);

       //Add components to the frame
       frame.getContentPane().add(BorderLayout.NORTH, panel);
       frame.getContentPane().add(BorderLayout.EAST,jobRecPanel);
       frame.getContentPane().add(BorderLayout.SOUTH, topComPanel);
       //frame.add(jobRecPanel);
       //frame.getContentPane().add(BorderLayout.LINE_END,jobListing3);
       //frame.getContentPane().add(BorderLayout.SOUTH, topCompPanel);
       //frame.getContentPane().add(BorderLayout.CENTER, topCompany2);
       //frame.getContentPane().add(BorderLayout.LINE_END, topCompany3);
       //frame.getContentPane().add(BorderLayout.CENTER, ta);
       frame.pack();
       frame.setVisible(true);
    }
}