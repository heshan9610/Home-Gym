package com.example.home_gym.Models;

import java.io.Serializable;

public class LowerBodyModel implements Serializable {

    int id;
    String workoutDay;
    String procedure;
    String duration;
    String benefits;

    public LowerBodyModel(int id, String workoutDay, String procedure, String duration, String benefits) {
        this.id = id;
        this.workoutDay = workoutDay;
        this.procedure = procedure;
        this.duration = duration;
        this.benefits = benefits;
    }

    public LowerBodyModel(String workoutDay, String procedure, String duration, String benefits) {
        this.workoutDay = workoutDay;
        this.procedure = procedure;
        this.duration = duration;
        this.benefits = benefits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkoutDay() {
        return workoutDay;
    }

    public void setWorkoutDay(String workoutDay) {
        this.workoutDay = workoutDay;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
}
