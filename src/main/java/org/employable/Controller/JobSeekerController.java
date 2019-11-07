package org.employable.Controller;
import org.employable.Model.*;
import org.employable.View.*;
import java.util.List;


public class JobSeekerController {
  JobSeekerModel model;
  JobSeekerProfileView view;

  public JobSeekerController() {
    this.model = model;
    this.view = view;
  }

  public void setName(String name){
    this.model.setName(name);
  }

  public void setPassword(String password){
    this.model.setPassword(password);
  }

  public void setContactInfo(String email){
    this.model.setContactInfo(email);
  }

  public void deleteJobSeeker(String name){
    this.model.deleteJobSeeker(name);
  }

  public void createJobSeeker() {
    this.model.createJobSeeker();
  }

  public void addAmmenity(String ammenity){
    model.desiredAmenities.add(ammenity);
    model.updateJobSeeker(model);
  }

  public void addDesiredRole(String role) {
    model.desiredRoles.add(role);
    model.updateJobSeeker(model);
  }

  public void addDesiredLocation(String location) {
    model.desiredLocations.add(location);
    model.updateJobSeeker(model);
  }

  public void removeAmmenity(String ammenity) {
    model.desiredAmenities.remove(new String(ammenity));
    model.updateJobSeeker(model);
  }

  public void removeDesiredRole(String role) {
    model.desiredRoles.remove(new String(role));
    model.updateJobSeeker(model);
  }

  public void removeDesiredLocation(String location) {
    model.desiredLocations.remove(new String(location));
    model.updateJobSeeker(model);
  }

  public void updateJobSeeker(JobSeekerModel model) {
    this.model.updateJobSeeker(model);
  }



  /**
   * the method called in here will be determined by the unwritten code in JobSeekerProfileView.java
   */
  // public void updateJobSeekerView() {
  //   view.printJobSeekerInfo(model);
  // }

  /**
   * the method called in here will be determined by the unwritten code in JobSeekerProfileView.java
   */
  // public void loadHomeView() {
  //   view.showHomePage(model);
  // }


}
