package com.fahemaSultana.uniclubz.dataModel;

import java.io.Serializable;

public class EventRegistrationMemberList implements Serializable {

    private int id;
    private String name;
    private String email;
    private String studentId;
    private String nid;
    private String university;
    private String level;
    private String department;
    private String phoneNumber;
    private String studentCategory;

    public EventRegistrationMemberList() {
    }

    public EventRegistrationMemberList(int id, String name, String email, String studentId, String nid, String university, String level, String department, String phoneNumber, String studentCategory) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.studentId = studentId;
        this.nid = nid;
        this.university = university;
        this.level = level;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.studentCategory = studentCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStudentCategory() {
        return studentCategory;
    }

    public void setStudentCategory(String studentCategory) {
        this.studentCategory = studentCategory;
    }
}
