package com.isaacmena.Model;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModelObservation {

    private DataSource dataBase;
    private Connection connection;
    private Statement query;
    private ResultSet result;


    public ModelObservation(DataSource dataBase) {
        this.dataBase = dataBase;
    }

    public List<Observation> getAllObservations() throws Exception{

        List<Observation> observations = new ArrayList<>();

        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql = "Select * from OBSERVATION";
            query = connection.createStatement();

            // Execute sql query
            result = query.executeQuery(sql);

            while (result.next()){
                observations.add(createObservationFromResultSetData(result));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            result.close();
            connection.close();
        }

        return observations;

    }

    private Observation createObservationFromResultSetData(ResultSet result) throws Exception{

        Observation observation = null;

        try {

            String latitude = result.getString(1);
            String longitude = result.getString(2);
            Date date = result.getDate(3);
            String specieName = result.getString(4);
            String userName = result.getString(5);
            String imageUrl = result.getString(6);

            observation = new Observation(latitude, longitude, date, specieName, userName, imageUrl);

        }catch (Exception e){
            e.printStackTrace();
        }

        return observation;

    }

    public Observation getObservation(int observationId) throws Exception{

        Observation observation = null;

        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql = String.format("Select * from OBSERVATION o where o.OBSERVATION_ID= '%s'", observationId);
            query = connection.createStatement();

            // Execute sql query
            result = query.executeQuery(sql);

            if (result.next()){
                observation = createObservationFromResultSetData(result);
            }
            else throw new Exception("Observation not found");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            result.close();
            connection.close();
        }

        return observation;

    }

    public void deleteObservation(int observationId) throws Exception{
        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql = String.format("Delete from OBSERVATION o where o.OBSERVATION_ID= '%s'", observationId);
            query = connection.createStatement();

            // Execute sql query
            result = query.executeQuery(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            result.close();
            connection.close();
        }
    }

    public void updateObservation(Observation observation) throws Exception{
        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql =
                    String.format(
                            "Update OBSERVATION o set " +
                                    "(" +
                                    "LATITUDE = '%s', " +
                                    "LONGITUDE = %s, " +
                                    "DATE = '%s', " +
                                    "SPECIE_NAME = '%s', " +
                                    "USER_NAME = '%s', " +
                                    "IMAGE_URL = '%s', " +
                                    ") where o.OBSERVATION_ID = %s",
                            observation.getLatitude(), observation.getLongitud(), observation.getDate(), observation.getSpecieName(),
                            observation.getUserName(), observation.getImageURL(), observation.getObservationId());

            query = connection.createStatement();

            // Execute sql query
            result = query.executeQuery(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            result.close();
            connection.close();
        }
    }

    public void insertObservation(Observation observation) throws Exception{
        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql = String.format(
                    "Insert into OBSERVATION values ('%s', '%s', '%s', '%s', '%s', '%s')",
                    observation.getLatitude(), observation.getLongitud(), observation.getSpecieName(), observation.getDate(),
                    observation.getSpecieName(), observation.getImageURL());

            query = connection.createStatement();

            // Execute sql query
            result = query.executeQuery(sql);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            result.close();
            connection.close();
        }
    }

}
