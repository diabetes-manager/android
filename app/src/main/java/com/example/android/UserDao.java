package com.example.android;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class UserDao {
    ArrayList<JsonObject> insulinArray = new ArrayList<>(); //called by getInsulinArray(String url)
    ArrayList<Integer> bloodSugarArray = new ArrayList<>();


    public ArrayList<JsonObject> getInsulinArray(String url) {
        //TODO: grab and unwrap json array  and add to insulinArray





        return insulinArray;
    }


    public ArrayList<Integer> getBloodSugarArray(String url){
        //TODO: UNWRAP JSON OBJECT AND POPULATE bloodSugarArray

        return bloodSugarArray;

    }


}
