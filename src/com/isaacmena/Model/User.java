package com.isaacmena.Model;

public class User {

    private String userName;
    private String password;
    private String name;
    private String lastName1;
    private String lastName2;
    private String address;
    private String email;

    public User(String userName, String password, String name, String lastName1, String lastName2, String address, String email) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.address = address;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
