package com.example.home_gym.Models;

import java.io.Serializable;

public class DietModel implements Serializable {

    private int id;
    private String dName;
    private String dTime;
    private String dDescription;

    public DietModel(int id, String dName, String dTime, String dDescription) {
        this.id = id;
        this.dName = dName;
        this.dTime = dTime;
        this.dDescription = dDescription;
    }

    public DietModel(String dName, String dTime, String dDescription) {
        this.dName = dName;
        this.dTime = dTime;
        this.dDescription = dDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getdTime() {
        return dTime;
    }

    public void setdTime(String dTime) {
        this.dTime = dTime;
    }

    public String getdDescription() {
        return dDescription;
    }

    public void setdDescription(String dDescription) {
        this.dDescription = dDescription;
    }
}
