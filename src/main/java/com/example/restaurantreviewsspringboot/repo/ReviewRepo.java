package com.example.restaurantreviewsspringboot.repo;

import com.example.restaurantreviewsspringboot.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
