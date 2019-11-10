package org.employable.Model;

import java.awt.*;
import javax.swing.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.employable.Model.*;
import static org.junit.Assert.*;

import java.util.List;

 public class ProfileModelTest {
     ProfileModel jobSeeker;
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
     this.jobSeeker = new ProfileModel();

   }
   //executes after each test. used to release resources allocated in previous method before next method executes
   @After
   public void closeTest(){

   }

   //test set contact info
   @Test
   public void testSetContactInfo(){
     String email = "tvereen@scmail.spelman.edu";
     this.jobSeeker.setContactInfo(email);
     assertEquals(jobSeeker.email, email);
   }

   //test set password
   @Test
   public void testSetPassword(){
     String password = "fkbfekbib";
     jobSeeker.setPassword(password);
     assertEquals(jobSeeker.password, password);
   }

   //test set name
   @Test
   public void testSetName(){
     String name = "Lani";
     jobSeeker.setName(name);
     assertEquals(jobSeeker.name, name);
   }

   //test change email
   @Test
   public void testChangeEmail(){
     String email = "tvereen@scmail.spelman.edu";
     jobSeeker.setContactInfo(email);
     String newEmail = "cboyd7@scmail.spelman.edu";
     jobSeeker.changeEmail(newEmail);
     assertEquals(jobSeeker.email, newEmail);
   }

   //test change password
   @Test
   public void testChangePassword(){
     String password = "fkbfekbib";
     jobSeeker.setPassword(password);
     String newPassword = "fjvfvfvif";
     jobSeeker.changePassword(newPassword);
     assertEquals(jobSeeker.password, newPassword);
   }

   }