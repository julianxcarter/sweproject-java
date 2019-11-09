package org.employable.Model; //JobListingModel is in the model package

import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
// import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable; 
import com.mongodb.client.MongoCursor;
 
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
 
/**
 * The JobSeeker class is for the user who is on the employee side
 */
 
public class JobSeekerModel extends ProfileModel {
  public List<String> desiredRoles = new ArrayList<String>();
  public List<String> desiredAmenities = new ArrayList<String>();
  public List<String> desiredLocations = new ArrayList<String>();
 
  MongoClientURI uri = new MongoClientURI("mongodb+srv://cboyd7:EmployAble@employable-wlgg9.gcp.mongodb.net/test?retryWrites=true&w=majority");
  MongoClient mongoClient;
  MongoDatabase database;
 
  // constructor declaration
  public JobSeekerModel()
  {
    // this.desiredRoles = roles;
    // this.desiredAmenities = amenities;
    // this.desiredLocations = locations;
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
    System.out.println("this is the ammenity from the model" + this.desiredAmenities);
  }
 
  //method to remove amenity
  public void removeAmenity(String amenity) {
    this.desiredAmenities.remove(amenity);
  }
 
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
    // BasicDBObject desiredRoles = new BasicDBObject();
 
    MongoCollection<Document> collection = this.database.getCollection("JobSeekers");
    Document doc = new Document("_id", id)
        .append("name", "cameron")
        // .append("password", this.password)
        // .append("email", this.email)
        .append("roles", this.desiredRoles)
        .append("amenities", this.desiredAmenities)
        .append("locations", this.desiredLocations);
    collection.insertOne(doc);

    System.out.println("This is the document going to the database: " + doc);
    System.out.println("These are the locations that the document should have: " + this.desiredLocations);
  }
 
  public void updateJobSeeker() {
    this.mongoClient = new MongoClient(this.uri);
    this.database = this.mongoClient.getDatabase("EmployAble");
 
    MongoCollection<Document> collection = this.database.getCollection("JobSeekers");
    ObjectId id = new ObjectId();
    this.ObjectId = id.toString();
 
    Document doc = new Document("_id", id)
        .append("name", "cameron")
        // .append("password", password)
        // .append("email", email)
        .append("roles", desiredRoles)
        .append("amenities", desiredAmenities)
        .append("locations", desiredLocations);
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
 


