package org.employable.Model; //JobListingModel is in the model package

public class Company {
  String companyName;
  String companyMediaId; //Representing mediaId for company Logo
  Integer companyRating; //used to be CompanyRating
  String companyPolicy; //could be text of company policy or representing the company's policy url
  String[] companyLocations = new String[50];

  public Company(){};
  public Company (String name, String mediaId, String policy, String [] locations)
  {
    this.companyName = name;
    this.companyMediaId = mediaId;
    this.companyPolicy = policy;
    this.companyLocations = locations;
  }
  }
