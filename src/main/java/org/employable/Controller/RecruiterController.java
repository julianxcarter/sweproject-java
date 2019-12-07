package org.employable.Controller;

// import org.employable.Model.JobListingModel;
import org.employable.Model.RecruiterModel;
import org.employable.View.RecruiterView;
 

public class RecruiterController {
  RecruiterModel model = new RecruiterModel("");
  private RecruiterView view;
  // private JobListingModel jlModel;

  public RecruiterController(){
    
  }

  public void setName (String name){
    model.setName(name);
  }

  public void setPassword(String password){
    model.setPassword(password);
  }

  public void setContactInfo(String email){
    model.setContactInfo(email);
  }

  public void createJobListing(String position, String company, String link, String location){
    model = new RecruiterModel(company);
    model.addJobListing(position, company, link, location);
    // return;
  }

  public void addNotification() {
    view.addNotification();
  }

  //method to remove JobListing
  // public void removeJobListing(JobListingModel expiredJob){
  //   expiredJob.removeJobListing(expiredJob);
  // }
  //show new interaction/notificiation. Dev later.
}
