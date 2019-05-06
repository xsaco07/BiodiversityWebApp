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
                users.add(createUserFromResultSetData(result));
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            result.close();
            connection.close();
        }

        return users;

    }

    private User createUserFromResultSetData(ResultSet result) throws Exception{

        User user = null;

        try {
            String userName = result.getString("USER_NAME");
            String password = result.getString("USER_PASS");
            String name = result.getString("NAME");
            String lastName1 = result.getString("LAST_NAME1");
            String lastName2 = result.getString("LAST_NAME2");
            String address = result.getString("ADDRESS");
            String email = result.getString("EMAIL");

            user = new User(userName, password, name, lastName1, lastName2, address, email);

        }catch (Exception e){
            e.printStackTrace();
        }

        return user;

    }

    public User getUser(String userName) throws Exception{

        User user = null;

        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql = String.format("Select * from USERS u where u.USER_NAME = '%s'", userName);
            query = connection.createStatement();

            // Execute sql query
            result = query.executeQuery(sql);

            if (result.next()){
                user = createUserFromResultSetData(result);
            }
            else throw new Exception("User not found");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            result.close();
            connection.close();
        }

        return user;

    }

    public void deleteUser(String username) throws Exception{
        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql = String.format("Delete from USERS U where U.USER_NAME = '%s'", username);
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

    public void updateUser(User user) throws Exception{

        try {

            System.out.println("\nUpdating user in model\n");

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql =
                    String.format(
                    "Update USERS set " +
                            "NAME = '%s', " +
                            "LAST_NAME1 = '%s', " +
                            "LAST_NAME2 = '%s', " +
                            "ADDRESS = '%s', " +
                            "EMAIL = '%s', " +
                            "USER_PASS = '%s'" +
                            " where USER_NAME = '%s'",
                    user.getName(), user.getLastName1(), user.getLastName2(), user.getAddress(),
                    user.getEmail(), user.getPassword(), user.getUserName());

            System.out.println("\nURL:" + sql);
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

    public void insertUser(User user) throws Exception{
        try {

            // Create connection
            connection = dataBase.getConnection();

            // Create sql query
            String sql = String.format(
                    "Insert into USERS values ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    user.getUserName(), user.getName(), user.getLastName1(), user.getLastName2(), user.getAddress(),
                    user.getEmail(), user.getPassword());

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
