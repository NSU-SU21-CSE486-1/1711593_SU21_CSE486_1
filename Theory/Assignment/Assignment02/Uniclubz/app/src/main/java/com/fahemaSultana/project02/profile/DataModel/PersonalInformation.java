package com.fahemaSultana.project02.profile.DataModel;

public class PersonalInformation {

    private String Name;
    private  String NID ;

    public  PersonalInformation(){


    }

    public PersonalInformation(String name, String NID) {
        this.Name = name;
        this.NID = NID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }
}
