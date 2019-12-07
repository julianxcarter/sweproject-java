package org.employable;

import org.junit.Test;

import static org.junit.Assert.*;

import org.employable.Controller.JobSeekerController;
import org.employable.Model.JobListingModel;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class UseCase1IT {
    JobSeekerController controller;

        //executes before all the tests execute
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
            this.controller = new JobSeekerController();
        }
        //executes after each test. used to release resources allocated in previous method before next method executes
        @After
        public void closeTest(){
        }

        @Test
        public void UseCase1() throws Exception {
            this.controller.setName("Julian Carter");
            this.controller.setContactInfo("julian.carter@morehouse.edu");

            this.controller.addAmenity("Wheelchair ramps");
            this.controller.addAmenity("Elevators");
            this.controller.addAmenity("Braille");

            this.controller.addLocation("Atlanta");
            this.controller.addLocation("New York");
            
            this.controller.addPosition("Software Engineer");
            this.controller.addPosition("Project Manager");

            List<JobListingModel> matches = new ArrayList<JobListingModel>();
            matches = this.controller.newMatch();

            assertEquals(this.controller.model.name, "Julian Carter");
            assertEquals(this.controller.model.email, "julian.carter@morehouse.edu");

            assertEquals(this.controller.model.desiredAmenities.get(0), "Wheelchair ramps");
            assertEquals(this.controller.model.desiredAmenities.get(1), "Elevators");
            assertEquals(this.controller.model.desiredAmenities.get(2), "Braille");

            assertEquals(this.controller.model.desiredLocations.get(0), "Atlanta");
            assertEquals(this.controller.model.desiredLocations.get(1), "New York");

            assertEquals(this.controller.model.desiredRoles.get(0), "Software Engineer");
            assertEquals(this.controller.model.desiredRoles.get(1), "Project Manager");

            assertFalse(matches.isEmpty());

        }
}