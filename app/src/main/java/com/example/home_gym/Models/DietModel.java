package com.example.home_gym.Models;

import java.io.Serializable;

public class DietModel implements Serializable {

    private int id;
    private String dTime;
    private String dDate;
    private String dDescription;

    public DietModel(int id, String dTime, String dDate, String dDescription) {
        this.id = id;
        this.dTime = dTime;
        this.dDate = dDate;
        this.dDescription = dDescription;
    }

    public DietModel(String dTime, String dDate, String dDescription) {
        this.dTime = dTime;
        this.dDate = dDate;
        this.dDescription = dDescription;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdTime() {
        return dTime;
    }

    public void setdTime(String dTime) {
        this.dTime = dTime;
    }

    public String getdDate() {
        return dDate;
    }

    public void setdDate(String dDate) {
        this.dDate = dDate;
    }

    public String getdDescription() {
        return dDescription;
    }

    public void setdDescription(String dDescription) {
        this.dDescription = dDescription;
    }
}
