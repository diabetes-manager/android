package com.example.android;

public class Reading {
    int reading;
    String time;

    public Reading(int reading, String time) {
        this.reading = reading;
        this.time = time;
    }

    public int getReading() {
        return reading;
    }

    public void setReading(int reading) {
        this.reading = reading;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
