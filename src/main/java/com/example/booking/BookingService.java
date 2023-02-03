package com.example.booking;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BookingService {

    CitiesData getCities();
    List<Hotel> generateData();
    List<Hotel> getHotelsByCountry( String country);
    List<Hotel> getHotels();

    List<Hotel> getHotelsByCountry(String country, List<Hotel> hotels);

    List<Hotel> getHotelsByCity(String city);

    List<Hotel> getHotelsByCity(String city, List<Hotel> hotels);

    List<Hotel> getHotelsByPrice(Integer startPrice, Integer endPrice);

    List<Hotel> getHotelsByPrice(Integer startPrice, Integer endPrice, List<Hotel> hotels);

    List<Hotel> getHotelsByStars(Integer startStars, Integer endStars);

    List<Hotel> getHotelsByStars(Integer startStars, Integer endStars, List<Hotel> hotels);

    List<Hotel> getHotelsByCriteria(SearchCriteria searchCriteria);
}
