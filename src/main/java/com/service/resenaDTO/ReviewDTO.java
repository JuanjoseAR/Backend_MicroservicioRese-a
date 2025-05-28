/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.resenaDTO;

/**
 *
 * @author ACER
 */

import java.util.Date;
public class ReviewDTO {
    
    private String id;
    private String roomId;
    private String clientId;
    private int rating;
    private String comment;
    private Date date;

    public ReviewDTO() {}

    public ReviewDTO(String roomId, String clientId, int rating, String comment, Date date) {
        this.roomId = roomId;
        this.clientId = clientId;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRoomId() { return roomId; }
    public void setRoomId(String roomId) { this.roomId = roomId; }

    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
