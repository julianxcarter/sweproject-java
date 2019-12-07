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

 //unique connection string for our database
  MongoClientURI uri = new MongoClientURI("mongodb+srv://cboyd7:EmployAble@employable-wlgg9.gcp.mongodb.net/test?retryWrites=true&w=majority"); //unique connection string for our database
  
  //Instanciates a client to the mongoDB database
  MongoClient mongoClient;

  //Creates an instance of a mongoDb database
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
  public void addAmenity(String amenity) throws Exception{
    boolean alreadyThere = false;

    //checks if the ammenity being added is already there
    for (String x : this.desiredAmenities) {
      if (x == amenity) {
        alreadyThere = true;
        throw new IllegalArgumentException();
      }
    }

    if (!alreadyThere) {
      this.desiredAmenities.add(amenity);
    }

  }

  //method to return amenities
  public List<String> getAmenities(){
    return desiredAmenities;
  }
 
  //method to remove amenity
  public void removeAmenity(String amenity) {
    this.desiredAmenities.remove(amenity);
  }
 
  //method to add location
  public void addLocation (String location){
    this.desiredLocations.add(location);
  }

  //method to return locations
  public List<String> getLocations() {
    return desiredLocations;
  }

  //method to return desired roles
  public List<String> getRoles() {
    return desiredRoles;
  }

  //method remove location
  public void removeLocation(String location){
    int index = this.desiredLocations.indexOf(location);
    this.desiredLocations.remove(index);
  }
 
  //Method to upload JobSeeker to the database
  public void createJobSeeker() {
    this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
    this.database = this.mongoClient.getDatabase("Employable"); // Pointing the mongo database to our EmployAble database

    //Create the unique id that the document will have in the database
    ObjectId id = new ObjectId();
    this.ObjectId = id.toString();

    MongoCollection<Document> collection = this.database.getCollection("JobSeekers"); //Setting the collection to the approproate collection

    //Creating the document to be uploaded to the database
    Document doc = new Document("_id", id)
        .append("name", "cameron")
        // .append("password", this.password)
        // .append("email", this.email)
        .append("roles", this.desiredRoles)
        .append("amenities", this.desiredAmenities)
        .append("locations", this.desiredLocations);

    collection.insertOne(doc); //Uploading the document to the database
  }
 
  public void updateJobSeeker() {
    this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
    this.database = this.mongoClient.getDatabase("Employable"); // Pointing the mongo database to our EmployAble database
 
    MongoCollection<Document> collection = this.database.getCollection("JobSeekers"); //Setting the collection to the approproate collection

    //Create the unique id that the document will have in the database
    ObjectId id = new ObjectId();
    this.ObjectId = id.toString();
 
    //Creating the document to be uploaded to the database
    Document doc = new Document("_id", id)
        .append("name", "cameron")
        // .append("password", password)
        // .append("email", email)
        .append("roles", desiredRoles)
        .append("amenities", desiredAmenities)
        .append("locations", desiredLocations);

    collection.replaceOne(Filters.eq("name", name), doc); // Replaces the document in the database with the same name
  }
 
  public void deleteJobSeeker(String name) {
 
    this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
    this.database = this.mongoClient.getDatabase("Employable"); // Pointing the mongo database to our EmployAble database

    MongoCollection<Document> collection = this.database.getCollection("JobSeekers"); //Setting the collection to the approproate collection
 
    collection.deleteOne(Filters.eq("name", name)); //Deletes the document in the database with the same name
 
    // mongoClient.close();
}
 

}
 


