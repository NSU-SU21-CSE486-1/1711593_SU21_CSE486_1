package com.fahemaSultana.uniclubz.dataModel;

import java.io.Serializable;

public class BloodRequestListModel implements Serializable {

    private int id;
    private String contactName;
    private String date;
    private String time;
    private String bloodGroup;
    private int bloodBag;
    private String hospitalName;
    private String hospitalLocation;
    private String phoneNumber;

    public BloodRequestListModel(int id, String patientName, String date, String time, String bloodGroup, int bloodBag, String hospitalName, String hospitalLocation, String phoneNumber) {
        this.id = id;
        this.contactName = patientName;
        this.date = date;
        this.time = time;
        this.bloodGroup = bloodGroup;
        this.bloodBag = bloodBag;
        this.hospitalName = hospitalName;
        this.hospitalLocation = hospitalLocation;
        this.phoneNumber = phoneNumber;
    }

    public BloodRequestListModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
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

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getBloodBag() {
        return bloodBag;
    }

    public void setBloodBag(int bloodBag) {
        this.bloodBag = bloodBag;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalLocation() {
        return hospitalLocation;
    }

    public void setHospitalLocation(String hospitalLocation) {
        this.hospitalLocation = hospitalLocation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
