package org.employable.Model; //JobListingModel is in the model package

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.bson.types.ObjectId;


 //class definition of JobListing
 public class JobListingModel {
   //job listing has position name
   public String positionName;
   //job listing has associated company name
   public String companyName;
   //job listing has hyper link to job posting on company's website
   public String hyperLink;
   //job listing has location
   public String location;

   //Id the job listing will have in the database
   String ObjectId;

   //unique connection string for our database
   MongoClientURI uri = new MongoClientURI("mongodb+srv://cboyd7:EmployAble@employable-wlgg9.gcp.mongodb.net/test?retryWrites=true&w=majority");

   //An instance of 
   MongoClient mongoClient;


   MongoDatabase database;

   public JobListingModel(String position, String company, String link, String location){
     this.positionName = position;
     this.companyName = company;
     this.hyperLink = link;
     this.location = location;
   }

   //Uploads a job Listing to the database
   public void createListing(String position, String company, String link, String location) {
    this.mongoClient = new MongoClient(this.uri);
    this.database = this.mongoClient.getDatabase("EmployAble");
    ObjectId id = new ObjectId();
    this.ObjectId = id.toString();

    MongoCollection<Document> collection = this.database.getCollection("Listings");
    Document doc = new Document("_id", id)
        .append("title", this.positionName)
        .append("company", this.companyName)
        .append("link", this.hyperLink)
        .append("location", this.location);
    collection.insertOne(doc);

    // mongoClient.close();
}

// Method to delete a listing from the database
public void deleteListing() {

  this.mongoClient = new MongoClient(this.uri);
  this.database = this.mongoClient.getDatabase("EmployAble");
  MongoCollection<Document> collection = this.database.getCollection("Listings");

  collection.deleteOne(Filters.eq("_id", this.ObjectId));

  // mongoClient.close();
}

  //method which returns all job listings in the database
  public List<JobListingModel> getAllListings() {

    this.mongoClient = new MongoClient(this.uri);
    this.database = this.mongoClient.getDatabase("EmployAble");
  
    MongoCollection<Document> collection = this.database.getCollection("Listings");
    FindIterable<Document> iterDoc = collection.find();
  
    List<JobListingModel> listings = new ArrayList<JobListingModel>();
  
    MongoCursor<Document> cursor = iterDoc.iterator(); 
  
    while (cursor.hasNext()) {
      Document temp = cursor.next();
      String title = temp.get("title").toString();
      String company = temp.get("company").toString();
      String hyperLink = temp.get("link").toString();
      String location = temp.get("location").toString();
  
      JobListingModel tempJob = new JobListingModel(title, company, hyperLink, location);
       listings.add(tempJob);
    }
  
    // mongoClient.close();
  
    return listings;
  }
  
 }