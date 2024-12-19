package com.dealmart.service;

import com.dealmart.model.Rating;

import java.util.List;

public interface RatingService {
    Rating createRating(Rating rating);

    List<Rating> getAllRatings();

    Rating getRatingById(long id);

    Rating updateRating(Rating rating, long id);

    void deleteRating(long id);
}
