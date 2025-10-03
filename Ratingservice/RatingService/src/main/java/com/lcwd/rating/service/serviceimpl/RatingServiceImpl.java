package com.lcwd.rating.service.serviceimpl;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.repository.RatingRepository;
import com.lcwd.rating.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Service
public class RatingServiceImpl implements RatingService {


    private RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository)
    {
        this.ratingRepository = ratingRepository;
    }




    @Override
    public Rating createRating(Rating rating) {

        String Ratingid = UUID.randomUUID().toString();
       // rating.setRatingId(Ratingid);

        rating.setRatingId(Ratingid);

        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(Rating rating, String id) {

        Rating upRating = ratingRepository.findById(id).orElseThrow(()->new RuntimeException("No Ratings available"));
        upRating.setRatingId(id);
        upRating.setHotelId(rating.getHotelId());
        upRating.setUserId(rating.getUserId());
        upRating.setRating(rating.getRating());

        return ratingRepository.save(upRating) ;
    }

    @Override
    public List<Rating> getAllRating()
    {
        return ratingRepository.findAll();
    }

    @Override
    public String deleteRating(String id)
    {
        ratingRepository.deleteById(id);
        return "Rating delete successfully";
    }

    @Override
    public List<Rating> getRatingByUserId(String id)
    {

      return ratingRepository.findByUserId(id);
    }

    @Override
    public List<Rating> getRatingByHotelId(String id)
    {

        return ratingRepository.findByHotelId(id);
    }
}
