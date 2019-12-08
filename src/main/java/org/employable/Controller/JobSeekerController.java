package org.employable.Controller;

import org.employable.Model.JobSeekerModel;
import org.employable.Model.JobListingModel;

import java.util.ArrayList;
import java.util.List;
//doesn't org.employable.View.JobSeekerProfileView need to be imported for @Ariel to use?
 
 
public class JobSeekerController {
 public JobSeekerModel model;
 JobListingModel listing;
 
 public JobSeekerController() {
  // model = new JobSeekerModel();
   List<String> bleh = new ArrayList<String>();
   bleh.add("bleh");

   listing = new JobListingModel("bleh", "bleh", "bleh", "bleh", bleh);
  
  }
 
 public void setName(String name){model.setName(name);}
 
 public void setPassword(String password) {model.setPassword(password);}
 
 public void setContactInfo(String email){model.setContactInfo(email);}
 
 //the add amenities method to call the model add amenity
 public void addAmenity(String amenity) throws Exception {
   model.addAmenity(amenity);
  }
 
 //remove amenity by calling the method in model to remove amenity
 public void removeAmenity(String amenity){model.removeAmenity(amenity);}
 
 //add location by calling the method in model to add location
 public void addLocation(String location){model.addLocation(location);}
 
 //remove location by calling method in model to remove location
 public void removeLocation(String location){model.removeLocation(location);}
 
 //add position by calling method in model to add position
 public void addPosition(String position){model.addPosition(position);}
 
 //remove position by calling method in model to remove position
 public void removePosition(String position){model.removePosition(position);}

// update the number of times a job listing has been interacted with
 public void updateEngagements(JobListingModel listing) {
    if (listing.engagements == null) {
      listing.engagements = 1;
    }
    else {
      listing.engagements++;
    }

    listing.recentlyEngaged = true;
    
    listing.updateListing();

  }

  //create a job seeker
  public void createJobSeeker(List<String> desiredRoles, List<String> desiredLocations, List<String> amenities) {
    this.model = new JobSeekerModel(desiredRoles, desiredLocations, amenities);
    this.model.createJobSeeker();
  }

 //update the model
//  public void updateModel() {
//    this.model.createJobSeeker();
//   }

  public List<JobListingModel> searchCompanies(String company) {
    List<JobListingModel> listings = listing.getListingsByCompany(company);

    return listings;
    
  }

  public List<JobListingModel> searchTitles(String position) {
    List<JobListingModel> listings = listing.getListingsByPosition(position);

    return listings;

  }

  public List<JobListingModel> searchLocation(String city) {
    List<JobListingModel> listings = listing.getListingsByLocation(city);

    return listings;

  }

  //method to return the matching results to the job seeker home view
  public List<JobListingModel> newMatch() {
    //top location
    String topLocation = model.getTopLocation();
    //top Role
    String topRole = model.getTopRole();
    //call method in jobListing Model sending it amenitites, locations, and roles of the jobseeker
    List<JobListingModel> matched = listing.match(model.getAmenities(), topLocation, topRole);
    //return matched list
    return matched;
  }
 
 
 
}
