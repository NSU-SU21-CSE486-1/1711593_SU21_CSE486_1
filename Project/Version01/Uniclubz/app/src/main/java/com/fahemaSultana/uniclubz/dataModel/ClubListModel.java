package com.fahemaSultana.uniclubz.dataModel;

import java.io.Serializable;

public class ClubListModel implements Serializable {

    private int id;
    private String title;
    private String image;
    private String university;
    private String location;

    public ClubListModel(int id, String title, String image, String university, String location) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.university = university;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
