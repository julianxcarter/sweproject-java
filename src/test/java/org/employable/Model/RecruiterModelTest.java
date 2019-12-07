package org.employable.Model;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class RecruiterModelTest {
    RecruiterModel model;
    
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
      this.model = new RecruiterModel("Facebook");
 
    }
    //executes after each test. used to release resources allocated in previous method before next method executes
    @After
    public void closeTest(){
    }

    //Tests that the model was instantiated properly
    @Test
    public void testInstantiation(){
        assertEquals(this.model.company, "Facebook");
    }

    //Tests that each profile editing method in the Profile class works as expected 
    @Test 
    public void profileAddMethods(){
        this.model.changeEmail("julian.carter@facebook.com");
        this.model.changePassword("Password");
        this.model.setName("Julian Carter");

        assertEquals(model.company, "Facebook");
        assertEquals(model.email, "julian.carter@facebook.com");
        assertEquals(model.name, "Julian Carter");
    }
    
    //Tests that that the createRecruiter method can upload a recruiter document to the database as expected
    @Test 
    public void recruiterCreateRecruiter() {
        this.model.createRecruiter();

        List<Document> expected = new ArrayList<Document>();

        expected = this.model.getRecruiters();

        assertEquals(expected.get(expected.size() - 1).get("name"), this.model.name);
        assertEquals(expected.get(expected.size() - 1).get("password"), this.model.password);
        assertEquals(expected.get(expected.size() - 1).get("email"), this.model.email);
        assertEquals(expected.get(expected.size() - 1).get("company"), this.model.company);
        assertEquals(expected.get(expected.size() - 1).get("_id").toString(), this.model.ObjectId);
        
    }

    //Tests that the deleteRecruiter deletes the desired class as expected
    @Test
    public void recruiterDeleteRecruiter() {

        this.model.deleteRecruiter();

        List<Document> expected = new ArrayList<Document>();

        this.model.getRecruiters();

        Document doc = new Document("_id", this.model.ObjectId)
        .append("name", this.model.name)
        .append("password", this.model.password)
        .append("email", this.model.email)
        .append("company", this.model.company);

        assertFalse(expected.contains(doc));

    }


    //Tests that the createJobListing method uploads a Job Listing to the database as expected
    @Test
    public void recruiterAddJobListing(){
        JobListingModel listing = new JobListingModel("Software Engineer", "Google", "google.com", "Los Angeles");

        this.model.addJobListing(listing.positionName, listing.companyName, listing.hyperLink, listing.location);


        List<JobListingModel> listings = new ArrayList<JobListingModel>();
        listings = listing.getAllListings();

        assertEquals(listings.get(listings.size()-1).positionName, listing.positionName);
        assertEquals(listings.get(listings.size()-1).hyperLink, listing.hyperLink);
        assertEquals(listings.get(listings.size()-1).location, listing.location);
        assertEquals(listings.get(listings.size()-1).companyName, listing.companyName);
    }
} 