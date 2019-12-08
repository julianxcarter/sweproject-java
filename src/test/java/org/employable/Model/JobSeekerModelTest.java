// package org.employable.Model;

// import java.awt.*;
// import javax.swing.*;

// import org.junit.Test;
// import org.employable.Model.*;

// import org.junit.After;
// import org.junit.AfterClass;
// import org.junit.Before;
// import org.junit.BeforeClass;
// import org.junit.Test;

// import static org.junit.Assert.*;
// import static org.junit.Assert.assertThat;

// import java.util.ArrayList;
// import java.util.List;

// //create A test that will instantiate the JobSeekerModel object with valid (non-empty) strings; expected to succeed
// public class JobSeekerModelTest {
//   //instantiate testmodel
//   JobSeekerModel jobSeeker;

//   @BeforeClass
//   public static void testSetupClass(){

//   }
//   //executes after all the tests execute
//   @AfterClass
//   public static void tearDownAfterClass(){

//   }

//   //executes before each test. nice to conatin objects used by all classes
//   @Before
//   public void testSetup(){
//     this.jobSeeker = new JobSeekerModel();

//   }
//   //executes after each test. used to release resources allocated in previous method before next method executes
//   @After
//   public void closeTest(){

//   }

//   //create A test that will test add amenities method
//   @Test
//   public void jobSeekerAddAmenities() throws Exception {

//     //add job seeker amenities
//     this.jobSeeker.addAmenity("ramp");
//     this.jobSeeker.addAmenity("brail");

//     //create list of expected amenities
//     List<String> expected = new ArrayList<String>();

//     expected.add("ramp");
//     expected.add("brail");

//     //match actual on expected
//     assertEquals(jobSeeker.desiredAmenities, expected);
//   }

//   //create A test that will test remove position method
//   @Test
//   public void jobSeekerAddPositions(){
//     //add job seeker positions
//     jobSeeker.addPosition("SWE");
//     jobSeeker.addPosition("PM");
//     jobSeeker.addPosition("TPM");

//     jobSeeker.removePosition("PM");

//     //create list of expected positions
//     List<String> expected = new ArrayList<String>();
//     expected.add("SWE");
//     expected.add("TPM");

//     //match actual on expected
//     assertEquals(this.jobSeeker.desiredRoles, expected);
//     }

//   //create A test that will add locations method
//   @Test
//   public void jobSeekerAddLocations(){
//     //add job seeker locations
//     jobSeeker.addLocation("SEA");
//     jobSeeker.addLocation("NYC");
//     jobSeeker.addLocation("PHL");
//     jobSeeker.addLocation("SF");

//     jobSeeker.removeLocation("SF");

//     //create list of expected locations
//     List<String> expected = new ArrayList<String>();
//     expected.add("SEA");
//     expected.add("NYC");
//     expected.add("PHL");

//     //match actual on expected
//     assertEquals(jobSeeker.desiredLocations, expected);
//     }

//   }