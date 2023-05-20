package com.silpo.springboot.microservice.ratingsdataservice.resources;

import com.silpo.springboot.microservice.ratingsdataservice.models.Rating;
import com.silpo.springboot.microservice.ratingsdataservice.models.UserRating;
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

    @RequestMapping("usersList/{userId}")
    public List<Rating> getUserRatingsList(@PathVariable("userId") String userId){
        //Response : [{"movieId":"1234","rating":"4"},{"movieId":"1235","rating":"5"}]
        //Since this is list object, if we change the contract consumers would break
        //So better to use an Object i.e. UserRating

        List<Rating> ratings = Arrays.asList(
                new Rating("1234", "4"),
                new Rating("1235", "5")
        );

        return ratings;
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId){
        //Response : {"userRatings":[{"movieId":"7354","rating":"4"},{"movieId":"46rf8","rating":"3"}]}

        List<Rating> ratings = Arrays.asList(
                new Rating("7354", "4"),
                new Rating("46rf8", "3")
        );

        UserRating userRating = new UserRating();
        userRating.setUserRatings(ratings);

        return userRating;
    }


}
