package org.employable.Controller;

import org.employable.Controller.RecruiterController;
import org.employable.Model.RecruiterModel;
import org.employable.Model.ProfileModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecruiterControllerTest {
    RecruiterController controller;

    @BeforeClass
    public static void testSetupClass(){
 
    }
    //executes after all the tests execute
    @AfterClass
    public static void tearDownAfterClass(){
 
    }
 
    //executes before each test. nice to conatin objects used by all classes
    @Before
    public void testSetup(){
 
        this.controller = new RecruiterController();
        this.controller.model = new RecruiterModel("Google");
    }
    //executes after each test. used to release resources allocated in previous method before next method executes
    @After
    public void closeTest(){
 
    }
    
    // Tests that the two set methods (setName() and setContactInfo()) work as expected
    @Test
    public void recruiterSetMethods() {
        this.controller.setName("Julian Carter");
        this.controller.setContactInfo("julian.carter@morehouse.edu");

        assertEquals(this.controller.model.name, "Julian Carter");
        assertEquals(this.controller.model.email, "julian.carter@morehouse.edu");

    }

}