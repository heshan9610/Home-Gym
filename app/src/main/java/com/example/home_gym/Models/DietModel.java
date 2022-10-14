package com.example.home_gym.Models;

import java.io.Serializable;

public class DietModel implements Serializable {

    private int id;
    private String dMealOfDay;
    private String dDescription;
    private String dTime;
    private String dDate;
;

    public DietModel(int id, String dMealOfDay, String dDescription, String dDate, String dTime) {
        this.id = id;
        this.dMealOfDay =dMealOfDay;
        this.dDescription = dDescription;
        this.dTime = dTime;
        this.dDate = dDate;

    }

    public DietModel(String dMealOfDay, String dDescription, String dDate,  String dTime) {
        this.dMealOfDay= dMealOfDay;
        this.dDescription = dDescription;
        this.dTime = dTime;
        this.dDate = dDate;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getdMealOfDay() {
        return dMealOfDay;
    }

    public void setdMealOfDay(String dMealOfDay) {
        this.dMealOfDay = dMealOfDay;
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
