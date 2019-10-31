package View;

import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;


public class userProfileView extends javax.swing.JFrame {

    //List of amenities
    public static String[] amenities = {"Brail", "Ramps", "Elevators", 
    "Accessible toilet facilities", "Audio-visual fire alarms", 
    "Lowered lights switches and door handles", 
    "Specially modified equipment", "Wheelchair accessible", 
    "Adjustable desks and tables", "Stair rail", 
    "Service dog friendly"};
    //List of locations
    public static String[] desiredLocations = {"New York", "Los Angeles", 
    "San Francisco" ,"Atlanta", "D.C", "New Jersey", "Seattle", "Houston", "Austin"};


    public userProfileView() {
        //create frame for the userProfile Page
        JFrame profilePage = new JFrame("Profile");
        // make sure the page exits when the red x is pressed
        profilePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the dimmensions of the home page
        profilePage.setBounds(0, 0, 800, 800);
        profilePage.setLayout(null);  
        profilePage.setVisible(true);  

        //Create a label for the amenities checkbox
        final Label amenitiesLabel = new Label();          
        amenitiesLabel.setLocation(profilePage.getWidth()/2 - 50, 5);
        amenitiesLabel.setSize(400,100);
        amenitiesLabel.setText("Amenities");
        profilePage.add(amenitiesLabel);

        //Configure the checkbox
        for (int i = 0; i < amenities.length; i++) {
            Checkbox checkbox = new Checkbox(amenities[i]);
            int y = 50 + i*32;
            checkbox.setBounds(amenitiesLabel.getX() - 150, y, 300, 50);
            profilePage.add(checkbox);
        }

        //Add a panel for the preferred locations
        final JPanel locationsPanel = new JPanel();
         JLabel locationsLabel = new JLabel("Preferred Locations:");

        //Configure the panel
        locationsPanel.setLayout(new BoxLayout(locationsPanel, BoxLayout.Y_AXIS));
        locationsPanel.setBounds(50, 500, 400, 400);
        // place label at the top of the panel
        locationsPanel.add(locationsLabel, BorderLayout.NORTH);
        locationsPanel.setVisible(true);

        //add a button to add new locations
        JButton plusButton = new JButton("+");
        plusButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent event) {
                JPanel newLocation = new JPanel();
                newLocation.setLayout(new GridLayout(0,2,20,20));
                JComboBox<String> userLocations = new JComboBox<>(desiredLocations);
                //add a remove button
                JButton removeButton = new JButton("Remove");  
                removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    newLocation.getParent().remove(newLocation);
                    locationsPanel.revalidate();
                    locationsPanel.repaint();
                }
            });

            newLocation.add(userLocations);
            newLocation.add(removeButton);

            locationsPanel.add(newLocation);
            locationsPanel.revalidate();
            locationsPanel.repaint();
        }
    });
        locationsPanel.add(plusButton);
        plusButton.setBounds(locationsPanel.getX() + 50, locationsPanel.getY(), 50, 50);
        //profilePage.add(locationsPanel);
        profilePage.add(locationsPanel, BorderLayout.WEST);



    //Add a panel for the preferred locations
        final JPanel locationsPanel = new JPanel();
         JLabel locationsLabel = new JLabel("Preferred Locations:");

        //Configure the panel
        locationsPanel.setLayout(new BoxLayout(locationsPanel, BoxLayout.Y_AXIS));
        locationsPanel.setBounds(50, 500, 400, 400);
        // place label at the top of the panel
        locationsPanel.add(locationsLabel, BorderLayout.NORTH);
        locationsPanel.setVisible(true);

        //add a button to add new locations
        JButton plusButton = new JButton("+");
        plusButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent event) {
                JPanel newLocation = new JPanel();
                newLocation.setLayout(new GridLayout(0,2,20,20));
                JComboBox<String> userLocations = new JComboBox<>(desiredLocations);
                //add a remove button
                JButton removeButton = new JButton("Remove");  
                removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    newLocation.getParent().remove(newLocation);
                    locationsPanel.revalidate();
                    locationsPanel.repaint();
                }
            });

            newLocation.add(userLocations);
            newLocation.add(removeButton);

            locationsPanel.add(newLocation);
            locationsPanel.revalidate();
            locationsPanel.repaint();
        }
    });
        locationsPanel.add(plusButton);
        plusButton.setBounds(locationsPanel.getX() + 50, locationsPanel.getY(), 50, 50);
        //profilePage.add(locationsPanel);
        profilePage.add(locationsPanel, BorderLayout.WEST);

       
     }  
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userProfileView().setVisible(true);
            }
        });

    }
}