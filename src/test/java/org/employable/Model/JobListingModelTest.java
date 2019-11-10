package org.employable.Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class JobListingModelTest {
    JobListingModel model;


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
      this.model = new JobListingModel("Staff Software Engineer", "Facebook", "facebook.com", "Menlo Park");
 
    }
    //executes after each test. used to release resources allocated in previous method before next method executes
    @After
    public void closeTest(){
 
    }

    @Test
    public void testInstantiation() {
    
        assertEquals(this.model.positionName, "Staff Software Engineer");
        assertEquals(this.model.companyName, "Facebook");
        assertEquals(this.model.hyperLink, "facebook.com");
        assertEquals(this.model.location, "Menlo Park");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyInstantiation() throws Exception {

            JobListingModel model2 = new JobListingModel();
    }

    @Test
    public void joblistingCreateListing() {

        this.model.createListing(model.positionName, model.companyName, model.hyperLink, model.location);


        List<JobListingModel> listings = new ArrayList<JobListingModel>();

        listings = this.model.getAllListings();


        assertEquals(listings.get(listings.size()-1).positionName, this.model.positionName);
        assertEquals(listings.get(listings.size()-1).hyperLink, this.model.hyperLink);
        assertEquals(listings.get(listings.size()-1).location, this.model.location);
        assertEquals(listings.get(listings.size()-1).companyName, this.model.companyName);
                        

    }

    @Test
    public void joblistingDeleteListing() {
        this.model.deleteListing();

        List<JobListingModel> listings = new ArrayList<JobListingModel>();

        listings = this.model.getAllListings();

        assertFalse(listings.contains(this.model));
    }





}