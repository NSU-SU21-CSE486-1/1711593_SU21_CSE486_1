package com.fahemaSultana.project02.profile.DataModel;

import java.io.Serializable;
import java.util.List;
@SuppressWarnings("serial")
public class UserList  {
    String Name , Id , Nid , Birthday , Blood , Email, University , Study_level , PhoneNum , Tag , department ;

    List<Universities> universityInfo ;

    List<PhoneNumbers> PhoneInfo ;

    List<PersonalInformation> personalInformations;

    public UserList(){


    }

    public List<PersonalInformation> getPersonalInformations() {
        return personalInformations;
    }

    public void setPersonalInformations(List<PersonalInformation> personalInformations) {
        this.personalInformations = personalInformations;
    }

    public UserList(List<Universities> universityInfo, List<PhoneNumbers> phoneInfo, List<PersonalInformation> personalInformations) {
        this.universityInfo = universityInfo;
        PhoneInfo = phoneInfo;
        this.personalInformations = personalInformations;
    }

    public UserList(String name, String id, String nid, String birthday, String blood, String email, String university, String study_level, String phoneNum, String tag, String department) {
        Name = name;
        Id = id;
        Nid = nid;
        Birthday = birthday;
        Blood = blood;
        Email = email;
        University = university;
        Study_level = study_level;
        PhoneNum = phoneNum;
        Tag = tag;
        this.department = department;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNid() {
        return Nid;
    }

    public void setNid(String nid) {
        Nid = nid;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getBlood() {
        return Blood;
    }

    public void setBlood(String blood) {
        Blood = blood;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public String getStudy_level() {
        return Study_level;
    }

    public void setStudy_level(String study_level) {
        Study_level = study_level;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        PhoneNum = phoneNum;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Universities> getUniversityInfo() {
        return universityInfo;
    }

    public void setUniversityInfo(List<Universities> universityInfo) {
        this.universityInfo = universityInfo;
    }

    public List<PhoneNumbers> getPhoneInfo() {
        return PhoneInfo;
    }

    public void setPhoneInfo(List<PhoneNumbers> phoneInfo) {
        PhoneInfo = phoneInfo;
    }
}
