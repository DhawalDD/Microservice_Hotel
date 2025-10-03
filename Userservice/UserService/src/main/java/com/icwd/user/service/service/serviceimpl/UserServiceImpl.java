package com.icwd.user.service.service.serviceimpl;


import com.icwd.user.service.entity.Hotel;
import com.icwd.user.service.entity.Ratings;
import com.icwd.user.service.entity.User;
import com.icwd.user.service.feignconfig.FeignRating;
import com.icwd.user.service.repository.UserRepository;
import com.icwd.user.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

   private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FeignRating rating;



    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);




    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

   @Override
    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with" + id + "Not Found")
        );
    }


//    @Override
//    public User getUser(String id) {
//
//        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("user with this id not found"));
//        //we pass api to get ratings details by id
//       Ratings[] ratings = restTemplate.getForObject("http://localhost:8083/ratingservice/getratingbyuserid/"+user.getUserId(),Ratings[].class);
//
//       List<Ratings> rats = Arrays.stream(ratings).toList();
//
//         //  user.setRatings(rats);
//
//       // System.out.println(rats);
//
//
//          List<Ratings>  ratingList = rats.stream().map(rating->
//          {
//
//              ResponseEntity<Hotel> hoteldetails = restTemplate.getForEntity("http://HOTEL-SERVICE/hotelservice/gethotel/"+rating.getHotelId(),Hotel.class);
//                Hotel hoteltemp = hoteldetails.getBody();
//
//                  rating.setHotel(hoteltemp);
//                  return rating;
//
//          }).collect(Collectors.toList());
//
//              user.setRatings(ratingList);
//               return user;
//
//    }




    // GET API CALL FROM USER TO GET RATING BY FEIGN SERVICE
    @Override
    public User getUser(String id) {

        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("user with this id not found"));
        //we pass api to get ratings details by id

       // have a look at Confiuration folder fro below line
        List<Ratings> ra1 = rating.getRatingsbyFeign(user.getUserId());

        user.setRatings(ra1);
        return user;

    }

   /* @Override
    public User getUser(String id) {


        //API CALL TO RATING FROM USER WITH RESTTEMPLATE

        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("user with this id not found"));


        List<Ratings> ratings = restTemplate.getForObject("http://RATING-SERVICE/ratingservice/getratingbyuserid/"+user.getUserId(),ArrayList.class);


        user.setRatings(ratings);

        return user;

    }
*/


    @Override
    public String deleteUser(String id) {

        userRepository.deleteById(id);

        return "User With id :"+ id +"Deleted Successfully";
    }

    @Override
    public User updateUser(User user, String id)
    {
         User UpdateUser = userRepository.findById(id).orElseThrow(()->new RuntimeException("user not found" + id));


        UpdateUser.setUserId(id);
        UpdateUser.setFirst_Name(user.getFirst_Name());
        UpdateUser.setLast_Name(user.getLast_Name());
        UpdateUser.setUser_Email(user.getUser_Email());

        return userRepository.save(UpdateUser);

    }

}
