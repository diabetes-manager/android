package com.example.android;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class User implements Serializable {
    public static final int DEFAULT_USER_HEIGHT = 65;
    public static final int DEFAULT_USER_WEIGHT = 168;

    int id,glucoseHigh,glucoseLow, targetGlucoseHigh,targetGlucoseLow,userWeight,userHeight,carbInsulin;
    long birthDate;
    String name,gender;
    ArrayList<Integer> bloodSugarArray;
//    ArrayList<Integer> bloodSugarTimestamp;

    public User(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<Integer> getBloodSugarArray() {
        return bloodSugarArray;
    }


    //    {"id":1,"username":"Patient Zero","bg_high":7,"bg_low":3,"bg_target_top":7,"bg_target_bottom":3,"height":null,"weight":null,"age":null,"gender":null,"carb_insulin":null}
    public User(JSONObject jsonObject){
        try {
            this.id = jsonObject.getInt("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.name = jsonObject.getString("username");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.glucoseHigh = jsonObject.getInt("bg_high");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.glucoseLow = jsonObject.getInt("bg_low");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.targetGlucoseHigh = jsonObject.getInt("bg_target_top");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.targetGlucoseLow = jsonObject.getInt("bg_target_bottom");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.userHeight = jsonObject.getInt("height");
            if(this.userHeight == 0){
                this.userHeight = DEFAULT_USER_HEIGHT;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.userWeight = jsonObject.getInt("weight");
            if(this.userWeight == 0){
                this.userWeight = DEFAULT_USER_WEIGHT;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.birthDate = jsonObject.getInt("age");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            this.gender = jsonObject.getString("gender");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONArray jsonLevels = jsonObject.getJSONArray("bloodsugarById");
           ArrayList<Integer>tempArray = new ArrayList<>();
//            ArrayList<Integer>tempTimestamp = new ArrayList<>();
            for(int i = 0; i < jsonLevels.length(); i++){
                JSONObject levelsJSONObject = jsonLevels.getJSONObject(i);
                int value = levelsJSONObject.getInt("value");
//                int time = levelsJSONObject.getInt("timestamp");
                tempArray.add(value);
//                tempTimestamp.add(time);



            }
            this.bloodSugarArray = tempArray;
//            this.bloodSugarTimestamp = tempTimestamp;



        } catch (JSONException e) {
            e.printStackTrace();
        }

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
