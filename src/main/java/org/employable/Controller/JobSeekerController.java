package org.employable.Controller;
import org.employable.Model.JobSeekerModel;
import java.util.List;
 
 
public class JobSeekerController {
 JobSeekerModel model;
 
 public JobSeekerController() {
   model = new JobSeekerModel();

   
  }
 
 public void setName(String name){model.setName(name);}
 
 public void setPassword(String password) {model.setPassword(password);}
 
 public void setContactInfo(String email){model.setContactInfo(email);}
 
 //the add amenities method to call the model add amenity
 public void addAmenity(String amenity){
   model.addAmenity(amenity);
  }
 
 //remove amenity by calling the method in model to remove amenity
 public void removeAmenity(String amenity){model.removeAmenity(amenity);}
 
 //add location by calling the method in model to add location
 public void addLocation(String location){model.addLocation(location);}
 
 //remove location by calling method in model to remove location
 public void removeLocation(String location){model.removeLocation(location);}
 
 //add position by calling method in model to add position
 public void addPosition(String position){model.addPosition(position);}
 
 //remove position by calling method in model to remove position
 public void removePosition(String position){model.removePosition(position);}

 //update the model
 public void updateModel() {
   model.createJobSeeker();
  }
 
 
 
}
 

