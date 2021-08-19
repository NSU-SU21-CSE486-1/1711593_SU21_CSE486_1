package com.fahemaSultana.project02.profile.DataModel;

public class PersonalInformation {

    private String Name;
    private  String ID ;

    public  PersonalInformation(){


    }

    public PersonalInformation(String name, String ID) {
        Name = name;
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
