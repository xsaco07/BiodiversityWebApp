package com.isaacmena.Model;

import java.util.*;

public class Observation {

    private String latitude;
    private String longitud;
    private Date date;
    private String specieName;
    private String userName;
    private String imageURL;

    public Observation(String latitude, String longitud, Date date, String specieName, String userName, String imageURL) {
        this.latitude = latitude;
        this.longitud = longitud;
        this.date = date;
        this.specieName = specieName;
        this.userName = userName;
        this.imageURL = imageURL;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSpecieName() {
        return specieName;
    }

    public void setSpecieName(String specieName) {
        this.specieName = specieName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
