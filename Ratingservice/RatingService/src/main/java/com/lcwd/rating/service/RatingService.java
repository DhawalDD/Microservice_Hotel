package com.lcwd.rating.service;

import com.lcwd.rating.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    Rating updateRating(Rating rating, String id);
    List<Rating> getAllRating();

    String deleteRating(String id);
    List<Rating> getRatingByUserId(String id);

    List<Rating> getRatingByHotelId(String id);
}
