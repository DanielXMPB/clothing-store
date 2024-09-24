package com.danielxmpb.clothingstore.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.danielxmpb.clothingstore.models.Clothe;
import com.danielxmpb.clothingstore.services.ClotheService;
import com.google.gson.Gson;

/**
 *
 * @author Daniel Pérez
 */
@WebServlet(name = "SvClothe", urlPatterns = { "/SvClothe" })
public class SvClothe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("getAllClothes")) {
            try {
                getAllClothes(request, response);
            } catch (SQLException e) {
                response.getWriter().write("Error: " + e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            getAllClothes(request, response);
        } catch (SQLException e) {
            response.getWriter().write("Error: " + e);
        }
    }

    protected void getAllClothes(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("application/json;charset=UTF-8");
        try {
            ClotheService clotheService = new ClotheService();
            List<Clothe> clothes = clotheService.getAllClothes();
            String json = new Gson().toJson(clothes);
            response.getWriter().write(json);
        } catch (Exception e) {
            response.getWriter().write("Error: " + e);
        }
    }
}
