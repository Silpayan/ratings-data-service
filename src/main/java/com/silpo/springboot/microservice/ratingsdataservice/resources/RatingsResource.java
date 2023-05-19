package com.silpo.springboot.microservice.ratingsdataservice.resources;

import com.silpo.springboot.microservice.ratingsdataservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getRatingId(@PathVariable("movieId") String movieId){

        return new Rating(movieId, 4); //getter setter is required for the model
    }
}
