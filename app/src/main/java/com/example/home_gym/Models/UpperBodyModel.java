package com.example.home_gym.Models;

import java.io.Serializable;

public class UpperBodyModel implements Serializable {

    int uppid;
    String upperworkoutDay;
    String upperprocedure;
    String upperbenefits;
    String upperduration;
    String uppertutoriallinks;

    public UpperBodyModel(int uppid, String upperworkoutDay, String upperprocedure, String upperbenefits, String upperduration, String uppertutoriallinks) {
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


    public int getuppid() {
        return uppid;
    }

    public void setuppid(int uppid) {
        this.uppid = uppid;
    }

    public String getupperworkoutDay() {
        return upperworkoutDay;
    }

    public void setupperworkoutDay(String upperworkoutDay) {
        this.upperworkoutDay = upperworkoutDay;
    }

    public String getupperprocedure() {
        return upperprocedure;
    }

    public void setupperprocedure(String upperprocedure) {
        this.upperprocedure = upperprocedure;
    }

    public String getupperbenefits() {
        return upperbenefits;
    }

    public void setupperbenefits(String upperbenefits) {
        this.upperbenefits = upperbenefits;
    }

    public String getupperduration() {
        return upperduration;
    }

    public void setupperduration(String upperduration) {
        this.upperduration = upperduration;
    }

    public String getuppertutoriallinks() {
        return uppertutoriallinks;
    }

    public void setuppertutoriallinks(String uppertutoriallinks) {
        this.uppertutoriallinks = uppertutoriallinks;
    }

}
