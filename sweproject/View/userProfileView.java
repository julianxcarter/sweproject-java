package View;

import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;


public class userProfileView extends javax.swing.JFrame {

    //List of Amenities
    public static String[] amenities = {"Brail", "Ramps", "Elevators", 
    "Accessible toilet facilities", "Audio-visual fire alarms", 
    "Lowered lights switches and door handles", 
    "Specially modified equipment", "Wheelchair accessible", 
    "Adjustable desks and tables", "Stair rail", 
    "Service dog friendly"};
    //List of Locations
    public static String[] desiredLocations = {"New York", "Los Angeles", 
    "San Francisco" ,"Atlanta", "D.C", "New Jersey", "Seattle", "Houston", "Austin"};
    //List of Positions
    public static String[] desiredPositions = {"Software Engineer", "Accountant", 
    "Data Analyst","Consultant", "Account Manager", "Human Resources Personnel", 
    "Receptionist", "Assistant", "Project Manager"};


    public userProfileView() {
       
        //Layout source: https://stackoverflow.com/questions/11790830/setting-jpanel-layout
        //source: https://www.javatpoint.com/java-awt-checkbox

        //*****************_AMENITIES_**********************
        //Amenities Panel will be centered in the upper panel
        JPanel amenitiesPanel = new JPanel();
        amenitiesPanel.setBackground(Color.red);
        //Create a label for the amenities checkbox
        BoxLayout boxLayoutA = new BoxLayout(amenitiesPanel, BoxLayout.Y_AXIS);
        amenitiesPanel.setLayout(boxLayoutA);
        final Label amenitiesLabel = new Label();          
        //amenitiesLabel.setLocation(profilePage.getWidth()/2 - 50, 5);
        amenitiesLabel.setSize(100,100);
        amenitiesLabel.setText("Amenities");
        amenitiesPanel.add(amenitiesLabel, BorderLayout.CENTER);
        //Configure the checkbox
        for (int i = 0; i < amenities.length; i++) {
            Checkbox checkbox = new Checkbox(amenities[i]);
            amenitiesPanel.add(checkbox, BorderLayout.CENTER);
        }

        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.setBackground(Color.MAGENTA);
        upperPanel.add(amenitiesPanel, BorderLayout.CENTER);

        //*****************_LOCATIONS_**********************
        //locations panel will be in on the left side of the lowerPanel
        JPanel locationsPanel = new JPanel();
        JLabel locationsLabel = new JLabel("Preferred Locations:");

        //Configure the panel
        BoxLayout boxLayout = new BoxLayout(locationsPanel, BoxLayout.Y_AXIS);
        locationsPanel.setLayout(boxLayout);
        //locationsPanel.setLayout(new BoxLayout(locationsPanel, BoxLayout.Y_AXIS));
        //locationsPanel.setBounds(50, 500, 300, 400);
        locationsPanel.setBackground(Color.CYAN);
        // place label at the top of the panel
        locationsPanel.add(locationsLabel, BorderLayout.NORTH);
        //add a button to add new locations
        JButton plusButton = new JButton("+");
        plusButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent event) {
                JPanel newLocationPanel = new JPanel();
                newLocationPanel.setLayout(new GridLayout(0,2,20,20));
                JComboBox<String> userLocations = new JComboBox<>(desiredLocations);
                //add a remove button
                JButton removeButton = new JButton("Remove");  
                removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    newLocationPanel.getParent().remove(newLocationPanel);
                    locationsPanel.revalidate();
                    locationsPanel.repaint();
                }
            });

            newLocationPanel.add(userLocations);
            newLocationPanel.add(removeButton);

            locationsPanel.add(newLocationPanel);
            locationsPanel.revalidate();
            locationsPanel.repaint();
        }
    });
        locationsPanel.add(plusButton);

        //*****************_POSITIONS_**********************
        //positions panel will be in on the right side of the lowerPanel
        JPanel positionsPanel = new JPanel();
        JLabel positionsLabel = new JLabel("Preferred Positions:");

        //Configure the panel
        BoxLayout boxLayoutP = new BoxLayout(positionsPanel, BoxLayout.Y_AXIS);
        positionsPanel.setLayout(boxLayoutP);
        //positionsPanel.setLayout(new BoxLayout(locationsPanel, BoxLayout.Y_AXIS));
        positionsPanel.setBackground(Color.GREEN);
        // place label at the top of the panel
        positionsPanel.add(positionsLabel, BorderLayout.NORTH);

        //add a button to add new locations
        JButton plusButtonP = new JButton("+");
        plusButtonP.addActionListener(new ActionListener() {
             @Override
            public void actionPerformed(ActionEvent event) {
                JPanel newPositionPanel = new JPanel();
                newPositionPanel.setLayout(new GridLayout(0,2,20,20));
                JComboBox<String> userPositions = new JComboBox<>(desiredPositions);
                //add a remove button
                JButton removeButtonP = new JButton("Remove");  
                removeButtonP.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    newPositionPanel.getParent().remove(newPositionPanel);
                    positionsPanel.revalidate();
                    positionsPanel.repaint();
                }
              });
        newPositionPanel.add(userPositions);
        newPositionPanel.add(removeButtonP);

        positionsPanel.add(newPositionPanel);
        positionsPanel.revalidate();
        positionsPanel.repaint();
      }
  });
      positionsPanel.add(plusButtonP);

      //LOWER PANEL
      JPanel lowerPanel = new JPanel(new BorderLayout());
      lowerPanel.setBackground(Color.ORANGE);
      JPanel emptyPanel = new JPanel();
      emptyPanel.setBackground(Color.PINK);
      lowerPanel.add(locationsPanel, BorderLayout.WEST);
      lowerPanel.add(emptyPanel, BorderLayout.CENTER);
      lowerPanel.add(positionsPanel, BorderLayout.EAST);

      //FULL PANEL
      JPanel fullPanel = new JPanel(new BorderLayout());
      fullPanel.setBackground(Color.LIGHT_GRAY);
      fullPanel.add(upperPanel, BorderLayout.NORTH);
      fullPanel.add(lowerPanel, BorderLayout.CENTER);

       //create frame for the userProfile Page
       JFrame profilePage = new JFrame("Profile");
       profilePage.add(fullPanel);
       // make sure the page exits when the red x is pressed
       profilePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //set the dimmensions of the home page
       profilePage.setSize(800, 800);
       profilePage.setVisible(true);  



     }  
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userProfileView().setVisible(true);
            }
        });

    }
}