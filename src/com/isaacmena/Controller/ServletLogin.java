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

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

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

        if(dataOK(request)){
            User currentUser = null;

            try {
                currentUser = modelUser.getUser(userName);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.print("\nUSER DATA: " + currentUser);

            if (currentUser == null) response.sendRedirect("View/UserJSPs/login.jsp");
            else response.sendRedirect("index.jsp");
        }
        else {
            response.sendRedirect("View/UserJSPs/login.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean dataOK(HttpServletRequest request){
        String userName = request.getParameter("user");
        String password = request.getParameter("pass");
        return userName.length() > 0 && password.length() > 0;
    }
}
