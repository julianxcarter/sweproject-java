package org.employable.Model; //CampusModel is in the model package
import java.util.List;

public class CampusModel extends CompanyModel{
  String campusLocation;
  String [] mediaIds = new String[10];
  String[] amenities = new String [40];
  public CampusModel (String[] pictures, String[] amenities){
    this.mediaIds = pictures;
    this.amenities = amenities;
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
