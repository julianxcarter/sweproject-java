package org.employable.Model; //JobListingModel is in the model package

import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.FindIterable; 
import com.mongodb.client.MongoCursor;

import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;

/**
 * The JobSeeker class is for the user who is on the employee side
 */

public class JobSeekerModel extends ProfileModel {
  public List<String> desiredRoles;
  public List<String> desiredAmenities;
  public List<String> desiredLocations;

  MongoClientURI uri = new MongoClientURI("mongodb+srv://cboyd7:EmployAble@employable-wlgg9.gcp.mongodb.net/test?retryWrites=true&w=majority");
  MongoClient mongoClient;
  MongoDatabase database;

  // constructor declaration
  public JobSeekerModel(List<String> roles, List<String> locations, List<String> amenities)
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

  public void createJobSeeker() {
    this.mongoClient = new MongoClient(this.uri);
    this.database = this.mongoClient.getDatabase("EmployAble");
    ObjectId id = new ObjectId();
    this.ObjectId = id.toString();

    MongoCollection<Document> collection = this.database.getCollection("JobSeekers");
    Document doc = new Document("_id", id)
        .append("name", this.name)
        .append("password", this.password)
        .append("email", this.email)
        .append("roles", this.desiredRoles)
        .append("amenities", this.desiredAmenities)
        .append("locations", this.desiredLocations);
    collection.insertOne(doc);
  }

  public void updateJobSeeker(JobSeekerModel model) {
    this.mongoClient = new MongoClient(this.uri);
    this.database = this.mongoClient.getDatabase("EmployAble");

    MongoCollection<Document> collection = this.database.getCollection("JobSeekers");
    ObjectId id = new ObjectId();
    this.ObjectId = id.toString();

    Document doc = new Document("_id", id)
        .append("name", model.name)
        .append("password", model.password)
        .append("email", model.email)
        .append("roles", model.desiredRoles)
        .append("amenities", model.desiredAmenities)
        .append("locations", model.desiredLocations);
    collection.replaceOne(Filters.eq("name", name), doc);
  }

  public void deleteJobSeeker(String name) {

    this.mongoClient = new MongoClient(this.uri);
    this.database = this.mongoClient.getDatabase("EmployAble");
    MongoCollection<Document> collection = this.database.getCollection("JobSeekers");

    collection.deleteOne(Filters.eq("name", name));

    // mongoClient.close();
}

}
