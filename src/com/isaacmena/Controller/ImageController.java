package com.isaacmena.Controller;

import com.isaacmena.Model.Image;
import com.isaacmena.Model.ModelImage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/ImageController")
public class ImageController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action){
            case "insert":
                insertingImage(request, response);
                break;
            case "load":
                loadImageData(request, response);
                break;
            case "update":
                updateImage(request, response);
                break;
            case "delete":
                deletingImages(request, response);
                break;
            default:
                listImages(request, response);
                break;
        }

    }

    private void insertingImage(HttpServletRequest request, HttpServletResponse response){

        String imageUrl = request.getParameter("url");
        String photographerName = request.getParameter("photographer");
        String specieName = request.getParameter("specieName");
        Date date = getDateFromForm(request);
        String country = request.getParameter("country");
        String province = request.getParameter("province");
        String owner = request.getParameter("owner");

        Image image = new Image(imageUrl, photographerName, specieName, date, country, province, owner);

        try {
            System.out.println("\nInserting image\n");
            ModelImage.insertImage(image);
            listImages(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void listImages(HttpServletRequest request, HttpServletResponse response){

        List<Image> images;

        try {
            images = ModelImage.getAllImages();

            request.setAttribute("imageList", images);

            // Send data to jsp file

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("imageList.jsp");

            requestDispatcher.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void deletingImages(HttpServletRequest request, HttpServletResponse response){

        String imageId = request.getParameter("imageId");

        try {
            ModelImage.deleteImage(imageId);
            listImages(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void loadImageData(HttpServletRequest request, HttpServletResponse response){

        Image image;

        // Get the image id from the list of users linked in the request
        String imageId = request.getParameter("imageId");

        try {
            image = ModelImage.getImage(imageId);
            request.setAttribute("image", image);

            // Send data to jsp updating form page

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View/ImageJSPs/UpdateImage.jsp");

            requestDispatcher.forward(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void updateImage(HttpServletRequest request, HttpServletResponse response){

        String imageId = request.getParameter("imageId");
        String imageUrl = request.getParameter("url");
        String photographerName = request.getParameter("photographer");
        String specieName = request.getParameter("specieName");
        Date date = getDateFromForm(request);
        String country = request.getParameter("country");
        String province = request.getParameter("province");
        String owner = request.getParameter("owner");

        Image image = new Image(imageId, imageUrl, photographerName, specieName, date, country, province, owner);

        System.out.println("\n " + imageUrl + "\n");

        try {
            ModelImage.updateImage(image);
            listImages(request, response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Date getDateFromForm(HttpServletRequest request){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(request.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

}
