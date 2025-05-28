/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.resenamodel;


import java.util.Date;
import org.bson.types.ObjectId;
/**
 *
 * @author ACER
 */
public class Review {
    private ObjectId id;
    private String roomId;
    private String clientId;
    private int rating;
    private String comment;
    private Date date;

    
    public Review() {
    }

    
    public Review(String roomId, String clientId, int rating, String comment, Date date) {
        this.roomId = roomId;
        this.clientId = clientId;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    // Getters y Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
