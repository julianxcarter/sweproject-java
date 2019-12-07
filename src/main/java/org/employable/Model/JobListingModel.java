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

   //Instanciates a client to the mongoDB database
   MongoClient mongoClient;

  //Creates an instance of a mongoDb database
   MongoDatabase database;

  //Contructor for the JobListingModel
   public JobListingModel(String position, String company, String link, String location){
     this.positionName = position;
     this.companyName = company;
     this.hyperLink = link;
     this.location = location;
   }

   //Throws an IllegalArgumentException if the constructor is passed no arguments
   public JobListingModel() throws Exception {
      throw new IllegalArgumentException();
   }

   //Uploads a job Listing to the database
   public void createListing(String position, String company, String link, String location) {
    
    this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
    this.database = this.mongoClient.getDatabase("EmployAble"); // Pointing the mongo database to our EmployAble database

    //Creating a unique Id for the Job Listing to be inserted inti tge database 
    ObjectId id = new ObjectId();
    this.ObjectId = id.toString();

    

    MongoCollection<Document> collection = this.database.getCollection("Listings"); //Setting the collection to the approproate collection

    //Creating the document to be uploaded to the database
    Document doc = new Document("_id", id)
        .append("title", this.positionName)
        .append("company", this.companyName)
        .append("link", this.hyperLink)
        .append("location", this.location);

    collection.insertOne(doc); //Inserting the document to the database
    
    // mongoClient.close();
}

// Method to delete a listing from the database
public void deleteListing() {

  this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
  this.database = this.mongoClient.getDatabase("EmployAble"); // Pointing the mongo database to our EmployAble database

    MongoCollection<Document> collection = this.database.getCollection("Listings"); //Setting the collection to the approproate collection

  collection.deleteOne(Filters.eq("_id", this.ObjectId)); //Deletes the document in the database with the same unique id

  // mongoClient.close();
}

  //method which returns all job listings in the database
  public List<JobListingModel> getAllListings() {

    this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
    this.database = this.mongoClient.getDatabase("EmployAble"); // Pointing the mongo database to our EmployAble database
  
    MongoCollection<Document> collection = this.database.getCollection("Listings"); //Setting the collection to the approproate collection

    FindIterable<Document> iterDoc = collection.find(); //Retrieves all listings from the database and returns them as a list of documents
  
    List<JobListingModel> listings = new ArrayList<JobListingModel>(); 
  
    MongoCursor<Document> cursor = iterDoc.iterator(); 
  
    //Iterates through the list of documents and appends them to a list of Job Listing Models
    while (cursor.hasNext()) {
      Document temp = cursor.next();
      String title = temp.get("title").toString();
      String company = temp.get("company").toString();
      String hyperLink = temp.get("link").toString();
      String location = temp.get("location").toString();
      String id = temp.get("_id").toString();
  
      JobListingModel tempJob = new JobListingModel(title, company, hyperLink, location);
      tempJob.ObjectId = id;
       listings.add(tempJob);
    }
  
    // mongoClient.close();
  
    return listings;
  }

  public List<JobListingModel> getListingsByCompany(String companyName) {
      
    this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
    this.database = this.mongoClient.getDatabase("EmployAble"); // Pointing the mongo database to our EmployAble database
  
    MongoCollection<Document> collection = this.database.getCollection("Listings"); //Setting the collection to the approproate collection

    //Retrieves listings from the database with the desired company name and returns them as a list of documents
    FindIterable<Document> iterDoc = collection.find(Filters.eq("company", companyName)); 
  
    List<JobListingModel> listings = new ArrayList<JobListingModel>(); 
  
    MongoCursor<Document> cursor = iterDoc.iterator(); 
  
    //Iterates through the list of documents and appends them to a list of Job Listing Models
    while (cursor.hasNext()) {
      Document temp = cursor.next();
      String title = temp.get("title").toString();
      String company = temp.get("company").toString();
      String hyperLink = temp.get("link").toString();
      String location = temp.get("location").toString();
      String id = temp.get("_id").toString();
  
      JobListingModel tempJob = new JobListingModel(title, company, hyperLink, location);
      tempJob.ObjectId = id;
       listings.add(tempJob);
    }
  
    // mongoClient.close();
  
    return listings;
  }

  public List<JobListingModel> getListingsByPosition(String positionName) {
      
    this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
    this.database = this.mongoClient.getDatabase("EmployAble"); // Pointing the mongo database to our EmployAble database
  
    MongoCollection<Document> collection = this.database.getCollection("Listings"); //Setting the collection to the approproate collection

    //Retrieves listings from the database with the desired job title and returns them as a list of documents
    FindIterable<Document> iterDoc = collection.find(Filters.eq("title", positionName)); 
  
    List<JobListingModel> listings = new ArrayList<JobListingModel>(); 
  
    MongoCursor<Document> cursor = iterDoc.iterator(); 
  
    //Iterates through the list of documents and appends them to a list of Job Listing Models
    while (cursor.hasNext()) {
      Document temp = cursor.next();
      String title = temp.get("title").toString();
      String company = temp.get("company").toString();
      String hyperLink = temp.get("link").toString();
      String location = temp.get("location").toString();
      String id = temp.get("_id").toString();
  
      JobListingModel tempJob = new JobListingModel(title, company, hyperLink, location);
      tempJob.ObjectId = id;
       listings.add(tempJob);
    }
  
    // mongoClient.close();
  
    return listings;
  }

  public List<JobListingModel> getListingsByLocation(String locationName) {
      
    this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
    this.database = this.mongoClient.getDatabase("EmployAble"); // Pointing the mongo database to our EmployAble database
  
    MongoCollection<Document> collection = this.database.getCollection("Listings"); //Setting the collection to the approproate collection

    //Retrieves listings from the database with the desired location and returns them as a list of documents
    FindIterable<Document> iterDoc = collection.find(Filters.eq("location", locationName)); 
  
    List<JobListingModel> listings = new ArrayList<JobListingModel>(); 
  
    MongoCursor<Document> cursor = iterDoc.iterator(); 
  
    //Iterates through the list of documents and appends them to a list of Job Listing Models
    while (cursor.hasNext()) {
      Document temp = cursor.next();
      String title = temp.get("title").toString();
      String company = temp.get("company").toString();
      String hyperLink = temp.get("link").toString();
      String location = temp.get("location").toString();
      String id = temp.get("_id").toString();
  
      JobListingModel tempJob = new JobListingModel(title, company, hyperLink, location);
      tempJob.ObjectId = id;
       listings.add(tempJob);
    }
  
    // mongoClient.close();
  
    return listings;
  }

  public List<JobListingModel> match(String amenities, String locations, String roles)
  
 }
