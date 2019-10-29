package Model;
import java.util.List;


public class Recruiter extends Profile {
  public String company;
  public List <JobListing> companyJobListings;

  public Recruiter (String company){
    this.company = company;
  }

  //method for adding job listing
  public void addJobListing(String position, String company, String link, String location){
    //make instance of job listing object
    JobListing newJob = new JobListing(position, company, link, location);
    //add this new job to the recruiter's job listing page
    companyJobListings.add(newJob);
  }

  //method for removing joblisting
  public void removeJobListing(JobListing expiredJob){
    int index = companyJobListings.indexOf(expiredJob);
    this.companyJobListings.remove(index);
  }


}
