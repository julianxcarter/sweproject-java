// package org.employable;

// import org.junit.Test;
// import org.employable.Controller.RecruiterController;
// import org.employable.Model.JobListingModel;
// import org.junit.After;
// import org.junit.AfterClass;
// import org.junit.Before;
// import org.junit.BeforeClass;

// import static org.junit.Assert.*;

// import java.beans.Transient;
// import java.util.ArrayList;
// import java.util.List;

// //create an integration test that will test the second use case
// public class UseCase3IT {
//     RecruiterController recruiterController;
//     @BeforeClass
//     public static void testSetupClass(){
  
//     }
//     //executes after all the tests execute
//     @AfterClass
//     public static void tearDownAfterClass(){
//     }
  
//     //executes before each test. nice to conatin objects used by all classes
//     @Before
//     public void testSetup(){
//       this.recruiterController = new RecruiterController();
//       List<JobListingModel> listings;
//       JobListingModel job = new JobListingModel("SWE", "Google", "www.Google.com", "Mountain View");
//       listings.add(job);
//       JobListingModel job2 = new JobListingModel("SWE", "Twitter", "www.Twitter.com", "SF");
//       listings.add(job2);
//       JobListingModel job3 = new JobListingModel("PM", "FB", "www.Facebook.com", "MPK");
//       listings.add(job3);
//     }

//     //executes after each test. used to release resources allocated in previous method before next method executes
//     @After
//     public void closeTest(){
//     }

//     //Integration test starts here
//     //Test for testing removing a job listing
//     @Test
//     public void testRemoveJobListing(){
//         //call the controller remove job listing method
//         this.recruiterController.removeJobListing(job);
//         //assert that the list of job listings does not have the recently removed job listing
//         assertThat (this.recruiterController.getAllJobs(), not(hasItem(job)));
//     }

//     //Test for testing adding a job listing
//     @Test
//     public void testAddJobListing(){
//         //call the controller add job listing method
//         this.recruiterController.createJobListing("SWE", "Seat Geek", "www.SeatGeek.com", "NYC");
//         JobListingModel job4 = new JobListingModel ("SWE", "Seat Geek", "www.SeatGeek.com", "NYC");
//         assertThat (this.recruiterController.getAllJobs(), hasItem(job4));
//     }
// }