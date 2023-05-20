package com.silpo.springboot.microservice.ratingsdataservice.resources;

import com.silpo.springboot.microservice.ratingsdataservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, "4"); //getter setter is required for the model
    }

    @RequestMapping("users/{userId}")
    public List<Rating> getUserRatings(@PathVariable("userId") String userId){
        List<Rating> ratings = Arrays.asList(
                new Rating("7354", "4"),
                new Rating("46rf8", "3")
        );

        return ratings;
    }


}
