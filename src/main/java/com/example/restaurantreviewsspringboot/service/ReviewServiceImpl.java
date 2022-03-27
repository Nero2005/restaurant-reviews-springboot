package com.example.restaurantreviewsspringboot.service;

import com.example.restaurantreviewsspringboot.model.Restaurant;
import com.example.restaurantreviewsspringboot.model.Review;
import com.example.restaurantreviewsspringboot.model.ReviewForm;
import com.example.restaurantreviewsspringboot.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final RestaurantService restaurantService;
    private final ReviewRepo reviewRepo;

    @Autowired
    public ReviewServiceImpl(RestaurantService restaurantService, ReviewRepo reviewRepo) {
        this.restaurantService = restaurantService;
        this.reviewRepo = reviewRepo;
    }

    @Override
    public Review addReview(ReviewForm reviewForm) {
        Integer restaurantId = reviewForm.getRestaurant_id();
        Review review = new Review(reviewForm.getName(), reviewForm.getText(),
                reviewForm.getUser_id(), new Date());
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        review.setRestaurant(restaurant);
        return reviewRepo.save(review);
    }

    @Override
    public Review getReviewById(Integer reviewId) {

        return reviewRepo.findById(reviewId).orElse(null);
    }

    @Override
    public Review updateReview(Integer reviewId, Review newReview) {
        Review review = getReviewById(reviewId);
        if (review == null) {
            return null;
        }
        if (!review.getUser_id().equals(newReview.getUser_id())) {
            return null;
        }
        review.setText(newReview.getText());
        review.setTimestamp(new Date());
        return reviewRepo.save(review);
    }

    @Override
    public Review deleteReview(Integer reviewId, String userId) {
        Review review = getReviewById(reviewId);
        if (review == null) {
            return null;
        }
        if (!review.getUser_id().equals(userId)) {
            return null;
        }
        reviewRepo.delete(review);
        return review;
    }
}
