package com.example.booking;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Hotel {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String city;
    private String country;
    private String image;
    private Integer price;
    private Integer stars;

    public Hotel() {
    }

    public Hotel(String name, String city, String country, String image, Integer price, Integer stars) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.image = image;
        this.price = price;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStar(Integer stars) {
        this.stars = stars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
