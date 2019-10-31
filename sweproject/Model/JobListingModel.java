package Model; //JobListingModel is in the model package

//class definition of JobListing
public class JobListingModel {
  //job listing has position name
  String positionName;
  //job listing has associated company name
  String companyName;
  //job listing has hyper link to job posting on company's website
  String hyperLink;
  //job listing has location
  String location;
  
  public JobListingModel (String position, String company, String link, String location){
    this.positionName = position;
    this.companyName = company;
    this.hyperLink = link;
    this.location = location;
  }
}
