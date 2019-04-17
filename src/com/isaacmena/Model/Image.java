package com.isaacmena.Model;

import com.mongodb.BasicDBObject;

import java.util.*;

public class Image {

    private String imageId;
    private String imageURL;
    private String phtographerName;
    private String specieName;
    private Date date;
    private String country;
    private String province;
    private String ownerName;

    public Image(String imageId, String imageURL, String phtographerName, String specieName, Date date, String country, String province, String ownerName) {
        this.imageId = imageId;
        this.imageURL = imageURL;
        this.phtographerName = phtographerName;
        this.specieName = specieName;
        this.date = date;
        this.country = country;
        this.province = province;
        this.ownerName = ownerName;
    }

    public Image(String imageURL, String phtographerName, String specieName, Date date, String country, String province, String ownerName) {
        this.imageURL = imageURL;
        this.phtographerName = phtographerName;
        this.specieName = specieName;
        this.date = date;
        this.country = country;
        this.province = province;
        this.ownerName = ownerName;
    }

    public BasicDBObject toBasicDBObject(){
        return new BasicDBObject("url", this.getImageURL())
                    .append("photographerName", this.getPhtographerName())
                    .append("specieName", this.getSpecieName())
                    .append("date", this.getDate())
                    .append("country", this.getCountry())
                    .append("province", this.getProvince())
                    .append("owner", this.getOwnerName());
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPhtographerName() {
        return phtographerName;
    }

    public void setPhtographerName(String phtographerName) {
        this.phtographerName = phtographerName;
    }

    public String getSpecieName() {
        return specieName;
    }

    public void setSpecieName(String specieName) {
        this.specieName = specieName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

}
