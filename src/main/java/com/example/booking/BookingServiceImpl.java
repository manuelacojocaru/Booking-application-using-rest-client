package com.example.booking;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
@Service

public class BookingServiceImpl implements BookingService {


    private final WebClient webClient;
    private final BookingRepository bookingRepository;



    public BookingServiceImpl(WebClient.Builder webClientBuilder, BookingRepository bookingRepository) {
        this.webClient = webClientBuilder
                .baseUrl("https://countriesnow.space")
                .codecs(configurer -> configurer
                        .defaultCodecs()
                        .maxInMemorySize(16 * 1024 * 1024))
                .build();

        this.bookingRepository = bookingRepository;
    }

    @Override
    public CitiesData getCities() {
        return this.webClient.get().uri("/api/v0.1/countries/population/cities")
                .retrieve().bodyToMono(CitiesData.class).block();
    }

    @Override
    public List<Hotel> generateData() {
        CitiesData citiesData = getCities();

        Random random = new Random();
        List<Hotel> hotels = new ArrayList<>();
        citiesData.getData().forEach(
                cityData ->{
                 int numberOfHotels = random.nextInt(5, 15);
                    for (int i = 0; i < numberOfHotels; i++) {
                        Faker faker = new Faker();
                        String name = faker.book().title();
                        String city = cityData.getCity();
                        String country = cityData.getCountry();
                        String image = "https://picsum.photos/200/300";
                        Integer price = random.nextInt(2600, 26000 );
                        Integer stars = random.nextInt(1, 7);
                        hotels.add(new Hotel(name, city, country, image, price, stars));



                    }
                }
        );
         bookingRepository.saveAll(hotels);
         return null;
    }



    public List<Hotel> getHotels(){
        return (List<Hotel>) bookingRepository.findAll();

    }



    @Override
    public List<Hotel> getHotelsByCountry(String country) {
        List<Hotel> hotels = getHotels();
       hotels =  hotels.stream().filter(
                hotel -> Objects.equals(hotel.getCountry(), country)
        ).toList();
        return hotels;


    }
    @Override
    public List<Hotel> getHotelsByCountry(String country, List<Hotel> hotels) {

        hotels = hotels.stream().filter(
                hotel -> Objects.equals(hotel.getCountry(), country)
        ).toList();
        return hotels;


    }
    @Override
    public List<Hotel> getHotelsByCity(String city) {
        List<Hotel> hotels = getHotels();
        hotels.stream().filter(
                hotel -> Objects.equals(hotel.getCity(), city)
        ).toList();
        return hotels;


    }
    @Override
    public List<Hotel> getHotelsByCity(String city, List<Hotel> hotels) {

        hotels.stream().filter(
                hotel -> Objects.equals(hotel.getCity(), city)
        ).toList();
        return hotels;


    }
    @Override
    public List<Hotel> getHotelsByPrice(Integer startPrice, Integer endPrice) {
        List<Hotel> hotels = getHotels();
        if (startPrice == null){
            startPrice = 0;
        }
        if (endPrice == null){
            endPrice = Integer.MAX_VALUE;
        }
        Integer finalStartPrice = startPrice;
        Integer finalEndPrice = endPrice;
        hotels.stream().filter(
                hotel -> hotel.getPrice() >= finalStartPrice && hotel.getPrice() <= finalEndPrice
        ).toList();
        return hotels;

    }

    @Override
    public List<Hotel> getHotelsByPrice(Integer startPrice, Integer endPrice, List<Hotel> hotels) {

        if (startPrice == null){
            startPrice = 0;
        }
        if (endPrice == null){
            endPrice = Integer.MAX_VALUE;
        }
        Integer finalStartPrice = startPrice;
        Integer finalEndPrice = endPrice;
        hotels.stream().filter(
                hotel -> hotel.getPrice() >= finalStartPrice && hotel.getPrice() <= finalEndPrice
        ).toList();
        return hotels;

    }

    @Override
    public List<Hotel> getHotelsByStars(Integer startStars, Integer endStars) {
        List<Hotel> hotels = getHotels();

        hotels.stream().filter(
                hotel -> hotel.getStars() >= startStars && hotel.getStars() <= endStars
        ).toList();
        return hotels;

    }

    @Override
    public List<Hotel> getHotelsByStars(Integer startStars, Integer endStars, List<Hotel> hotels) {

        hotels.stream().filter(
                hotel -> hotel.getStars() >= startStars && hotel.getStars() <= endStars
        ).toList();
        return hotels;

    }

    @Override
    public List<Hotel> getHotelsByCriteria(SearchCriteria searchCriteria) {
        List<Hotel> hotels = getHotels();
        if(searchCriteria.getCountry() != null){
            hotels = getHotelsByCountry(searchCriteria.getCountry(), hotels);
        }
        if(searchCriteria.getCity() != null){
            hotels = getHotelsByCity(searchCriteria.getCity(), hotels);
        }
        if(searchCriteria.getStartPrice() != null || searchCriteria.getEndPrice() != null){
            hotels = getHotelsByPrice(searchCriteria.getStartPrice(), searchCriteria.getEndPrice(), hotels);
        }
        if(searchCriteria.getStartStars() != null || searchCriteria.getEndStars() != null){
            hotels = getHotelsByStars(searchCriteria.getStartStars(), searchCriteria.getEndStars(), hotels);
        }
        return hotels;
    }
}
