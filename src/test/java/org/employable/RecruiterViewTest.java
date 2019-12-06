package org.employable;

import java.awt.*;
import javax.swing.*;

import org.junit.Test;
import org.employable.TestUtils;
import org.employable.View.RecruiterView;

import static org.junit.Assert.*;

/**
 * Unit test for RecruiterView.
 */
public class RecruiterViewTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testListingPanel() {
        // JTextField inputText;
        JButton addButton;

        // JPanel listingPanel;
        // JButton updateButton;

        RecruiterView view = new RecruiterView("TestCompany");
        // view.setVisible(true);

        addButton = (JButton)TestUtils.getChildNamed(view, "addButton");
        // addButton.doClick();


        // listingPanel = (JPanel)TestUtils.getChildNamed(view, "newListing");
        
        // updateButton = (JButton)TestUtils.getChildNamed(listingPanel, "updateButton");
        // assertFalse(updateButton.isEnabled());


        // inputText = (JTextField)TestUtils.getChildNamed(view, "textBox");
    }
}
