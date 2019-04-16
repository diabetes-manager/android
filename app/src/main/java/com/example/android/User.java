package com.example.android;

import java.io.Serializable;

public class User implements Serializable {
    int id,glucoseHigh,glucoseLow, targetGlucoseHigh,targetGlucoseLow,userWeight,userHeight,carbInsulin;
    long birthDate;
    String name;

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name,int glucoseHigh, int glucoseLow, int taretGlucoseHigh, int targetGlucoseLow, int userWeight, int userHeight, int carbInsulin, long birthDate) {
        this.id = id;
        this.glucoseHigh = glucoseHigh;
        this.glucoseLow = glucoseLow;
        this.targetGlucoseHigh = taretGlucoseHigh;
        this.targetGlucoseLow = targetGlucoseLow;
        this.userWeight = userWeight;
        this.userHeight = userHeight;
        this.carbInsulin = carbInsulin;
        this.birthDate = birthDate;
        this.name = name;
    }
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGlucoseHigh() {
        return glucoseHigh;
    }

    public void setGlucoseHigh(int glucoseHigh) {
        this.glucoseHigh = glucoseHigh;
    }

    public int getGlucoseLow() {
        return glucoseLow;
    }

    public void setGlucoseLow(int glucoseLow) {
        this.glucoseLow = glucoseLow;
    }

    public int getTargetGlucoseHigh() {
        return targetGlucoseHigh;
    }

    public void setTargetGlucoseHigh(int targetGlucoseHigh) {
        this.targetGlucoseHigh = targetGlucoseHigh;
    }

    public int getTargetGlucoseLow() {
        return targetGlucoseLow;
    }

    public void setTargetGlucoseLow(int targetGlucoseLow) {
        this.targetGlucoseLow = targetGlucoseLow;
    }

    public int getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(int userWeight) {
        this.userWeight = userWeight;
    }

    public int getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(int userHeight) {
        this.userHeight = userHeight;
    }

    public int getCarbInsulin() {
        return carbInsulin;
    }

    public void setCarbInsulin(int carbInsulin) {
        this.carbInsulin = carbInsulin;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
