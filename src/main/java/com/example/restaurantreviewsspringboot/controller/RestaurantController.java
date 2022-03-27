package com.example.restaurantreviewsspringboot.controller;

import com.example.restaurantreviewsspringboot.model.Restaurant;
import com.example.restaurantreviewsspringboot.model.RestaurantResponse;
import com.example.restaurantreviewsspringboot.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<RestaurantResponse> getAllRestaurants(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "num", defaultValue = "20") Integer num,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "cuisine", defaultValue = "") String cuisine,
            @RequestParam(value = "zipcode", defaultValue = "") String zipcode) {
        Map<String, String> filters = new HashMap<>();
        filters.put("name", name);
        filters.put("cuisine", cuisine);
        filters.put("zipcode", zipcode);
        RestaurantResponse response = restaurantService.getAllRestaurants(page, num, filters);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getRestaurantById(@PathVariable("id") Integer id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if (restaurant == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/cuisines")
    public ResponseEntity<List<String>> getAllCuisines() {
        List<String> cuisines = restaurantService.getAllCuisines();
        return new ResponseEntity<>(cuisines, HttpStatus.OK);
    }
}
