package com.isaacmena.Controller;

import com.isaacmena.Model.ModelUser;
import com.isaacmena.Model.User;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

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
        String userName = request.getParameter("user");
        String password = request.getParameter("pass");
        String realName = request.getParameter("name");
        String lastName1 = request.getParameter("last_name1");
        String lastName2 = request.getParameter("last_name2");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        User user = new User(userName, password, realName, lastName1, lastName2, address, email);

        modelUser.insertUser(user);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
