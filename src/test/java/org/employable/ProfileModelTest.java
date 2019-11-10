package org.employable;


import java.awt.*;
import javax.swing.*;

import org.junit.Test;
import org.employable.TestUtils;
import org.employable.Model.*;

import static org.junit.Assert.*;

import java.util.List;

public class ProfileModelTest{
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
    Profile jobSeeker = new Profile();

  }
  //executes after each test. used to release resources allocated in previous method before next method executes
  @After
  public void closeTest(){

  }

  //test set contact info
  @Test
  public void testSetContactInfo(){
    String email = "tvereen@scmail.spelman.edu";
    jobSeeker.setContactInfo(email);
    assertThat(jobSeeker.email, is(equalTo(email)));
  }

  //test set password
  @Test
  public void testSetPassword(){
    String password = "fkbfekbib";
    jobSeeker.setPassowrd(password);
    assetThat(jobSeeker.password, is(equalTo(password)));
  }

  //test set name
  @Test
  public void testSetName(){
    String name = "Lani";
    jobSeeker.setName(name);
    assertThat(jobSeeker.name, is(equalTo(name)));
  }

  //test change password
  public void testSetPassword(){
    String password = "fkbfekbib";
    jobSeeker.setPassowrd(password);
    assertThat(jobSeeker.password, is(equalTo(password)));


  }

  //test change email
  @Test
  public void testChangeEmail(){
    String email = "tvereen@scmail.spelman.edu";
    jobSeeker.setContactInfo(email);
    String newEmail = "cboyd7@scmail.spelman.edu";
    jobSeeker.changeEmail(newEmail);
    assertThat(jobSeeker.email, is(equalTo(newEmail)));
  }

  //test change password
  @Test
  public void testChangePassword(){
    String password = "fkbfekbib";
    jobSeeker.setPassowrd(password);
    String newPassword = "fjvfvfvif";
    jobSeeker.changePassword(newPassword);
    assertThat(jobSeeker.password, is(equalTo(newPassword)));
  }

  }
