package com.isaacmena.Model;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelImage {

    public ModelImage() {
    }

    private static Image createImageFromCursorData(BasicDBObject cursorData){

        Image image = null;

        try {

            String imageURL = cursorData.getString("url");
            String photographerName = cursorData.getString("photographerName");
            String specieName = cursorData.getString("specieName");
            Date date = cursorData.getDate("date");
            String country = cursorData.getString("country");
            String province = cursorData.getString("province");
            String ownerName = cursorData.getString("owner");

            image = new Image(imageURL, photographerName, specieName, date, country, province, ownerName);

        }catch (Exception e){
            e.printStackTrace();
        }

        return image;
    }

    public static List<Image> getAllImages() throws Exception{

        MongoCollection imageCollection;
        MongoDatabase database;
        FindIterable iterator;
        MongoCursor cursor;

        List<Image> images = new ArrayList<>();

        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {

            // Establish connection

            // Establish connection with database
            database = mongoClient.getDatabase("ImagesDB");

            // Get the collection of images
            imageCollection = database.getCollection("ImagesCollection");

            iterator = imageCollection.find();

            cursor = iterator.iterator();

            while (cursor.hasNext()) {
                images.add(createImageFromCursorData((BasicDBObject) cursor.next()));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return images;

    }

    public static void insertImage(Image image) throws Exception{

        MongoCollection imageCollection;
        MongoDatabase database;

        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {

            // Establish connection

            // Establish connection with database
            database = mongoClient.getDatabase("ImagesDB");

            // Get the collection of images
            imageCollection = database.getCollection("ImagesCollection");

            imageCollection.insertOne(image.toBasicDBObject());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateImage(Image image) throws Exception{

        MongoCollection imageCollection;
        MongoDatabase database;

        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {

            // Establish connection

            // Establish connection with database
            database = mongoClient.getDatabase("ImagesDB");

            // Get the collection of images
            imageCollection = database.getCollection("ImagesCollection");

            imageCollection.updateOne(Filters.eq("id", image.getImageId()),
                    Updates.combine(Updates.set("url", image.getImageURL()),
                            Updates.set("photographerName", image.getPhtographerName()),
                            Updates.set("specieName", image.getSpecieName()),
                            Updates.set("date", image.getDate()),
                            Updates.set("country", image.getCountry()),
                            Updates.set("province", image.getProvince()),
                            Updates.set("owner", image.getOwnerName())));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Image getImage(int imageId) throws Exception{

        MongoCollection imageCollection;
        MongoDatabase database;
        FindIterable iterator;
        MongoCursor cursor;

        Image image =  null;

        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {

            // Establish connection

            // Establish connection with database
            database = mongoClient.getDatabase("ImagesDB");

            // Get the collection of images
            imageCollection = database.getCollection("ImagesCollection");

            BasicDBObject objectSearched = new BasicDBObject("id", imageId);

            iterator = imageCollection.find(objectSearched);

            cursor = iterator.iterator();

            if (cursor.hasNext()) {
                image = createImageFromCursorData((BasicDBObject) cursor.next());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;

    }

    public static void deleteImage(int imageId) throws Exception{

        MongoCollection imageCollection;
        MongoDatabase database;

        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {

            // Establish connection

            // Establish connection with database
            database = mongoClient.getDatabase("ImagesDB");

            // Get the collection of images
            imageCollection = database.getCollection("ImagesCollection");

            BasicDBObject objectToDelete = new BasicDBObject("id", imageId);

            imageCollection.deleteOne(objectToDelete);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
