// package org.employable.Controller;

// import org.junit.After;
// import org.junit.AfterClass;
// import org.junit.Before;
// import org.junit.BeforeClass;
// import org.junit.Test;

// import static org.junit.Assert.*;

// import org.employable.Model.JobSeekerModel;

// public class JobSeekerControllerTest {
//     JobSeekerController controller;

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
//         this.controller = new JobSeekerController();
 
//     }
//     //executes after each test. used to release resources allocated in previous method before next method executes
//     @After
//     public void closeTest(){
 
//     }

//     //Tests that the model was instantiated properly
//     @Test
//     public void testInstantiation(){
//         assertNotEquals(this.controller.model, null);
//     }

//     //Tests that the two set methods (setName() and setContactInfo()) work as expected
//     @Test
//     public void jobseekerSetMethods() {

//         this.controller.setContactInfo("julian.carter@morehouse.edu");
//         this.controller.setName("Julian Carter");

//         assertEquals(this.controller.model.email, "julian.carter@morehouse.edu");
//         assertEquals(this.controller.model.name, "Julian Carter");
//     }

//     //Tests that the three add methods (addAmmenity(), addLocation(), and addPosition()) work as expected
//     @Test
//     public void jobseekerAddMethods() throws Exception {

//         this.controller.addAmenity("Braille");
//         this.controller.addLocation("Washington D.C");
//         this.controller.addPosition("Software Engineer");

//         assertEquals(this.controller.model.desiredAmenities.get(this.controller.model.desiredAmenities.size() - 1), "Braille");
//         assertEquals(this.controller.model.desiredLocations.get(this.controller.model.desiredLocations.size() - 1), "Washington D.C");
//         assertEquals(this.controller.model.desiredRoles.get(this.controller.model.desiredRoles.size() - 1), "Software Engineer");
//     }

//     //Tests that the three remove methods (addAmmenity(), addLocation(), and addPosition()) work as expected
//     @Test
//     public void jobseekerRemoveMethods() throws Exception {

//         this.controller.addAmenity("Braille");
//         this.controller.addLocation("Washington D.C");
//         this.controller.addPosition("Software Engineer");

//         this.controller.removeAmenity("Braille");
//         this.controller.removeLocation("Washington D.C");
//         this.controller.removePosition("Software Engineer");

//         assertEquals(this.controller.model.desiredAmenities.size(), 0);
//         assertEquals(this.controller.model.desiredLocations.size(), 0);
//         assertEquals(this.controller.model.desiredRoles.size(), 0);

//     }

// }