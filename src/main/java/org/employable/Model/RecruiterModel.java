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
  public String company;
  public List <JobListingModel> companyJobListings;

  String ObjectId;

  MongoClientURI uri = new MongoClientURI("mongodb+srv://cboyd7:EmployAble@employable-wlgg9.gcp.mongodb.net/test?retryWrites=true&w=majority");
  MongoClient mongoClient;
  MongoDatabase database;

  public RecruiterModel(){ }

  public void setCompany(String company) {
    this.company = company;
  }

  //Uploads a recruiter to the database
  public void createRecruiter() {
    this.mongoClient = new MongoClient(this.uri);
    this.database = this.mongoClient.getDatabase("EmployAble");
    ObjectId id = new ObjectId();
    this.ObjectId = id.toString();

    MongoCollection<Document> collection = this.database.getCollection("Recruiters");
    Document doc = new Document("_id", id)
        .append("name", this.name)
        .append("password", this.password)
        .append("email", this.email)
        .append("company", this.company);
    collection.insertOne(doc);
  }

  //deletes a recruiter from the database
  public void deleteRecruiter(String name) {

    this.mongoClient = new MongoClient(this.uri);
    this.database = this.mongoClient.getDatabase("EmployAble");
    MongoCollection<Document> collection = this.database.getCollection("Recruiters");

    collection.deleteOne(Filters.eq("name", name));

    // mongoClient.close();
}

//queries the database for all recruiters
public List<RecruiterModel> getRecruiters() {
  this.mongoClient = new MongoClient(this.uri);
  this.database = this.mongoClient.getDatabase("EmployAble");

  MongoCollection<Document> collection = this.database.getCollection("Recruiters");
  FindIterable<Document> iterDoc = collection.find();

  List<RecruiterModel> recruiters = new ArrayList<RecruiterModel>();

  MongoCursor<Document> cursor = iterDoc.iterator(); 

  while (cursor.hasNext()) {
    Document temp = cursor.next();  
    String name = temp.get("name").toString();
    String email = temp.get("email").toString();
    String password = temp.get("password").toString();
    String company = temp.get("company").toString();

    RecruiterModel tempRecruiter = new RecruiterModel();
    tempRecruiter.setName(name);
    tempRecruiter.setContactInfo(email);
    tempRecruiter.setPassword(password);
    tempRecruiter.setCompany(company);

    recruiters.add(tempRecruiter);
  }

  // mongoClient.close();

  return recruiters;
}

  //method for adding job listing
  public void addJobListing(String position, String company, String link, String location){
    //make instance of job listing object

    //add this new job to the recruiter's job listing page

    JobListingModel newJob = new JobListingModel(position, company, link, location);
    //add new listing to the data base
    newJob.createListing(position, company, link, location);
    // add this new job to the recruiter's job listing page
    companyJobListings.add(newJob);
  }

  //method for removing joblisting
  public void removeJobListing(JobListingModel expiredJob){
    int index = companyJobListings.indexOf(expiredJob);
    this.companyJobListings.remove(index);
    expiredJob.deleteListing();
  }

//method which queries the database for a recruiters job listings
//stores the list of Job Listings in companyJobListings
public void getCompanyListings() {

  this.mongoClient = new MongoClient(this.uri);
  this.database = this.mongoClient.getDatabase("EmployAble");

  MongoCollection<Document> collection = this.database.getCollection("Listings");
  FindIterable<Document> iterDoc = collection.find(Filters.eq("company", this.company));

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

  this.companyJobListings = listings;
}

}
