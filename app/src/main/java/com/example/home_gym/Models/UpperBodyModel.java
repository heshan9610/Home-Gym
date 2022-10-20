package com.example.home_gym.Models;

import java.io.Serializable;

public class UpperBodyModel implements Serializable {

    int uppid;
    String upperworkoutDay;
    String upperprocedure;
    String upperbenefits;
    String upperduration;
    String uppertutoriallinks;

    public UpperBodyModel(int id, String upperworkoutDay, String upperprocedure, String upperbenefits, String upperduration, String uppertutoriallinks) {
        this.uppid = uppid;
        this.upperworkoutDay = upperworkoutDay;
        this.upperprocedure = upperprocedure;
        this.upperbenefits = upperbenefits;
        this.upperduration = upperduration;
        this.uppertutoriallinks = uppertutoriallinks;
    }

    public UpperBodyModel(String upperworkoutDay, String upperprocedure, String upperbenefits, String upperduration, String uppertutoriallinks) {
        this.upperworkoutDay = upperworkoutDay;
        this.upperprocedure = upperprocedure;
        this.upperbenefits = upperbenefits;
        this.upperduration = upperduration;
        this.uppertutoriallinks = uppertutoriallinks;
    }


//    public int getUppid() {
//        return uppid;
//    }
//
//    public void setUppid(int uppid) {
//        this.uppid = uppid;
//    }
//
//    public String getupperworkoutDay() {
//        return workoutDay;
//    }
//
//    public void setWorkoutDay(String workoutDay) {
//        this.workoutDay = workoutDay;
//    }
//
//    public String getupperprocedure() {
//        return procedure;
//    }
//
//    public void setProcedure(String procedure) {
//        this.procedure = procedure;
//    }
//
//    public String getDuration() {
//        return duration;
//    }
//
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }
//
//    public String getBenefits() {
//        return benefits;
//    }
//
//    public void setBenefits(String benefits) {
//        this.benefits = benefits;
//    }

}
