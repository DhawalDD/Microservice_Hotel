package com.lcwd.hotel.controller;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotelservice")
public class HotelController {

    private HotelService hotelservice;

    public HotelController(HotelService hotelservice) {
        this.hotelservice = hotelservice;
    }

        @PostMapping("/savehotel")
        public ResponseEntity<Hotel> savehotel(@RequestBody Hotel hotel)
        {
            hotelservice.createHotel(hotel);
        return new ResponseEntity<>(hotel,HttpStatus.CREATED);
        }

        @GetMapping("/getallhotels")
    public ResponseEntity<List<Hotel>> getallhotels()
        {
           List<Hotel> hotels = hotelservice.getAllHotels();
            return new ResponseEntity<List<Hotel>>(hotels,HttpStatus.CREATED);
        }


        @GetMapping("/gethotel/{hotelid}")
        public ResponseEntity<Hotel> gethotel(@PathVariable("hotelid") String id)
        {
           Hotel hotel = hotelservice.getHotelById(id);
           return new ResponseEntity<>(hotel,HttpStatus.ACCEPTED);
        }

      @PutMapping("/updatehotel/{id}")
       public ResponseEntity<Hotel> updatehotel(@RequestBody Hotel hotel, @PathVariable String id)
       {
          Hotel hotel1 =  hotelservice.updateHotel(hotel,id);
            return ResponseEntity.ok(hotel1);

       }

       @DeleteMapping("/deletehotel/{id}")
       public ResponseEntity<String> deletehotel(@PathVariable String id)
       {
           hotelservice.deleteHotel(id);

           return new ResponseEntity<>("Hotel details deleted ",HttpStatus.OK);
       }







}