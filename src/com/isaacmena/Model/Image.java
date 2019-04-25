package com.isaacmena.Model;

import org.bson.Document;
import java.text.SimpleDateFormat;
import java.util.*;

public class Image {

    private String imageId;
    private String imageURL;
    private String photographerName;
    private String specieName;
    private Date date;
    private String country;
    private String province;
    private String owner;

    public Image(String imageId, String imageURL, String photographerName, String specieName, Date date, String country, String province, String owner) {
        this.imageId = imageId;
        this.imageURL = imageURL;
        this.photographerName = photographerName;
        this.specieName = specieName;
        this.date = date;
        this.country = country;
        this.province = province;
        this.owner = owner;
    }

    public Image(String imageURL, String photographerName, String specieName, Date date, String country, String province, String owner) {
        this.imageURL = imageURL;
        this.photographerName = photographerName;
        this.specieName = specieName;
        this.date = date;
        this.country = country;
        this.province = province;
        this.owner = owner;
    }

    public Document toDocument(){
        return new Document("url", this.getImageURL())
                    .append("photographerName", this.getPhotographerName())
                    .append("specieName", this.getSpecieName())
                    .append("date", this.dateToString())
                    .append("country", this.getCountry())
                    .append("province", this.getProvince())
                    .append("owner", this.getOwner());
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

    public String getPhotographerName() {
        return photographerName;
    }

    public void setPhotographerName(String photographerName) {
        this.photographerName = photographerName;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String dateToString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        return dateFormat.format(this.date);
    }

}
