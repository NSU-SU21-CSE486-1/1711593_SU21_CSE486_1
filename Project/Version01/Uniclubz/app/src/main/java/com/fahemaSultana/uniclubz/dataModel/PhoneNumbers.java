package com.fahemaSultana.uniclubz.dataModel;

public class PhoneNumbers {
    private String Tag;
    private  String Phonenumber;

    public PhoneNumbers(){

    }

    public PhoneNumbers(String tag, String phonenumber) {
        Tag = tag;
        Phonenumber = phonenumber;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }
}
