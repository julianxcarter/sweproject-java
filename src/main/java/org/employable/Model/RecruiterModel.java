package org.employable.Model;

import java.util.List;


public class Recruiter extends Profile {
  public String company;
  public List <JobListingModel> companyJobListings;

  public Recruiter (String company){
    this.company = company;
  }

  //method for adding job listing
  public void addJobListing(String position, String company, String link, String location){
    //make instance of job listing object
    JobListingModel newJob = new JobListingModel(position, company, link, location);
    // add this new job to the recruiter's job listing page
    companyJobListings.add(newJob);
  }

  //method for removing joblisting
  public void removeJobListing(JobListingModel expiredJob){
    int index = companyJobListings.indexOf(expiredJob);
    this.companyJobListings.remove(index);
  }
}
