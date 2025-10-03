package com.lcwd.rating.controller;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratingservice")
public class RatingController {


    private RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/createrating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        ratingService.createRating(rating);

        return  new ResponseEntity<>(rating,HttpStatus.CREATED);
    }

    @GetMapping("getratingbyuserid/{id}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String id)
    {
       List<Rating> rr = ratingService.getRatingByUserId(id);
        return new ResponseEntity<>(rr, HttpStatus.OK);

    }


    @GetMapping("/getratingbyhotelid/{id}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String id)
    {
        List<Rating> rr = ratingService.getRatingByHotelId(id);
        return new ResponseEntity<>(rr,HttpStatus.ACCEPTED);
    }

    @PutMapping("/updaterating/{id}")
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating, @PathVariable String id)
    {
        Rating rating1= ratingService.updateRating(rating,id);
        return new ResponseEntity<>(rating1,HttpStatus.OK);
    }

    @DeleteMapping("/deleterating/{id}")
    public ResponseEntity<Rating> deleteRating(@PathVariable String id)
    {
        ratingService.deleteRating(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getallrating")
    public ResponseEntity<List<Rating>> getAllRating()
    {
       List<Rating> ratings  = ratingService.getAllRating();
        return  new ResponseEntity<>(ratings,HttpStatus.OK);
    }


}
