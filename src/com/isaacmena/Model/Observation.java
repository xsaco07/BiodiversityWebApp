package com.isaacmena.Model;

import java.util.*;

public class Observation {

    private String latitude;
    private String longitude;
    private Date date;
    private String specieName;
    private String userName;
    private String imageURL;
    private int observationId;

    public Observation(String latitude, String longitude, Date date, String specieName, String userName, String imageURL) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.specieName = specieName;
        this.userName = userName;
        this.imageURL = imageURL;
    }

    public Observation(int observationId, String latitude, String longitude, Date date, String specieName, String userName, String imageURL) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        this.specieName = specieName;
        this.userName = userName;
        this.imageURL = imageURL;
        this.observationId = observationId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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

    public int getObservationId() { return observationId; }

    public void setObservationId(int observationId) { this.observationId = observationId; }
}
