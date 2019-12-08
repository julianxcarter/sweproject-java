package org.employable.View;

import java.awt.*;
import java.awt.font.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import java.util.*;



public class CampusView extends javax.swing.JFrame {

    /**
    *
    */
    private static final long serialVersionUID = 1L;
    // List of Amenities
    public static String[] amenities = { "Brail", "Ramps", "Elevators", "Accessible toilet facilities",
            "Audio-visual fire alarms", "Lowered lights switches and door handles", "Specially modified equipment",
            "Wheelchair accessible", "Adjustable desks and tables", "Stair rail", "Service dog friendly" };

    public CampusView() throws Exception {
        //Create a new JFrame for the Campus Page
        JFrame googleNY = new JFrame("Google New York");
        // make sure the page exits when the red x is pressed
        googleNY.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the dimmensions of the home page
        googleNY.setSize(700,700);

         //create a panel for the page header
         JPanel pageHeader = new JPanel();
         //add the campus location title and format
         JLabel campusTitle = new JLabel("Google New York Office");
         Font titleFont = new Font("Sans-Serif", Font.ITALIC | Font.BOLD, 12);
         Font font = titleFont.deriveFont(18F);
         campusTitle.setFont(font);
         pageHeader.add(campusTitle);


        //Create a panel for the content of the page
        JPanel contentPanel = new JPanel(new GridLayout(2, 0, 20, 20));

        //Create the panel for the top of the page
        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        //JPanel topPanel = new JPanel();

        //Create the right panel for the top of the page
        JPanel rightTopPanel = new JPanel(new GridLayout(0, 1));

        //add an image to the right top panel
        Icon image1 = new ImageIcon("google_street.jpeg");
        JButton button1 = new JButton(image1);
        rightTopPanel.add(button1);

        //Create the left panel for the top of the page with vertical alignment
        JPanel leftTopPanel = new JPanel();
        leftTopPanel.setLayout(new BoxLayout(leftTopPanel, BoxLayout.Y_AXIS));

        //Add the images to the left top panel
        Icon image2 = new ImageIcon("google_rooftop.jpeg");
        Icon image3 = new ImageIcon("google_lounge.jpeg");
        JButton button2 = new JButton(image2);
        JButton button3 = new JButton(image3);
        leftTopPanel.add(button2);
        leftTopPanel.add(button3);

        //Add the left and right panels to the top panel
        topPanel.add(rightTopPanel);
        topPanel.add(leftTopPanel);

        //create the bottom panel with vertical alignment
        JPanel bottomPanel = new JPanel(new GridLayout(0, 3, 0, 20));

        //create a panel for the list of amenities
        JPanel amenitiesPanel = new JPanel();
        amenitiesPanel.setLayout(new BoxLayout(amenitiesPanel, BoxLayout.Y_AXIS));
        //create a label for the amenities
        JLabel amenitiesLabel = new JLabel("Available Amenities:"); 
        Font amenitiesFont = new Font("Serif", Font.ITALIC | Font.BOLD, 12);
        Font newFont = amenitiesFont.deriveFont(18F);
        //set the font for the label
        amenitiesLabel.setFont(newFont);
        amenitiesPanel.add(amenitiesLabel);
        //Add the list of available amenities
        for (int i = 0; i < amenities.length; i++) {
            JLabel amenity = new JLabel(amenities[i]);
            //set the font for each amenity
            Font amenityFont = new Font("Serif", Font.PLAIN, 12);
            Font aFont = amenityFont.deriveFont(15F);
            amenity.setFont(aFont);
            //add the amenity
            amenitiesPanel.add(amenity, BorderLayout.CENTER);
        }

        //create a button for a link
        JButton linkButton = new JButton("Find more jobs at Google New York");
        linkButton.addActionListener(new ActionListener() {
            @Override
            // this button should direct a user to the company's campus job listings page
            public void actionPerformed(ActionEvent event) {
                try {
                    openWebpage(new URL("https://careers.google.com/locations/new-york/").toURI());
                } catch (MalformedURLException | URISyntaxException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            
            }
         });  
         amenitiesPanel.add(linkButton);

        //create empty panels for formatting purposes
        JPanel emptyPanel = new JPanel();
        JPanel emptyPanel2 = new JPanel();

        // add the panels to the bottom panel
        bottomPanel.add(emptyPanel);
        bottomPanel.add(amenitiesPanel);
        bottomPanel.add(emptyPanel2);

        //add the panels to the content panel
        contentPanel.add(topPanel);
        contentPanel.add(bottomPanel);

        //add the content to a panel
        JPanel pagePanel = new JPanel();
        //scrollable pane
        JScrollPane scrollPane = new JScrollPane(pagePanel);
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.setPreferredSize(new Dimension(250, 250));

        //pagePanel.setLayout(new BoxLayout(pagePanel, BoxLayout.Y_AXIS));
        pagePanel.add(pageHeader);
        pagePanel.add(contentPanel);

        

        //add the page panel to the page
        googleNY.add(pagePanel);

        googleNY.setVisible(true);

    }

    // method to support opening an external webpage
   public static boolean openWebpage(URI uri) {
    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
            desktop.browse(uri);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return false;
}
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
              public void run() {
                try {
                    new CampusView().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
              }
          });
      }
}
