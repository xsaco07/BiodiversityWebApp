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

    }

    private void insertingUser(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("user");
        String password = request.getParameter("pass");
        String realName = request.getParameter("name");
        String lastName1 = request.getParameter("last_name1");
        String lastName2 = request.getParameter("last_name2");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        // User name is the unique id
        User user = new User(userName, password, realName, lastName1, lastName2, address, email);

        modelUser.insertUser(user);
    }

    private void selectingUsers(HttpServletRequest request, HttpServletResponse response){

        List<User> users = null;
        try {
            users = modelUser.getAllUsers();

            request.setAttribute("userList", users);

            // Send data to jsp file

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/userList.jsp");

            requestDispatcher.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
