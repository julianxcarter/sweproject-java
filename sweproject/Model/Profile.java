package Model;

public class Profile {

  public String email;
  public String name;
  protected String password;

  public Profile(){}

  //change email method
  public void changeEmail(String newEmail){
    this.email = newEmail;
  }

  //change password
  public void changePassword(String newPassword){
    this.password = newPassword;
  }

  //method to set name
  public void setName(String name){this.name = name;}

  //method to set contact info
  public void setContactInfo(String email){this.email = email;}

  //method to set password
  public void setPassword(String password){this.password = password;}
}
