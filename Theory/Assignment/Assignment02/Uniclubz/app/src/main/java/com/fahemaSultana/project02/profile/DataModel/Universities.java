package com.fahemaSultana.project02.profile.DataModel;

public class Universities {

    String university , studylevel , department;

    public Universities(String university, String studylevel, String department) {
        this.university = university;
        this.studylevel = studylevel;
        this.department = department;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStudylevel() {
        return studylevel;
    }

    public void setStudylevel(String studylevel) {
        this.studylevel = studylevel;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
