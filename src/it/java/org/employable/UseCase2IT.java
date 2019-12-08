// package org.employable;

// import org.employable.Controller.*;
// import org.employable.Model.JobListingModel;
// import org.junit.Test;

// import org.junit.After;
// import org.junit.AfterClass;
// import org.junit.Before;
// import org.junit.BeforeClass;

// import static org.junit.Assert.*;

// import java.beans.Transient;
// import java.util.ArrayList;
// import java.util.List;

// //create an integration test that will test the second use case
// public class UseCase2IT {
//     JobSeekerController jobSeekerController; 

//     @BeforeClass
//   public static void testSetupClass(){

//   }
//   //executes after all the tests execute
//   @AfterClass
//   public static void tearDownAfterClass(){
//   }

//   //executes before each test. nice to conatin objects used by all classes
//   @Before
//   public void testSetup(){
//     this.jobSeekerController = new JobSeekerController();
//   }

//   //executes after each test. used to release resources allocated in previous method before next method executes
//   @After
//   public void closeTest(){
//   }

//   //Integration test starts here
//   @Test
//   public void testLocationSearch(){
//       String location = "Mountain View";
//       List<JobListingModel> returnedListingsOfLocation = jobSeekerController.searchLocation(location);
//       Boolean isLocation;
//       for(JobListingModel job: returnedListingsOfLocation){
//           if (job.location == "Mountain View"){
//               isLocation = true;
//           }
//       }
//       //Assert that the returned job listings have the company "Google" associated with it
//       assertEquals(isLocation, true);
//   }

//   //Integration test starts here
//   @Test
//   public void testTitleSearch(){
//       String title = "SWE";
//       List<JobListingModel> returnedListingsOfTitle = jobSeekerController.searchTitles(title);
//       Boolean isTitle;
//       for(JobListingModel job: returnedListingsOfTitle){
//           if (job.positionName == "SWE"){
//               isTitle = true;
//           }
//       }
//       //Assert that the returned job listings have the company "Google" associated with it
//       assertEquals(isTitle, true);
//   }


// }
