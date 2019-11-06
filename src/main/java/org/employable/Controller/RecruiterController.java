package org.employable.Controller;

import org.employable.Model.JobListingModel;
import org.employable.Model.RecruiterModel;
import org.employable.View.RecruiterView;



public class RecruiterController {
  private RecruiterModel model;
  private RecruiterView view;
  private JobListingModel jlModel;

  public RecruiterController(RecruiterModel model, RecruiterView view){
    this.model = model;
    this.view = view;
    //this.jlModel = jobListingModel;
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
    model.addJobListing(position, company, link, location);
  }

  //method to remove JobListing
  // public void removeJobListing(JobListingModel expiredJob){
  //   expiredJob.removeJobListing(expiredJob);
  // }
  //show new interaction/notificiation. Dev later.
}
