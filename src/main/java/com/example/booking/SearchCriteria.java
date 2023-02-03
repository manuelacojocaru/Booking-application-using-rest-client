package com.example.booking;

public class SearchCriteria {
    private String country;
    private String city;
    private Integer startPrice;
    private Integer endPrice;
    private Integer startStars;
    private Integer endStars;

    public SearchCriteria() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Integer startPrice) {
        this.startPrice = startPrice;
    }

    public Integer getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Integer endPrice) {
        this.endPrice = endPrice;
    }

    public Integer getStartStars() {
        return startStars;
    }

    public void setStartStars(Integer startStars) {
        this.startStars = startStars;
    }

    public Integer getEndStars() {
        return endStars;
    }

    public void setEndStars(Integer endStars) {
        this.endStars = endStars;
    }
}
