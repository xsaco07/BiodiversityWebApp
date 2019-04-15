package com.isaacmena.Controller;

import com.isaacmena.Model.ModelUser;
import com.isaacmena.Model.User;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

    @Resource(name = "Pool")
    private DataSource dataBase;
    private ModelUser modelUser;

    @Override
    public void init() throws ServletException{
        super.init();
        try {
            modelUser = new ModelUser(dataBase);
        }catch (Exception e){
            throw new ServletException(e);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action){
            case "insert":
                insertingUser(request, response);
                break;
            case "load":
                loadUserData(request, response);
                break;
            case "upload":
                updateUser(request, response);
                break;
            case "delete":
                deletingUser(request, response);
                break;
            default:
                listUsers(request, response);
                break;
        }

    }

    private void insertingUser(HttpServletRequest request, HttpServletResponse response){

        String userName = request.getParameter("user");
        String password = request.getParameter("pass");
        String realName = request.getParameter("name");
        String lastName1 = request.getParameter("last_name1");
        String lastName2 = request.getParameter("last_name2");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        User user = new User(userName, password, realName, lastName1, lastName2, address, email);

        try {

            modelUser.insertUser(user);
            response.sendRedirect("index.jsp#users");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void listUsers(HttpServletRequest request, HttpServletResponse response){

        List<User> users;
        try {
            users = modelUser.getAllUsers();

            request.setAttribute("userList", users);

            // Send data to jsp file

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("userList.jsp");

            requestDispatcher.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void deletingUser(HttpServletRequest request, HttpServletResponse response){

        String userName = request.getParameter("user");

        try {
            modelUser.deleteUser(userName);
            response.sendRedirect("index.jsp#users");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadUserData(HttpServletRequest request, HttpServletResponse response){

        User user;
        // Get the username from the list of users linked in the request
        String username = request.getParameter("username");

        try {
            user = modelUser.getUser(username);

            request.setAttribute("user", user);

            // Send data to jsp updating form page

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("UpdateUser.jsp");

            requestDispatcher.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("user");
        String password = request.getParameter("pass");
        String realName = request.getParameter("name");
        String lastName1 = request.getParameter("last_name1");
        String lastName2 = request.getParameter("last_name2");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        User user = new User(userName, password, realName, lastName1, lastName2, address, email);

        try {

            modelUser.updateUser(user);
            response.sendRedirect("index.jsp#users");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
