package com.isaacmena.Controller;

import com.isaacmena.Model.ModelObservation;
import com.isaacmena.Model.ModelUser;
import com.isaacmena.Model.Observation;
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
import java.util.Date;
import java.util.List;

@WebServlet("/ObserverController")
public class ObserverController extends HttpServlet {

    @Resource(name = "Pool")
    private DataSource dataBase;
    private ModelObservation modelObservation;

    @Override
    public void init() throws ServletException{
        super.init();
        try {
            modelObservation = new ModelObservation(dataBase);
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
                insertingObservation(request, response);
                break;
            case "load":
                loadObservationData(request, response);
                break;
            case "upload":
                updateObservation(request, response);
                break;
            case "delete":
                deletingObservation(request, response);
                break;
            default:
                listObservations(request, response);
                break;
        }

    }

    private void insertingObservation(HttpServletRequest request, HttpServletResponse response){

        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        // Todo set date appropriately
        Date date = null;
        //Date date = request.getParameter("date");
        String specieName = request.getParameter("specie");
        String userName = request.getParameter("userName");
        String imageUrl = request.getParameter("imageURL");

        Observation observation = new Observation(latitude, longitude, date, specieName, userName, imageUrl);

        try {

            modelObservation.insertObservation(observation);
            response.sendRedirect("index.jsp#observations");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void listObservations(HttpServletRequest request, HttpServletResponse response){

        List<Observation> observations;
        try {
            observations = modelObservation.getAllObservations();

            request.setAttribute("observationList", observations);

            // Send data to jsp file

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("observationList.jsp");

            requestDispatcher.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void deletingObservation(HttpServletRequest request, HttpServletResponse response){

        int observationId = Integer.parseInt(request.getParameter("observationId"));

        try {
            modelObservation.deleteObservation(observationId);
            response.sendRedirect("index.jsp#observations");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadObservationData(HttpServletRequest request, HttpServletResponse response){

        Observation observation;
        // Get the username from the list of users linked in the request
        int observationId = Integer.parseInt(request.getParameter("observationId"));

        try {
            observation = modelObservation.getObservation(observationId);

            request.setAttribute("observation", observation);

            // Send data to jsp updating form page

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("UpdateObservation.jsp");

            requestDispatcher.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void updateObservation(HttpServletRequest request, HttpServletResponse response){

        int observationId = Integer.parseInt(request.getParameter("observationId"));
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        // Todo set date appropriately
        Date date = null;
        //Date date = request.getParameter("date");
        String specieName = request.getParameter("specie");
        String userName = request.getParameter("userName");
        String imageUrl = request.getParameter("imageURL");

        Observation observation = new Observation(observationId, latitude, longitude, date, specieName, userName, imageUrl);

        try {

            modelObservation.updateObservation(observation);
            response.sendRedirect("index.jsp#observations");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
