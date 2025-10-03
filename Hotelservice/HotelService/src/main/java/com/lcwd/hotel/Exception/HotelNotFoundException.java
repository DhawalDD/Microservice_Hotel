package com.lcwd.hotel.Exception;

public class HotelNotFoundException extends RuntimeException {

    public HotelNotFoundException(String Message){

        super(Message);
    }

}
