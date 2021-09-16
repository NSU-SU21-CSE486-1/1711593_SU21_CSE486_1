package com.fahemaSultana.uniclubz.dataModel;

import java.io.Serializable;

public class EventListModel implements Serializable {

    private int id;
    private String clubName;
    private String eventTitle;
    private String university;
    private String date;
    private String time;
    private String eventDetails;
    private String image;

    public EventListModel() {

    }

    public EventListModel(int id, String clubName, String eventTitle, String university, String date, String time, String eventDetails, String image) {
        this.id = id;
        this.clubName = clubName;
        this.eventTitle = eventTitle;
        this.university = university;
        this.date = date;
        this.time = time;
        this.eventDetails = eventDetails;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
