package com.isaacmena.Controller;

import com.isaacmena.Model.ModelObservation;
import com.isaacmena.Model.ModelUser;
import com.isaacmena.Model.Observation;
import com.isaacmena.Model.User;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            case "update":
                updateObservation(request, response);
                break;
            case "delete":
                deletingObservation(request, response);
                break;
            case "register":
                registerObservation(request, response);
                break;
            default:
                listObservations(request, response);
                break;
        }

    }

    private void registerObservation(HttpServletRequest request, HttpServletResponse response) {

        List<String> specieNames;

        try {

            specieNames = modelObservation.getSpecieNames();
            request.setAttribute("Species", specieNames);

            // Send species names list to jsp file
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ObservationJSPs/RegisterObservation.jsp");
            requestDispatcher.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void insertingObservation(HttpServletRequest request, HttpServletResponse response){

        Observation observation = createObservationFromRequestData(request, false);

        try {

            modelObservation.insertObservation(observation);
            listObservations(request, response);

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
            listObservations(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadObservationData(HttpServletRequest request, HttpServletResponse response){

        Observation observation;
        List<String> specieNames;
        // Get the username from the list of users linked in the request
        int observationId = Integer.parseInt(request.getParameter("observationId"));

        try {

            observation = modelObservation.getObservation(observationId);
            specieNames = modelObservation.getSpecieNames();

            request.setAttribute("Species", specieNames);
            request.setAttribute("observation", observation);

            // Send data to jsp updating form page

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ObservationJSPs/UpdateObservation.jsp");

            requestDispatcher.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void updateObservation(HttpServletRequest request, HttpServletResponse response){

        Observation observation = createObservationFromRequestData(request, true);

        try {
            modelObservation.updateObservation(observation);
            listObservations(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Date getDateFromForm(HttpServletRequest request){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

        try {
            return format.parse(request.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;

    }

    @NotNull
    private Observation createObservationFromRequestData(HttpServletRequest request, boolean needId){
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");
        Date date = getDateFromForm(request);
        String specieName = request.getParameter("specie");
        String userName = request.getParameter("username");
        String imageUrl = request.getParameter("imageURL");

        Observation observation;
        if (needId){
            int observationId = Integer.parseInt(request.getParameter("observationId"));
            observation = new Observation(observationId, latitude, longitude, date, specieName, userName, imageUrl);
        }
        else observation = new Observation(latitude, longitude, date, specieName, userName, imageUrl);

        return observation;
    }

}
