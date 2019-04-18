package com.example.android;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class UserDao {
    private static final String REQUEST_STRING = "https://arcane-woodland-11613.herokuapp.com/api/users/mobile/1";
    ArrayList<JsonObject> insulinArray = new ArrayList<>(); //called by getInsulinArray(String url)
    ArrayList<Integer> bloodSugarArray = new ArrayList<>();



    public static User getNewUser(){
        try {

            JSONObject jsonObject = new JSONObject(NetworkAdapter.httpRequest(REQUEST_STRING,NetworkAdapter.GET));
             User newUser = new User(jsonObject);
             return newUser;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<JsonObject> getInsulinArray(String url) {
        //TODO: grab and unwrap json array  and add to insulinArray
        return insulinArray;
    }


    public ArrayList<Integer> getBloodSugarArray(String url){
        //TODO: UNWRAP JSON OBJECT AND POPULATE bloodSugarArray

        return bloodSugarArray;

    }


}
