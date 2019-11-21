<<<<<<< HEAD
package main.java.org.employable.View;
 
=======
package org.employable.View;

>>>>>>> abf3495ff525813495f41b6a81f122a990c9e2ce
import org.employable.Controller.JobSeekerController;

// import jdk.jfr.events.ActiveRecordingEvent;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class JobSeekerProfileView extends javax.swing.JFrame {

    /**
    *
    */
<<<<<<< HEAD
   private static final long serialVersionUID = 1L;
   // List of Amenities
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
   public static ArrayList<Checkbox> checkboxes;
    
=======
    private static final long serialVersionUID = 1L;
    // List of Amenities
    public static String[] amenities = { "Brail", "Ramps", "Elevators", "Accessible toilet facilities",
            "Audio-visual fire alarms", "Lowered lights switches and door handles", "Specially modified equipment",
            "Wheelchair accessible", "Adjustable desks and tables", "Stair rail", "Service dog friendly" };
    // List of Locations
    public static String[] desiredLocations = { "New York", "Los Angeles", "San Francisco", "Atlanta", "D.C",
            "New Jersey", "Seattle", "Houston", "Austin" };
    // List of Positions
    public static String[] desiredPositions = { "Software Engineer", "Accountant", "Data Analyst", "Consultant",
            "Account Manager", "Human Resources Personnel", "Receptionist", "Assistant", "Project Manager" };
    public static ArrayList<Checkbox> checkboxes;

>>>>>>> abf3495ff525813495f41b6a81f122a990c9e2ce
    final JobSeekerController controller = new JobSeekerController();

    public JobSeekerProfileView() throws Exception {

        // Layout source:
        // https://stackoverflow.com/questions/11790830/setting-jpanel-layout
        // source: https://www.javatpoint.com/java-awt-checkbox

        // *****************_AMENITIES_**********************
        // Amenities Panel will be centered in the upper panel
        JPanel amenitiesPanel = new JPanel();
        BoxLayout boxLayoutA = new BoxLayout(amenitiesPanel, BoxLayout.Y_AXIS);
        amenitiesPanel.setLayout(boxLayoutA);
        // Create a label for the amenities checkbox
        final Label amenitiesLabel = new Label();
        amenitiesLabel.setText(" Amenities");
        amenitiesPanel.add(amenitiesLabel, BorderLayout.CENTER);
        // Configure the checkbox
        for (int i = 0; i < amenities.length; i++) {
            Checkbox checkbox = new Checkbox(amenities[i]);
            amenitiesPanel.add(checkbox, BorderLayout.CENTER);
            int j = i;
            checkbox.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == 1) {
                        try {
                            controller.addAmenity(amenities[j].toString());
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        System.out.println("This is the amenity from the view: " + amenities[j]);
                    } else {
                        controller.removeAmenity(amenities[j].toString());
                    }
                }
            });
        }

        // ***************_SAVE-BUTTON_************************
        // Save button will be centered in the upper panel
        JPanel savePanel = new JPanel();
        // Create the save button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                save();
            }
        });
        savePanel.add(saveButton);

        // Add the save and amenities panel to the upper panel
        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.add(amenitiesPanel, BorderLayout.WEST);
        upperPanel.add(savePanel, BorderLayout.EAST);

        // *****************_LOCATIONS_**********************
        // locations panel will be in on the left side of the lowerPanel
        JPanel locationsPanel = new JPanel();
        JLabel locationsLabel = new JLabel("Preferred Locations:");

        // Configure the panel
        BoxLayout boxLayout = new BoxLayout(locationsPanel, BoxLayout.Y_AXIS);
        locationsPanel.setLayout(boxLayout);
        // place label at the top of the panel
        locationsPanel.add(locationsLabel, BorderLayout.NORTH);
        // add a button to add new locations
        JButton plusButton = new JButton("+");
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JPanel newLocationPanel = new JPanel();
                newLocationPanel.setLayout(new GridLayout(0, 3, 20, 20));
                JComboBox<String> userLocations = new JComboBox<>(desiredLocations);

                // add a remove button
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        controller.removeLocation(userLocations.getSelectedItem().toString());
                        newLocationPanel.getParent().remove(newLocationPanel);
                        locationsPanel.revalidate();
                        locationsPanel.repaint();
                    }

                });

                // add a save button
                JButton saveLocButton = new JButton("Save");
                saveLocButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        controller.addLocation(userLocations.getSelectedItem().toString());
                    }
                });

                newLocationPanel.add(userLocations);
                newLocationPanel.add(removeButton);
                newLocationPanel.add(saveLocButton);

                locationsPanel.add(newLocationPanel);
                locationsPanel.revalidate();
                locationsPanel.repaint();
            }
        });
        locationsPanel.add(plusButton);

        // *****************_POSITIONS_**********************
        // positions panel will be in on the right side of the lowerPanel
        JPanel positionsPanel = new JPanel();
        JLabel positionsLabel = new JLabel("Preferred Positions:");

        // Configure the panel
        BoxLayout boxLayoutP = new BoxLayout(positionsPanel, BoxLayout.Y_AXIS);
        positionsPanel.setLayout(boxLayoutP);
        // positionsPanel.setLayout(new BoxLayout(locationsPanel, BoxLayout.Y_AXIS));
        // place label at the top of the panel
        positionsPanel.add(positionsLabel, BorderLayout.NORTH);

        // add a button to add new locations
        JButton plusButtonP = new JButton("+");
        plusButtonP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                JPanel newPositionPanel = new JPanel();
                newPositionPanel.setLayout(new GridLayout(0, 2, 20, 20));
                JComboBox<String> userPositions = new JComboBox<>(desiredPositions);
                // add a remove button
                JButton removeButtonP = new JButton("Remove");
                removeButtonP.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        controller.removePosition(userPositions.getSelectedItem().toString());
                        newPositionPanel.getParent().remove(newPositionPanel);
                        positionsPanel.revalidate();
                        positionsPanel.repaint();
                    }
                });
                // add a save button
                JButton savePosButton = new JButton("Save");
                savePosButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        controller.addPosition(userPositions.getSelectedItem().toString());
                    }
                });

                newPositionPanel.add(userPositions);
                newPositionPanel.add(removeButtonP);
                newPositionPanel.add(savePosButton);

                positionsPanel.add(newPositionPanel);
                positionsPanel.revalidate();
                positionsPanel.repaint();
            }
        });
        positionsPanel.add(plusButtonP);

        // LOWER PANEL
        JPanel lowerPanel = new JPanel(new BorderLayout());
        JPanel emptyPanel = new JPanel();
        lowerPanel.add(locationsPanel, BorderLayout.WEST);
        lowerPanel.add(emptyPanel, BorderLayout.CENTER);
        lowerPanel.add(positionsPanel, BorderLayout.EAST);

        // FULL PANEL
        JPanel fullPanel = new JPanel(new BorderLayout());
        fullPanel.add(upperPanel, BorderLayout.NORTH);
        fullPanel.add(lowerPanel, BorderLayout.CENTER);

        // create frame for the userProfile Page
        JFrame profilePage = new JFrame("Profile");
        profilePage.add(fullPanel);
        // make sure the page exits when the red x is pressed
        profilePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the dimmensions of the home page
        profilePage.setSize(800, 800);
        profilePage.setVisible(true);

    }

    public void save() {
        controller.updateModel();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JobSeekerProfileView().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
           }
       });
 
   }
}

