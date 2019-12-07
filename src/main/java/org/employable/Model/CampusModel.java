package org.employable.Model; //CampusModel is in the model package

import java.util.ArrayList;
import java.util.List;


public class CampusModel extends CompanyModel{
  String campusLocation;
  List<String> mediaIds = new ArrayList<String>();
  List<String> amenities = new ArrayList<String>();
  String company;

  public CampusModel (String[] pictures, String[] amenities, String campusLocation, String company) {

    this.campusLocation = campusLocation;

    this.company = company;

    for (String picture : pictures) {
      this.mediaIds.add(picture);
    }
    
    for (String amenity : amenities) {
      this.amenities.add(amenity);
    }
  }

  public List<String> getAmenities(){
    return this.amenities;
  }

  public void addAmenity(String amenity){
    this.amenities.add(amenity);
  }

  public void addMedia(String media){
    this.mediaIds.add(media);
  }
}
