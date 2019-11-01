package org.employable;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.FindIterable; 

import org.bson.Document;

public class mongo {
    MongoClientURI uri = new MongoClientURI("mongodb+srv://cboyd7:EmployAble@employable-wlgg9.gcp.mongodb.net/test?retryWrites=true&w=majority");
    MongoClient mongoClient;
    MongoDatabase database;

    public void addUser(String name, boolean contact, String password, String email) {
        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");
        MongoCollection<Document> collection = this.database.getCollection("Employees");
        Document doc = new Document("name", name)
            .append("contact", contact)
            .append("password", password)
            .append("email", email);
        collection.insertOne(doc);

        // mongoClient.close();
    }

    public List<Document> getUsers() {
        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");

        MongoCollection<Document> collection = this.database.getCollection("Employees");
        FindIterable<Document> iterDoc = collection.find();

        List<Document> employees = new ArrayList<Document>();

        MongoCursor<Document> cursor = iterDoc.iterator(); 
      
        while (cursor.hasNext()) {  
           employees.add(cursor.next());
        }

        // mongoClient.close();

        return employees;
    }


    public Document updateUser(String name, boolean contact, String password, String email) {
        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");
        MongoCollection<Document> collection = this.database.getCollection("Employees");

        Document doc = new Document("name", name)
        .append("contact", contact)
        .append("password", password)
        .append("email", email);

        collection.replaceOne(Filters.eq("name", name), doc);

        mongoClient.close();

        return doc;

    }

    public void deleteUser(String email) {

        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");
        MongoCollection<Document> collection = this.database.getCollection("Employees");

        collection.deleteOne(Filters.eq("email", email));

        // mongoClient.close();
    }

    public void addRecruiter(String name, boolean contact, String password, String email, String company) {

        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");
        MongoCollection<Document> collection = this.database.getCollection("Recruiters");
        Document doc = new Document("name", name)
            .append("contact", contact)
            .append("password", password)
            .append("email", email)
            .append("company", company);
        collection.insertOne(doc);

        // mongoClient.close();
    }

    public List<Document> getRecruiters() {
        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");

        MongoCollection<Document> collection = this.database.getCollection("Recruiters");
        FindIterable<Document> iterDoc = collection.find();

        List<Document> recruiters = new ArrayList<Document>();

        MongoCursor<Document> cursor = iterDoc.iterator(); 
      
        while (cursor.hasNext()) {  
           recruiters.add(cursor.next());
        }

        // mongoClient.close();

        return recruiters;
    }

    public Document updateRecruiter(String name, boolean contact, String password, String email, String company) {
        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");
        MongoCollection<Document> collection = this.database.getCollection("Recruiters");

        Document doc = new Document("name", name)
        .append("contact", contact)
        .append("password", password)
        .append("email", email)
        .append("company", company);

        collection.replaceOne(Filters.eq("name", name), doc);

        // mongoClient.close();

        return doc;

    }

    public void deleteRecruiter(String email) {

        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");
        MongoCollection<Document> collection = this.database.getCollection("Recruiters");

        collection.deleteOne(Filters.eq("email", email));

        // mongoClient.close();
    }
    
    public void addListing(String title, String company, String link, String location) {

        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");

        MongoCollection<Document> collection = this.database.getCollection("Listings");
        Document doc = new Document("title", title)
            .append("company", company)
            .append("link", link)
            .append("location", location);
        collection.insertOne(doc);

        // mongoClient.close();
    }

    public List<Document> getListings() {

        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");

        MongoCollection<Document> collection = this.database.getCollection("Listings");
        FindIterable<Document> iterDoc = collection.find();

        List<Document> listings = new ArrayList<Document>();

        MongoCursor<Document> cursor = iterDoc.iterator(); 
      
        while (cursor.hasNext()) {  
           listings.add(cursor.next());
        }

        // mongoClient.close();

        return listings;
    }

    public List<Document> getListings(String company) {

        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");

        MongoCollection<Document> collection = this.database.getCollection("Listings");
        FindIterable<Document> iterDoc = collection.find(Filters.eq("company", company));

        List<Document> listings = new ArrayList<Document>();
        

        MongoCursor<Document> cursor = iterDoc.iterator(); 
      
        while (cursor.hasNext()) {  
           listings.add(cursor.next());
        }


        // mongoClient.close();

        return listings;
    }

    public List<Document> getListings(String company, String location) {

        this.mongoClient = new MongoClient(this.uri);
        this.database = this.mongoClient.getDatabase("EmployAble");

        MongoCollection<Document> collection = this.database.getCollection("Listings");
        FindIterable<Document> bycompany = collection.find(Filters.eq("company", company));

        FindIterable<Document> bylocation = bycompany.filter(Filters.eq("location", location));

        MongoCursor<Document> cursor = bylocation.iterator(); 
      
        List<Document> listings = new ArrayList<Document>();

        while (cursor.hasNext()) {  
           listings.add(cursor.next());
        }


        // mongoClient.close();

        return listings;
    }

}

    
    
