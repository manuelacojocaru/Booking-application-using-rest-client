package com.example.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController

public class BookingController {


    private final BookingService bookingService;

    public BookingController( BookingService bookingService) {

        this.bookingService = bookingService;
    }

    @GetMapping("/generate-data")
    public List<Hotel> generateData(){

        return bookingService.generateData();
    }
    @GetMapping("/country/{country}")
    public List<Hotel> getHotelsByCountry(@PathVariable String country){
        return bookingService.getHotelsByCountry(country);

    }

    @GetMapping("/city/{city}")
    public List<Hotel> getHotelsByCity(@PathVariable String city){
        return bookingService.getHotelsByCity(city);

    }
    @GetMapping("/price/{startPrice}/{endPrice}")
    public List<Hotel> getHotelsByPrice(@PathVariable Integer startPrice, @PathVariable Integer endPrice){
        return bookingService.getHotelsByPrice(startPrice,endPrice);
    }
    @GetMapping("/stars/{startStars}/{endStars}")
    public List<Hotel> getHotelsByStars(@PathVariable Integer startStars, @PathVariable Integer endStars) {
        return bookingService.getHotelsByStars(startStars, endStars);

    }
    @GetMapping("/advanced-search")
    public List<Hotel> getHotelsByCriteria(@RequestBody SearchCriteria searchCriteria){
        return bookingService.getHotelsByCriteria(searchCriteria);

    }








    }
