package org.employable.View;

//import org.employable.Controller;
//import org.employable.Controller.JobSeekerController;
//import org.employable.Controller.RecruiterController;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.net.URI;


public class JobSeekerHomeView extends javax.swing.JFrame{

    private static final long serialVersionUID = 1L;
    public static String[] searchParamaters = {"Company", "Location", "Position"};

    public JobSeekerHomeView(){
        //create the frame
        JFrame frame = new JFrame("Home Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        //Create search panel
        JPanel panel = new JPanel();
        //Profile button
        JButton profile = new JButton("Profile");
        JTextField universalSearchBox = new JTextField("Search Company", 10);
        //Combo box for search parameters
        JComboBox<String> searchList = new JComboBox<>(searchParamaters);
       


        //Search button
        JButton search = new JButton("Search");
        profile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //connect to job seeker profile via the controller
                //JobSeekerController.loadProfileView();
                // display/center the jdialog when the button is pressed
                JOptionPane.showMessageDialog(frame,"You have chosen to go to your profile.");
            }
        });
        
        search.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // display/center the jdialog when the button is pressed
                String company = universalSearchBox.getText();
                //display job listings based on the user's search
                JOptionPane.showMessageDialog(frame,"You searched for "+ company);
            }
        });
        panel.add(profile);
        panel.add(universalSearchBox);
        panel.add(searchList);
        panel.add(search);
        


        //create panel for job listings
        JPanel jobRecPanel = new JPanel();
        JEditorPane jobLink1 = new JEditorPane();

        jobRecPanel.setLayout(new GridLayout(2,3));

        //section header with left justification
        JLabel jobListings = new JLabel("Recommended Jobs for You");
        JLabel blank = new JLabel("");
        JLabel anotherBlank = new JLabel("");
        jobRecPanel.add(jobListings);
        jobRecPanel.add(blank);
        jobRecPanel.add(anotherBlank);

        //add listing with links
        jobLink1.setEditable(false);//make text box uneditable
        jobLink1.setContentType("text/html");
        StringBuilder link1 = new StringBuilder();
        //get the listings from the model/controller
        link1.append("Comcast<br>");
        link1.append("Software Engineer - Xfi Team<br>");
        link1.append("Philadelphia, PA<br>");
        link1.append("<a href='https://jobs.comcast.com'>https://jobs.comcast.com</a>");
        jobLink1.setText(link1.toString());
        //allow the hyperlink to be clickable
        jobLink1.addHyperlinkListener(e ->{
            if(HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType())){
                System.out.println(e.getURL());
                Desktop desktop = Desktop.getDesktop();
                try{
                    desktop.browse(e.getURL().toURI());
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        //format the text pane
        jobLink1.setPreferredSize(new Dimension(300,100));
        jobLink1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        //add the pane to the panel
        jobRecPanel.add(jobLink1);

        //second job listing with link
        JEditorPane jobLink2 = new JEditorPane();
        jobLink2.setEditable(false); //noneditable
        jobLink2.setContentType("text/html");
        StringBuilder link2 = new StringBuilder();
        link2.append("Adobe<br>");
        link2.append("UX Designer<br>");
        link2.append("San Fransisco, CA<br>");
        link2.append("<a href='https://www.adobe.com/careers.html'>https://www.adobe.com/careers.html</a>");
        jobLink2.setText(link2.toString());
        //make link clickable
        jobLink2.addHyperlinkListener(e ->{
            if(HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType())){
                System.out.println(e.getURL());
                Desktop desktop = Desktop.getDesktop();
                try{
                    desktop.browse(e.getURL().toURI());
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        //format the text pane
        jobLink2.setPreferredSize(new Dimension(200,100));
        jobLink2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        //add the pane to the panel
        jobRecPanel.add(jobLink2);

        //third job listing with link
        JEditorPane jobLink3 = new JEditorPane();
        jobLink3.setEditable(false);//noneditable
        jobLink3.setContentType("text/html");
        StringBuilder link3 = new StringBuilder();
        link3.append("Google<br>");
        link3.append("Engineering Rotational Program<br>");
        link3.append("New York City, NY<br>");
        link3.append("<a href='https://careers.google.com'>https://careers.google.com  </a>");
        jobLink3.setText(link3.toString());
        //make link clickable
        jobLink3.addHyperlinkListener(e ->{
            if(HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType())){
                System.out.println(e.getURL());
                Desktop desktop = Desktop.getDesktop();
                try{
                    desktop.browse(e.getURL().toURI());
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        //format the pane
        jobLink3.setPreferredSize(new Dimension(200,100));
        jobLink3.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        //add pane to the area
        jobRecPanel.add(jobLink3);

        //top rated companies panel with heading left justified
        JPanel topCompPanel = new JPanel();
        topCompPanel.setLayout(new GridLayout(2,3));
        JLabel topCompanies = new JLabel("Top Companies");
        JLabel thisBlank = new JLabel("");
        JLabel thatBlank = new JLabel("");
        JTextArea topCompany1 = new JTextArea(5, 20);
        topCompany1.setEditable(false);//noneditable
        //format area
        topCompany1.setPreferredSize(new Dimension(200,5));
        topCompany1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        StringBuffer company1 = new StringBuffer();
        company1.append("Adobe");
        company1.append("\nSeattle, WA");

        //add text to the area
        topCompany1.setText(company1.toString());

        //second company
        JTextArea topCompany2 = new JTextArea(5, 20);
        topCompany2.setEditable(false);//noneditable
        //format area
        topCompany2.setPreferredSize(new Dimension(200,5));
        topCompany2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        StringBuffer company2 = new StringBuffer();
        company2.append("Pivotal");
        company2.append("\nNew York, NY");

        //add text to the area
        topCompany2.setText(company2.toString());

        //thrid company
        JTextArea topCompany3 = new JTextArea(5, 20);
        topCompany3.setEditable(false); //noneditable
        //format area
        topCompany3.setPreferredSize(new Dimension(200,5));
        topCompany3.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        StringBuffer company3 = new StringBuffer();
        company3.append("Coca-Cola");
        company3.append("\nAtlanta, GA");

        //add taxt to the area
        topCompany3.setText(company3.toString());
        //add the heading and the companies to the panel
        topCompPanel.add(topCompanies);
        topCompPanel.add(thisBlank);
        topCompPanel.add(thatBlank);
        topCompPanel.add(topCompany1);
        topCompPanel.add(topCompany2);
        topCompPanel.add(topCompany3);

        //add all of the panels to the frame and with layout specifications
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.WEST, jobRecPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, topCompPanel);
        //make everything visible and pack frame
        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobSeekerHomeView().setVisible(true);
            }
        });
    }
}


