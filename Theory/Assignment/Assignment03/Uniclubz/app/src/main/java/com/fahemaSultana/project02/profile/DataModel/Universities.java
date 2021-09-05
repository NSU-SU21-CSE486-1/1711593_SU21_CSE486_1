package com.fahemaSultana.project02.profile.DataModel;

public class Universities {

    String university, studyLevel, department;

    public Universities(){

    }

    public Universities(String university, String studyLevel, String department) {
        this.university = university;
        this.studyLevel = studyLevel;
        this.department = department;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(String studyLevel) {
        this.studyLevel = studyLevel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
