package org.employable.Model;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;
import org.bson.types.ObjectId;


public class RecruiterModel extends ProfileModel {
  public String company; // The Company that the recruiter belongs to
  public List <JobListingModel> companyJobListings; // A list of Job Listings that the Recruiter owns

  String ObjectId; // Unique Id that the recruiter holds in the database

  //unique connection string for our database
  MongoClientURI uri = new MongoClientURI("mongodb+srv://cboyd7:EmployAble@employable-wlgg9.gcp.mongodb.net/test?retryWrites=true&w=majority");

  //Instanciates a client to the mongoDB database
  MongoClient mongoClient;

  //Creates an instance of a mongoDb database
  MongoDatabase database;

  // Contructor for the class, takes the recruiter's company as an argument
  public RecruiterModel(String company){
    this.company = company;
  }

  //Uploads a recruiter to the database
  public void createRecruiter() {
    this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
    this.database = this.mongoClient.getDatabase("EmployAble"); // Pointing the mongo database to our EmployAble database

    //Creating a unique Id for the Job Listing to be inserted into the database 
    ObjectId id = new ObjectId();
    this.ObjectId = id.toString();

    MongoCollection<Document> collection = this.database.getCollection("Recruiters"); //Setting the collection to the approproate collection

    //Creating the document to be uploaded to the database
    Document doc = new Document("_id", id)
        .append("name", this.name)
        .append("password", this.password)
        .append("email", this.email)
        .append("company", this.company);

    collection.insertOne(doc); //Inserting the document to the database
  }

  //deletes a recruiter from the database
  public void deleteRecruiter() {

    this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
    this.database = this.mongoClient.getDatabase("EmployAble"); // Pointing the mongo database to our EmployAble database
    MongoCollection<Document> collection = this.database.getCollection("Recruiters"); //Setting the collection to the approproate collection

    collection.deleteOne(Filters.eq("_id", this.ObjectId)); //Deletes the document in the database with the same unique id

    // mongoClient.close();
}

//queries the database for all recruiters
public List<Document> getRecruiters() {
  this.mongoClient = new MongoClient(this.uri); // Pointing the mongo client to our mongoDb cluster
  this.database = this.mongoClient.getDatabase("EmployAble"); // Pointing the mongo database to our EmployAble database

  MongoCollection<Document> collection = this.database.getCollection("Recruiters"); //Setting the collection to the approproate collection
  FindIterable<Document> iterDoc = collection.find(); //Retrieves all listings from the database and returns them as a list of documents
  

  List<Document> recruiters = new ArrayList<Document>();

  MongoCursor<Document> cursor = iterDoc.iterator(); 

  //Iterates through the list of documents and appends them to a list of Documents
  while (cursor.hasNext()) {  
     recruiters.add(cursor.next());
  }

  // mongoClient.close();

  return recruiters;
}

  //method for adding job listing
  public void addJobListing(String position, String company, String link, String location, List<String> amenities) {
    //make instance of job listing object

    //add this new job to the recruiter's job listing page
    JobListingModel newJob = new JobListingModel(position, company, link, location, amenities);

    //add new listing to the data base
    newJob.createListing(position, company, link, location);
    
    // add this new job to the recruiter's job listing page
    
  }

    //method for adding job listing
    public void addJobListing(String position, String company, String link, String location) {
      //make instance of job listing object
  
      //add this new job to the recruiter's job listing page
      JobListingModel newJob = new JobListingModel(position, company, link, location);
  
      //add new listing to the data base
      newJob.createListing(position, company, link, location);
      
      // add this new job to the recruiter's job listing page
      
    }

  //method for removing joblisting
  public void removeJobListing(JobListingModel expiredJob){
    int index = companyJobListings.indexOf(expiredJob);
    this.companyJobListings.remove(index);
  }

//method which queries the database for a recruiters job listings
//stores the list of Job Listings in companyJobListings
// public void getCompanyListings() {

//   this.mongoClient = new MongoClient(this.uri);
//   this.database = this.mongoClient.getDatabase("EmployAble");

//   MongoCollection<Document> collection = this.database.getCollection("Listings");
//   FindIterable<Document> iterDoc = collection.find(Filters.eq("company", this.company));

//   List<JobListingModel> listings = new ArrayList<JobListingModel>();

//   MongoCursor<Document> cursor = iterDoc.iterator(); 

//   while (cursor.hasNext()) {
//     Document temp = cursor.next();

//     String title = temp.get("title").toString();
//     String company = temp.get("company").toString();
//     String hyperLink = temp.get("link").toString();
//     String location = temp.get("location").toString();

//     // JobListingModel tempJob = new Job.JobListingModel(title, company, hyperLink, location);
//      listings.add(tempJob);
//   }

//   // mongoClient.close();

//   this.companyJobListings = listings;
// }



}
