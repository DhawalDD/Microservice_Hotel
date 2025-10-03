package com.lcwd.hotel.service.serviceimpl;

import com.lcwd.hotel.Exception.HotelNotFoundException;
import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.repository.HotelRepository;
import com.lcwd.hotel.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class HotelServiceImpl implements HotelService {


  private  HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository)
    {
        this.hotelRepository = hotelRepository;
    }


    @Override
    public Hotel createHotel(Hotel hotel) {

        String hotelNewId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelNewId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {

        Optional<Hotel> optionalhotel = hotelRepository.findById(id);
        return  optionalhotel.get();

                                                      //OR
        //return hotelRepository.findById(id).orElseThrow(()->new RuntimeException("Hotel with id"+id+"Not found"));
    }

    @Override
    public String deleteHotel(String id) {

         hotelRepository.deleteById(id);
         return "hotel removed from server successfully";
    }

    @Override
    public Hotel updateHotel(Hotel hotel, String id) {
        Hotel hotel1 = hotelRepository.findById(id).orElseThrow(()-> new HotelNotFoundException("Hotel with ID" + id + " not found"));

        hotel1.setHotelId(id);
        hotel1.setHotelName(hotel.getHotelName());
        hotel1.setHotelLocation(hotel.getHotelLocation());
        hotel1.setAbout(hotel.getAbout());

        return hotel1;

    }
}
