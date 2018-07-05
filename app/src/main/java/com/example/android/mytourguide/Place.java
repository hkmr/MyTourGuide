package com.example.android.mytourguide;

import java.io.Serializable;
import java.math.BigInteger;

public class Place implements Serializable {

    private String mName;
    private String mLocation;
    private int mImageId;
    private String mInfo;
    private String mLocationUri;
    private String mWorkingHours;
    private String mWebsite;
    private String mPhoneNo;

    public Place(String name, String location, String info, int imageId){
        this.mName = name;
        this.mLocation = location;
        this.mInfo = info;
        this.mImageId = imageId;
    }

    public Place(String name, String location, String info, int image, String locationUri,String workingHours, String website, String phone){
        this.mName = name;
        this.mLocation = location;
        this.mInfo = info;
        this.mImageId = image;
        this.mLocationUri = locationUri;
        this.mWorkingHours = workingHours;
        this.mWebsite = website;
        this.mPhoneNo = phone;
    }

    public String getmName(){
        return this.mName;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmInfo() {
        return mInfo;
    }

    public int getmImageId() {
        return mImageId;
    }

    public String getmLocationUri() {
        return mLocationUri;
    }

    public String getmPhoneNo() {
        return mPhoneNo;
    }

    public String getmWebsite() {
        return mWebsite;
    }

    public String getmWorkingHours() {
        return mWorkingHours;
    }
}
