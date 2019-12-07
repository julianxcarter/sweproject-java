package org.employable.Model; //JobListingModel is in the model package

import org.employable.Model.CampusModel;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.employable.Model.*;

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
   public List<String> amenities;

   CampusModel campusModel = new CampusModel();


   //Id the job listing will have in the database
   String ObjectId;

   //unique connection string for our database
   MongoClientURI uri = new MongoClientURI("mongodb+srv://cboyd7:EmployAble@employable-wlgg9.gcp.mongodb.net/test?retryWrites=true&w=majority");

   //Instanciates a client to the mongoDB database
   MongoClient mongoClient;

  //Creates an instance of a mongoDb database
   MongoDatabase database;

  //Contructor for the JobListingModel
   public JobListingModel(String position, String company, String link, String location, List<String> amenities) {
     this.positionName = position;
     this.companyName = company;
     this.hyperLink = link;
     this.location = location;
     this.amenities = amenities;
   }

   public JobListingModel(String position, String company, String link, String location) {
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
        .append("location", this.location)
        .append("ammenities", this.amenities);

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

  public List<JobListingModel> match(List<String> jobSeekerAmenities, String topLocation, String topRole){
    this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
    this.database = this.mongoClient.getDatabase("EmployAble"); // Pointing the mongo database to our EmployAble database

    MongoCollection<Document> collection = this.database.getCollection("Listings"); //Setting the collection to the approproate collection

    //get listings from the database with the desired locatoin and return them as a list of documents
    FindIterable<Document> iterDoc = collection.find(Filters.and(Filters.eq("location", topLocation), Filters.eq("title",
      topRole)));

    //create list to hold all of the listings returned from the query
    List<JobListingModel> listings = new ArrayList <JobListingModel>();

    MongoCursor<Document> cursor = iterDoc.iterator();

    //go through the documents list, converting the attributes to strings to instantiate new job listing then add to joblisting object list
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

      //create a list called matched to hold the job listing matched to the job seeker
      List<JobListingModel> matched = new ArrayList<JobListingModel>();


    for (JobListingModel job : listings) {
      int count = 0;
      List<String> tmpAmenitites = job.amenities;
      //see if all the amenities for the job listing are in the job seeker's amenities list
      for (String amenity: tmpAmenitites){
        if (jobSeekerAmenities.contains(amenity)) {
          count++;
        }
      }
      if (count == jobSeekerAmenities.size() || count == (jobSeekerAmenities.size()-1)){
        matched.add(job);
    }
    }

    //return the matched list
    return matched;
  }










//   public List<JobListingModel> sortJobListings (List<String> jobSeekerAmenities, List<JobListingModel> listings){
//      List<JobListingModel> topThreeMatch = new ArrayList <JobListingModel>();
//      this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
//      this.database = this.mongoClient.getDatabase("EmployAble"); // Pointing the mongo database to our EmployAble database
//
//      MongoCollection<Document> collection = this.database.getCollection("Campuses"); //Setting the collection to the approproate collection
//
//     //iterate over the listings list to find the campus associated with the job listing
//      for (JobListingModel job : listings) {
//        //set the company name
//        String company = job.companyName;
//
//        //location
//        String location = job.location;
//
//        //for this job listing, find it's campus in the database. should return 1 campus document
//        Document campusDocument = collection.find(Filters.and(Filters.eq("company", company), Filters.eq("location",
//          location)));
//
//        //get attributes to use for campus object instantiation
//        String [] pictures = campusDocument.get("pictures").toString();
//        String [] amenitites = campusDocument.get("amenities").toString();
//        String campusLocation = campusDocument.get("location").toString();
//        String company = campusDocument.get("company").toString();
//
//        //instantiate new campus object
//        CampusModel campus = new CampusModel(pictures, amenities, campusLocation, company);
//
//        //create a count for seeing how many amenities a listing has in common with job seeker amenities
//        //now go over the amenities in the new campus object
//        for (String amenity:campus.amenities) {
//          if (jobSeekerAmenities.contains(amenity)) {
//            count++;
//          }
//        }
//        if (topThreeMatch.size() == 0) {
//          topThreeMatch.add(job)
//        }
//        else{
//          if ()
//        }
//          }
//        }
//
//      }
//
//
//
//    }

// public CampusModel (String[] pictures, String[] amenities, String campusLocation, String company)

 }

