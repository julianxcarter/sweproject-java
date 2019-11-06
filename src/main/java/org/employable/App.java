package org.employable;

import java.util.ArrayList;
import java.util.List;

// import com.mongodb.ServerAddress;

import org.bson.Document;
import org.employable.Model.JobListingModel;
// import java.util.Arrays;
// import com.mongodb.Block;
// import java.lang.Object;
import org.employable.Model.RecruiterModel;

// import com.mongodb.client.MongoCursor;
// import static com.mongodb.client.model.Filters.*;
// import com.mongodb.client.result.DeleteResult;
// import static com.mongodb.client.model.Updates.*;
// import com.mongodb.client.result.UpdateResult;
// import java.util.ArrayList;
// import java.util.List;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("----------------- Recruiters -----------------");

        RecruiterModel model = new RecruiterModel("Google");
        model.setName("Julian Carter");
        model.setPassword("Password");
        model.setContactInfo("email.email@email.com");

        model.createRecruiter();

        System.out.println("----------------- Listings -----------------");

        List<JobListingModel> listings = new ArrayList<JobListingModel>();
        JobListingModel model2 = new JobListingModel("position", "link", "title", "bleh");
        listings = model2.getAllListings();

        for (JobListingModel x : listings){
           System.out.println("Company Name: " + x.companyName);
           System.out.println("Link: " + x.hyperLink);
           System.out.println("Location: " + x.location);
           System.out.println("Position: " + x.positionName);
           
           System.out.println(" ");
        }
    
}
}
