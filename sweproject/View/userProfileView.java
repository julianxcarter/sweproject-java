package View;

//checkbox
import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;


public class userProfileView extends javax.swing.JFrame {

    public static String[] amenities = {"Brail", "Ramps", "Elevators", 
    "Accessible toilet facilities", "Audio-visual fire alarms", 
    "Lowered lights switches and door handles", 
    "Specially modified equipment", "Wheelchair accessible", 
    "Adjustable desks and tables", "Stair rail", 
    "Service dog friendly"};

    public userProfileView() {
        //create frame for the userProfile Page
        JFrame profilePage = new JFrame("Profile");
        // make sure the page exits when the red x is pressed
        profilePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set the dimmensions of the home page
        //profilePage.setSize(800,800);
        profilePage.setBounds(0, 0, 800, 800);
        profilePage.setLayout(null);  
        profilePage.setVisible(true);  

        //Create a label for the amenities checkbox
        final Label amenitiesLabel = new Label();          
        amenitiesLabel.setLocation(profilePage.getWidth()/2 - 50, 5);
        amenitiesLabel.setSize(400,100);
        amenitiesLabel.setText("Amenities");
        profilePage.add(amenitiesLabel);

        //Configure the textbox
        for (int i = 0; i < amenities.length; i++) {
            Checkbox checkbox = new Checkbox(amenities[i]);
            int y = 50 + i*32;
            checkbox.setBounds(amenitiesLabel.getX() - 150, y, 300, 50);
            profilePage.add(checkbox);
        }
        //Checkbox checkbox1 = new Checkbox("C++");  
        //checkbox1.setBounds(100,100, 50,50);  
        //Checkbox checkbox2 = new Checkbox("Java");  
        //checkbox2.setBounds(100,150, 50,50);  
        //profilePage.add(checkbox1); profilePage.add(checkbox2); profilePage.add(label);  
        /*
        checkbox1.addItemListener(new ItemListener() {  
             public void itemStateChanged(ItemEvent event) {               
                label.setText("C++ Checkbox: "   
                + (event.getStateChange()==1?"checked":"unchecked"));  
             }  
          });  
        checkbox2.addItemListener(new ItemListener() {  
             public void itemStateChanged(ItemEvent event) {               
                label.setText("Java Checkbox: "   
                + (event.getStateChange()==1?"checked":"unchecked"));  
             }  
          });  
          */

        
     }  
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userProfileView().setVisible(true);
            }
        });

    }
}