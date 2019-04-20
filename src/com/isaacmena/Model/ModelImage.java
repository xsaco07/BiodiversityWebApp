package com.isaacmena.Model;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import javax.print.Doc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelImage {

    private static Image createImageFromCursorData(Document cursorData){

        Image image = null;

        try {

            String imageId = getIdFromObject(cursorData);

            String imageURL = cursorData.getString("url");
            String photographerName = cursorData.getString("photographerName");
            String specieName = cursorData.getString("specieName");

            Date date = getDateFromCursor(cursorData);

            String country = cursorData.getString("country");
            String province = cursorData.getString("province");
            String ownerName = cursorData.getString("owner");

            image = new Image(imageId, imageURL, photographerName, specieName, date, country, province, ownerName);

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
                images.add(createImageFromCursorData((Document) cursor.next()));
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

            imageCollection.insertOne(image.toDocument());


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

            Document docToUpdate = (Document) imageCollection.find(new Document("_id", new ObjectId(image.getImageId()))).first();

            System.out.println("\nImage found\n");

            //System.out.println("\nURL: " + image.getImageURL() + "\n");
            Bson updatedValue = image.toDocument();
            Bson updateOperation = new Document("$set", updatedValue);
            imageCollection.updateOne(docToUpdate, updateOperation);

            System.out.println("\nUpdated\n");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Image getImage(String imageId) throws Exception{

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

            BasicDBObject objectSearched = new BasicDBObject("_id", new ObjectId(imageId));

            iterator = imageCollection.find(objectSearched);

            cursor = iterator.iterator();

            if (cursor.hasNext()) {
                image = createImageFromCursorData((Document) cursor.next());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;

    }

    public static void deleteImage(String imageId) throws Exception{

        MongoCollection imageCollection;
        MongoDatabase database;

        try (MongoClient mongoClient = new MongoClient("localhost", 27017)) {

            // Establish connection

            // Establish connection with database
            database = mongoClient.getDatabase("ImagesDB");

            // Get the collection of images
            imageCollection = database.getCollection("ImagesCollection");

            BasicDBObject objectToDelete = new BasicDBObject("_id", new ObjectId(imageId));

            imageCollection.deleteOne(objectToDelete);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String getIdFromObject(Document cursorData){
        ObjectId objectId = cursorData.getObjectId("_id");
        return objectId.toString();
    }

    private static Date getDateFromCursor(Document cursorData){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            return dateFormat.parse(cursorData.getString("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
