package com.example.home_gym.Models;

import java.io.Serializable;

public class ContactModel implements Serializable {
    int id;
    String name;
    String qualification;
    String contactno;
    String time;


    public ContactModel(int id, String name, String qualification, String contactno, String time) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.contactno = contactno;
        this.time = time;
    }

    public ContactModel(String name, String qualification, String contactno, String time) {
        this.name = name;
        this.qualification = qualification;
        this.contactno = contactno;
        this.time = time;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getQualification(){
        return qualification;
    }

    public void setQualification(String qualification){
        this.qualification = qualification;
    }

    public String getContactNum(){
        return contactno;
    }
    public void setContactNum(String contactno){
        this.contactno = contactno;
    }
    public String getTime(){

        return time;
    }

    public void setTime(String time){
        this.time = time;

    }

}
