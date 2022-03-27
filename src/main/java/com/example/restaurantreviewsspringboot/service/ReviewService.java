package com.example.restaurantreviewsspringboot.service;

import com.example.restaurantreviewsspringboot.model.Review;
import com.example.restaurantreviewsspringboot.model.ReviewForm;

public interface ReviewService {
    Review addReview(ReviewForm reviewForm);
    Review getReviewById(Integer reviewId);
    Review updateReview(Integer reviewId, Review review);
    Review deleteReview(Integer reviewId, String userId);
}
