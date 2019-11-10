package org.employable;

import java.awt.*;
import javax.swing.*;

import org.junit.Test;
import org.employable.TestUtils;
import org.employable.Model.*;

import static org.junit.Assert.*;

import java.util.List;


//instantiate testmodel
//JobSeeker jobSeeker = new Jobseeker()

//create A test that will instantiate the JobSeekerModel object with valid (non-empty) strings; expected to succeed
public class JobSeekerModelTest{
//This method executes once before all of the test methods
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
    JobSeeker jobSeeker = new JobSeeker();

  }
  //executes after each test. used to release resources allocated in previous method before next method executes
  @After
  public void closeTest(){

  }
  //create A test that will add locations method
  @Test
  public void jobSeekerAddLocations(){
    //add job seeker locations
    jobSeeker.addLocation("SEA");
    jobSeeker.addLocation("NYC");
    jobSeeker.addLocation("PHL");
    jobSeeker.addLocation("SF");

    //create list of expected locations
    public List<String> expected = new ArrayList<String>();
    expected.add("SEA");
    expected.add("NYC");
    expected.add("PHL");
    expected.add("SF");

    //match actual on expected
    assertThat(jobSeeker.desiredLocations, is(equalTo(expected)));
  }

  //create A test that will test add positions method
  @Test
  public void jobSeekerAddPositions(){
    //add job seeker positions
    jobSeeker.addPosition("SWE");
    jobSeeker.addPosition("PM");
    jobSeeker.addPosition("TPM");

    //create list of expected positions
    public List<String> expected = new ArrayList<String>();
    expected.add("SWE");
    expected.add("PM");
    expected.add("TPM");

    //match actual on expected
    assertThat(jobSeeker.desiredPositions, is(equalTo(expected)));
  }

  //create A test that will test add amenities method
  @Test
  public void jobSeekerAddAmenities(){
    //add job seeker amenities
    jobSeeker.addAmenity("ramp");
    jobSeeker.addAmenity("brail");

    //create list of expected amenities
    public List<String> expected=new ArrayList<String>();
    expected.add("ramp");
    expected.add("brail");

    //match actual on expected
    assertThat(jobSeeker.desiredAmenities,is(equalTo(expected)));
  }

//create A test that will test remove amenity method
@Test
  public void jobSeekerAddAmenities(){
    //add job seeker amenities
    jobSeeker.addAmenity("ramp");
    jobSeeker.addAmenity("brail");

    jobSeeker.removeAmenity("brail");

    //create list of expected amenities
    public List<String> expected=new ArrayList<String>();
    expected.add("ramp");

    //match actual on expected
    assertThat(jobSeeker.desiredAmenities,is(equalTo(expected)));
    }

  //create A test that will test remove position method
  @Test
  public void jobSeekerAddPositions(){
    //add job seeker positions
    jobSeeker.addPosition("SWE");
    jobSeeker.addPosition("PM");
    jobSeeker.addPosition("TPM");

    jobSeeker.removePosition("PM");

    //create list of expected positions
    public List<String> expected = new ArrayList<String>();
    expected.add("SWE");
    expected.add("TPM");

    //match actual on expected
    assertThat(jobSeeker.desiredPositions, is(equalTo(expected)));
    }

  //create A test that will add locations method
  @Test
  public void jobSeekerAddLocations(){
    //add job seeker locations
    jobSeeker.addLocation("SEA");
    jobSeeker.addLocation("NYC");
    jobSeeker.addLocation("PHL");
    jobSeeker.addLocation("SF");

    jobSeeker.removeLocation("SF");

    //create list of expected locations
    public List<String> expected = new ArrayList<String>();
    expected.add("SEA");
    expected.add("NYC");
    expected.add("PHL");

    //match actual on expected
    assertThat(jobSeeker.desiredLocations, is(equalTo(expected)));
    }

  }
