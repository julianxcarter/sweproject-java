package Controller;
import Model.*;
import View.*;


public class RecruiterController {
  private Recruiter model;
  private RecruiterView view;
  private JobListing jlModel;

  public RecruiterController(Recruiter model, RecruiterView view){
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
    JobListing model = new JobListing (position, company, link, location);
  }

  //method to remove JobListing
  public void removeJobListing(JobListing expiredJob){
    expiredJob.removeJobListing(expiredJob);
  }
  //show new interaction/notificiation. Dev later.
}
