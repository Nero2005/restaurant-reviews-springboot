package com.example.restaurantreviewsspringboot.controller;

import com.example.restaurantreviewsspringboot.model.Review;
import com.example.restaurantreviewsspringboot.model.ReviewForm;
import com.example.restaurantreviewsspringboot.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/restaurants/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody ReviewForm reviewForm) {
        Review review = reviewService.addReview(reviewForm);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Review> updateReview(@RequestBody Review review) {
        Review newReview = reviewService.updateReview(review.getId(), review);
        if (newReview == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(review, HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<Review> deleteReview(@RequestParam(value = "id") Integer id,
                                               @RequestParam(value = "user_id") String userId) {
        Review deletedReview = reviewService.deleteReview(id, userId);
        if (deletedReview == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deletedReview, HttpStatus.NO_CONTENT);
    }
}
