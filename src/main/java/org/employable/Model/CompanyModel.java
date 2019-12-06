package org.employable.Model; //JobListingModel is in the model package

public class CompanyModel {
  String companyName;
  String companyMediaId; //Representing mediaId for company Logo
  String companyPolicy; //could be text of company policy or representing the company's policy url
  String[] companyLocations = new String[50];

  public CompanyModel(){};
  public CompanyModel (String name, String mediaId, String policy, String [] locations)
  {
    this.companyName = name;
    this.companyMediaId = mediaId;
    this.companyPolicy = policy;
    this.companyLocations = locations;
  }
  }
