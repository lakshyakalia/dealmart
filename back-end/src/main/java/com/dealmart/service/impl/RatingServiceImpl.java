package com.dealmart.service.impl;

import com.dealmart.exception.ResourceNotFoundException;
import com.dealmart.model.Rating;
import com.dealmart.repository.RatingRepository;
import com.dealmart.service.RatingService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        super();
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getRatingById(long id) {
        return ratingRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Rating", "Id", id));
    }

    @Override
    public Rating updateRating(Rating rating, long id) {
        Rating existingRating = ratingRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Rating", "Id", id));

        existingRating.setDate(rating.getDate());
        existingRating.setProduct(rating.getProduct());
        existingRating.setUser(rating.getUser());
        existingRating.setReview(rating.getReview());

        ratingRepository.save(existingRating);

        return existingRating;
    }

    @Override
    public void deleteRating(long id) {

        ratingRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Rating", "Id", id));

        ratingRepository.deleteById(id);
    }
}
