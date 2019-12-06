package org.employable.Model; //CampusModel is in the model package

public class CampusModel extends Company{
  String campusLocation;
  String [] mediaIds = new String[10];
  String[] amenities = new String [40];
  Integer campusRating;
  public CampusModel (String[] pictures, String[] amenities){
    this.mediaIds = pictures;
    this.amenities = amenities;
  }
}
