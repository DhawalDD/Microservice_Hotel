package com.icwd.user.service.controller;


import com.icwd.user.service.entity.User;
import com.icwd.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/userservice")
public class UserController {



    private UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    //create
    @PostMapping("saveuser")
     public ResponseEntity<User> createUser(@RequestBody User user)
     {

         // it will generate RANDOM UNIQUE USERID
         String userIdcreation = UUID.randomUUID().toString();
         user.setUserId(userIdcreation);
         //----------------------------------------//

         User user1 = userService.createUser(user);
         return new ResponseEntity<>(user1, HttpStatus.CREATED);

     }

     ///working with RestTemplate to call rating service
     // fetch rating of above user from rating service
     @GetMapping("getuser/{userid}")
     public ResponseEntity<User> getUser(@PathVariable String userid)
     {
           User user = userService.getUser(userid);

            return new ResponseEntity<>(user,HttpStatus.OK);
     }


    @GetMapping("getuserbyid/{userid}")
    public ResponseEntity<User> getUserById(@PathVariable String userid)
    {
       User user = userService.getUserById(userid);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

     @GetMapping("getalluser")
     public ResponseEntity<List<User>> getAllUser()
     {
         List<User> users = userService.getAllUser();

         return new ResponseEntity<>(users,HttpStatus.OK);
     }

     @PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateuser(@RequestBody User user, @PathVariable String id)
     {
         userService.updateUser(user,id);
         return new ResponseEntity<>(user,HttpStatus.OK);
     }

}
