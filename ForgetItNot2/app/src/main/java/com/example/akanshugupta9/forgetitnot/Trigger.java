package com.example.akanshugupta9.forgetitnot;

/**
 * Created by akanshugupta9 on 14/4/17.
 */

public class Trigger {

    int srNo, radius, hour1, min1, hour2, min2, type;
    double longitude, latitude;
    String days;

    Trigger(int srNo, int type, int hour1, int min1, int hour2, int min2, String days, double longitude, double latitude, int radius){
        this.srNo=srNo;
        this.type=type;
        this.hour1=hour1;
        this.hour2=hour2;
        this.min1=min1;
        this.min2=min2;
        this.days=days;
        this.latitude=latitude;
        this.longitude=longitude;
        this.radius=radius;
    }
}
