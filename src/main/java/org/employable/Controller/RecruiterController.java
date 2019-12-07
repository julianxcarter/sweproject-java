package org.employable.Controller;

import java.util.List;

import org.employable.Model.JobListingModel;
import org.employable.Model.RecruiterModel;
import org.employable.View.RecruiterView;
 

public class RecruiterController {
<<<<<<< HEAD
  RecruiterModel model = new RecruiterModel("");
=======
  public RecruiterModel model;
  private RecruiterView view;
>>>>>>> a15bdf382c3d145151cb492b96db50cfcf2147f3
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

  public void createJobListing(String position, String company, String link, String location, List<String> amenities){
    this.model = new RecruiterModel(company);
    model.addJobListing(position, company, link, location, amenities);
    // return;
  }

  public void createJobListing(String position, String company, String link, String location){
    this.model = new RecruiterModel(company);
    model.addJobListing(position, company, link, location);
    // return;
  }


  //method to remove JobListing
  public void removeJobListing(JobListingModel expiredJob){
    expiredJob.deleteListing();
  }
  //show new interaction/notificiation. Dev later.
}
