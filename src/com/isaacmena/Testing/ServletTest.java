package com.isaacmena.Testing;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.io.IOException;

@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {

    @Resource(name = "Pool")
    private DataSource dataBase;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter outPut = response.getWriter();
        response.setContentType("text/html");

        Connection connection;
        Statement query;
        ResultSet result;

        try {

            // Create connection
            //connection = dataBase.getConnection();

            // Create sql query
            //String sql = "Select * from TAXON_LEVEL";
            //query = connection.createStatement();

            // Execute sql query
            //result = query.executeQuery(sql);

            // Show results
            outPut.println("<html><body>");
            outPut.println("<h1 style='text-align:center'>Prueba Servlet</h1>");
            //while (result.next()){
            //    String taxon = result.getString("LEVEL_NAME");
            //    outPut.println("<h3>Level name: " + taxon + "</h3>");
            //}
            outPut.println("</body></html>");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
