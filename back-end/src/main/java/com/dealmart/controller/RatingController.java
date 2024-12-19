package com.dealmart.controller;

import com.dealmart.model.Rating;
import com.dealmart.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {


    private RatingService ratingService;

    public RatingController(RatingService ratingService) {
        super();
        this.ratingService = ratingService;
    }

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        return new ResponseEntity<Rating>(ratingService.createRating(rating), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Rating> getAllRatings(){
        return ratingService.getAllRatings();
    }

    @GetMapping("{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable("id") long ratingId){
        return new ResponseEntity<Rating>(ratingService.getRatingById(ratingId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable("id") long ratingId, @RequestBody Rating rating){
        return new ResponseEntity<Rating>(ratingService.updateRating(rating, ratingId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRating(@PathVariable("id") long ratingId) {
        ratingService.deleteRating(ratingId);
        return new ResponseEntity<String>("Rating Deleted Successfully!", HttpStatus.OK);
    }
}
