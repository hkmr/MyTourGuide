package com.example.android.mytourguide;

import java.io.Serializable;

public class Hotel implements Serializable {

    private String name;
    private int rating;
    private String location;

    Hotel(String name,int rating,String location){
        this.name = name;
        this.rating = rating;
        this.location = location;
    }

}
