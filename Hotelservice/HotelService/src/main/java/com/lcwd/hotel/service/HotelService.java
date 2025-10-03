package com.lcwd.hotel.service;

import com.lcwd.hotel.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {


    Hotel createHotel(Hotel hotel);
    List<Hotel> getAllHotels();

    Hotel getHotelById(String id);

    String deleteHotel(String id);

    Hotel updateHotel(Hotel hotel, String id);

}
