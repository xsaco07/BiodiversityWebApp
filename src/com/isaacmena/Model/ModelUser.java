package com.isaacmena.Model;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModelUser {

    private DataSource dataBase;
    private Connection connection;
    private Statement query;
    private ResultSet result;


    public ModelUser(DataSource dataBase) {
        this.dataBase = dataBase;
    }

    public List<User> getAllUsers() throws Exception{

        List<User> users = new ArrayList<>();

        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql = "Select * from USERS";
            query = connection.createStatement();

            // Execute sql query
            result = query.executeQuery(sql);

            while (result.next()){
                users.add(createUserFromQuery(result));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return users;

    }

    private User createUserFromQuery(ResultSet result){

        User user = null;

        try {

            String userName = result.getString(7);
            String password = result.getString(8);
            String name = result.getString(2);
            String lastName1 = result.getString(3);
            String lastName2 = result.getString(4);
            String address = result.getString(5);
            String email = result.getString(6);

            user = new User(userName, password, name, lastName1, lastName2, address, email);

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;

    }

    public User getUser(String userName) throws Exception{

        User user = null;
        System.out.println("\nUSER NAME " + userName);
        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            //String sql = String.format("Select * from USERS u where u.USER_WEB_NAME = '%s'", userName);
            String sql = String.format("Select * from USERS u where u.USER_WEB_NAME = '%s'", userName);
            query = connection.createStatement();

            // Execute sql query
            result = query.executeQuery(sql);

            if (result.next()){
                System.out.println("\nCREANDO OBJETO");
                user = createUserFromQuery(result);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;

    }

    public void deleteUser(String name) throws Exception{
        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql = String.format("Delete from USERS U where U.NAME = '%s'", name);
            query = connection.createStatement();

            // Execute sql query
            result = query.executeQuery(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateUser(String name) throws Exception{

    }

    public void insertUser(String userName, String password, String name, String lastName1, String lastName2, String address, String email){
        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql = String.format(
                    "Insert into USERS values (%s, %s, %s, %s, %s, %s, %s)",
                    name, lastName1, lastName2, address, email, userName, password);

            query = connection.createStatement();

            // Execute sql query
            result = query.executeQuery(sql);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
