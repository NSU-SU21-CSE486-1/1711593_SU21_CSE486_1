package com.fahemaSultana.uniclubz.dataModel;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import java.util.List;

@Entity(tableName = "user_list_table", primaryKeys = "nid")
public class UserEntity {

    @ColumnInfo
    @NonNull
    String name, nid, birthdate, bloodGroup;

    @ColumnInfo
    @NonNull
    List<Universities> universities;

    @ColumnInfo
    @NonNull
    List<PhoneNumbers> phoneNumbers;

    private String userId;


    public UserEntity() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<Universities> getUniversities() {
        return universities;
    }

    public void setUniversities(List<Universities> universities) {
        this.universities = universities;
    }

    public List<PhoneNumbers> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumbers> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
