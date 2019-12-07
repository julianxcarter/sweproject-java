package org.employable.Model; //CampusModel is in the model package

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;

public class CampusModel extends CompanyModel {
  String campusLocation;
  List<String> mediaIds = new ArrayList<String>();
  List<String> amenities = new ArrayList<String>();
  String company;

  //unique connection string for our database
  MongoClientURI uri = new MongoClientURI("mongodb+srv://cboyd7:EmployAble@employable-wlgg9.gcp.mongodb.net/test?retryWrites=true&w=majority");

  MongoClient mongoClient;
      
  MongoDatabase database;
  

  public CampusModel(String[] pictures, String[] amenities, String campusLocation, String company) {




    this.campusLocation = campusLocation;

    this.company = company;

    for (String picture : pictures) {
      this.mediaIds.add(picture);
    }

    for (String amenity : amenities) {
      this.amenities.add(amenity);
    }
  }

  public List<String> getAmenities() {

    return this.amenities;

  }

  public void addAmenity(String amenity){
    this.amenities.add(amenity);
  }

  public void addMedia(String media){
    this.mediaIds.add(media);
  }
}
