package com.realestate.controllers;

import com.realestate.models.ResidentialProperty;
import com.realestate.utils.FileHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 1. ANNOTATION: This tells the server that the URL "/property" belongs to this Servlet.
@WebServlet("/property")
public class PropertyServlet extends HttpServlet {

    // 2. POST METHOD: This handles data submitted from an HTML form.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Grab the hidden "action" field from whichever form was submitted
        String action = request.getParameter("action");

        // Route 1: The user wants to DELETE
        if ("delete".equals(action)) {
            String idToDelete = request.getParameter("id");
            if (idToDelete != null && !idToDelete.trim().isEmpty()) {
                FileHandler.deleteProperty(idToDelete.trim());
            }
        }
        // Route 2: The user wants to ADD
        else if ("add".equals(action)) {
            String location = request.getParameter("location");
            String priceStr = request.getParameter("price");
            String bedsStr = request.getParameter("bedrooms");

            // Quick safety check to make sure data isn't null before parsing
            if (priceStr != null && bedsStr != null) {
                double price = Double.parseDouble(priceStr);
                int bedrooms = Integer.parseInt(bedsStr);
                String id = String.valueOf(System.currentTimeMillis());

                ResidentialProperty newProperty = new ResidentialProperty(id, location, price, bedrooms);
                FileHandler.saveProperty(newProperty.toFileFormat());
            }
        }

        // Redirect back to home
        response.sendRedirect("index.jsp");
    }
}