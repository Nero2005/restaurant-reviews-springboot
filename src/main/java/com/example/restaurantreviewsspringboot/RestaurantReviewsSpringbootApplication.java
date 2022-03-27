package com.example.restaurantreviewsspringboot;

import com.example.restaurantreviewsspringboot.model.Address;
import com.example.restaurantreviewsspringboot.model.Restaurant;
import com.example.restaurantreviewsspringboot.model.Review;
import com.example.restaurantreviewsspringboot.repo.AddressRepo;
import com.example.restaurantreviewsspringboot.repo.RestaurantRepo;
import com.example.restaurantreviewsspringboot.repo.ReviewRepo;
import com.example.restaurantreviewsspringboot.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class RestaurantReviewsSpringbootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantReviewsSpringbootApplication.class, args);
	}

	@Autowired
	private RestaurantRepo restaurantRepo;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private ReviewRepo reviewRepo;

	@Override
	public void run(String... args) throws Exception {
//		Restaurant restaurant1 = new Restaurant("Maries Crisis Cafe",
//				"American", "Manhattan");
//		Address address1 = new Address("59", (double)40.733235, (double)-74.00340299999999,
//				"Grove Street", "10014");
//		restaurant1.setAddress(address1);
//		restaurantRepo.save(restaurant1);
//
//		Restaurant restaurant2 = new Restaurant("La Grenouille",
//				"French", "Manhattan");
//		Address address2 = new Address("3", (double)40.7596796, (double)-73.97557069999999,
//				"East 52 Street", "10022");
//		restaurant2.setAddress(address2);
//		restaurantRepo.save(restaurant2);
//
//		Restaurant restaurant3 = new Restaurant("New York Pizza Suprema",
//				"Pizza", "Manhattan");
//		Address address3 = new Address("413", (double)40.750205, (double)-73.99532099999999,
//				"8 Avenue", "10001");
//		restaurant3.setAddress(address3);
//		restaurantRepo.save(restaurant3);
//
//		Restaurant restaurant4 = new Restaurant("Irish Cottage",
//				"Irish", "Queens");
//		Address address4 = new Address("108-07", (double)40.7261682, (double)-73.8236419,
//				"72 Avenue", "11375");
//		restaurant4.setAddress(address4);
//		restaurantRepo.save(restaurant4);
//
//		Restaurant restaurant5 = new Restaurant("Cocktail Room (Nyac)",
//				"American", "Manhattan");
//		Address address5 = new Address("180", (double)40.7665961, (double)-73.9788694,
//				"Central Park South", "10019");
//		restaurant5.setAddress(address5);
//		restaurantRepo.save(restaurant5);
//		Review review1 = new Review("Nero", "Bad!", "1234", new Date());
//		review1.setRestaurant(restaurantService.getRestaurantById(3));
//		reviewRepo.save(review1);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/v1/**").allowedOrigins("*")
						.allowedHeaders("Access-Control-Allow-Origin", "*")
						.allowedMethods("GET", "PUT", "POST", "DELETE");
			}
		};
	}
}
