/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.resenacontroller;


import com.google.gson.Gson;
import com.service.resenaDAO.ReviewDAO;
import com.service.resenaDTO.ReviewDTO;
import com.service.validation.ReviewValidator;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Clock;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ACER
 */
@WebServlet(name = "ReviewServlet", urlPatterns = {"/reviews"})
public class ReviewServlet extends HttpServlet{

  
  
 private ReviewDAO reviewDAO;
    private final Gson gson = new Gson();

    @Override
    public void init() throws ServletException {
        reviewDAO = new ReviewDAO();
    }

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("application/json");
    try (BufferedReader reader = request.getReader()) {
        ReviewDTO dto = gson.fromJson(reader, ReviewDTO.class);
        if (dto == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"Invalid JSON data\"}");
            return;
        }

        if (dto.getDate() == null) {
            dto.setDate(new Date());
        }

        // Aquí podrías validar con ReviewValidator si tienes
        // if (!ReviewValidator.isValid(dto)) { ... }

        reviewDAO.createReview(dto);

        response.setStatus(HttpServletResponse.SC_CREATED);
        response.getWriter().write("{\"message\": \"Review created successfully\"}");
    } catch (Exception e) {
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
        e.printStackTrace();
    }
}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId = request.getParameter("roomId");
        String minRatingParam = request.getParameter("minRating");

        if (roomId == null || roomId.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{\"error\": \"roomId parameter is required\"}");
            return;
        }

        Integer minRating = null;
        if (minRatingParam != null) {
            try {
                minRating = Integer.parseInt(minRatingParam);
            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\": \"minRating must be an integer\"}");
                return;
            }
        }

        List<ReviewDTO> reviews = reviewDAO.getReviews(roomId, minRating);
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(reviews));
        out.flush();
    }
}
