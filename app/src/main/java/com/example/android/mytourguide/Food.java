package com.example.android.mytourguide;

import java.io.Serializable;

public class Food implements Serializable {

    private String name;
    private String location;
    private int imgId;
    private String info;
    private String website;

    public Food(String name, String location,String website, int img, String info){
        this.name = name;
        this.location = location;
        this.imgId = img;
        this.info = info;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public int getImgId() {
        return imgId;
    }

    public String getInfo() {
        return info;
    }

    public String getLocation() {
        return location;
    }

    public String getWebsite() {
        return website;
    }
}
