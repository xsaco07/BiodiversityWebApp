package com.isaacmena.Controller;

public class Credencial {
    static String CurrentUserName;
    static String CurrentUserPassword;
    public static void setCurrentUser(String userName, String userPassword){
        CurrentUserName = userName;
        CurrentUserPassword = userPassword;
    }
}
