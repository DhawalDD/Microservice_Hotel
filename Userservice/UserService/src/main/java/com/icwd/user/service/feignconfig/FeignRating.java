package com.icwd.user.service.feignconfig;


import com.icwd.user.service.entity.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-SERVICE" )
public interface FeignRating {


    @GetMapping("/ratingservice/getratingbyuserid/{id}")
    List<Ratings> getRatingsbyFeign(@PathVariable String id);


}
