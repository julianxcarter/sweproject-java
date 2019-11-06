package org.employable.Model; //JobListingModel is in the model package

import java.util.List;

/**
 * The JobSeeker class is for the user who is on the employee side
 */

public class JobSeeker extends Profile {
  public List<String> desiredRoles;
  public List<String> desiredAmenities;
  public List<String> desiredLocations;

  //constructor declaration
  public JobSeeker(List<String> roles, List<String> locations, List<String> amenities)
  {
    this.desiredRoles = roles;
    this.desiredAmenities = amenities;
    this.desiredLocations = locations;
  }

  //method to add role
  public void addPosition (String role){
    this.desiredRoles.add(role);
  }

  //method to remove Role
  public void removePosition(String role){
    int index = this.desiredRoles.indexOf(role);
    this.desiredRoles.remove(index);
  }

  //method to add amenity
  public void addAmenity (String amenity){
    this.desiredAmenities.add(amenity);
  }

  //method to remove amenity
  public void removeAmenity(String amenity) {this.desiredAmenities.remove(amenity);}

  //method to add location
  public void addLocation (String location){
    this.desiredLocations.add(location);
  }

  //method remove location
  public void removeLocation(String location){
    int index = this.desiredLocations.indexOf(location);
    this.desiredLocations.remove(index);
  }
}
