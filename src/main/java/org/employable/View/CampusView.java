package org.employable.View;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;



public class CampusView extends javax.swing.JFrame {

    /**
    *
    */
    private static final long serialVersionUID = 1L;
    // List of Amenities
    public static String[] amenities = { "Brail", "Ramps", "Elevators", "Accessible toilet facilities",
            "Audio-visual fire alarms", "Lowered lights switches and door handles", "Specially modified equipment",
            "Wheelchair accessible", "Adjustable desks and tables", "Stair rail", "Service dog friendly" };

    ImageIcon image1;
    ImageIcon image2;
    ImageIcon image3;

    public CampusView() throws Exception {
        //Create the ContainerPanel
        JPanel containerPanel = new JPanel();

        //Create the panel for the top of the page
        JPanel topPanel = new JPanel(new GridLayout(1, 2));

        //Create the right panel for the top of the page
        JPanel rightTopPanel = new JPanel(new GridLayout(0, 1));
        
        //Create three new image icons
        image1 = new ImageIcon();
        image2 = new ImageIcon();
        image3 = new ImageIcon();

        



        //Create the left panel for the top of the page
        JPanel leftTopPanel = new JPanel();

        topPanel.add(rightTopPanel);
        topPanel.add(leftTopPanel);


        JPanel bottomPanel = new JPanel(new BorderLayout());

    }
}
