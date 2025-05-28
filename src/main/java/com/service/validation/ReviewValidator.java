/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.validation;

import com.service.resenaDTO.ReviewDTO;





/**
 *
 * @author ACER
 */
public class ReviewValidator {
        public static boolean isValid(ReviewDTO dto) {
        return getValidationError(dto) == null;
    }

    public static String getValidationError(ReviewDTO dto) {
        if (dto == null) return "Review data is missing.";
        if (dto.getRoomId() == null ) return "roomId is required."+dto.getRoomId();
        if (dto.getClientId() == null || dto.getClientId().trim().isEmpty()) return "clientId is required.";
        if (dto.getRating() < 1 || dto.getRating() > 5) return "rating must be between 1 and 5.";
        if (dto.getComment() == null || dto.getComment().trim().isEmpty()) return "comment is required.";
        return null;
    }
}
