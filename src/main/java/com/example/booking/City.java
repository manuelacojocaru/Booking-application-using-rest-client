package com.example.booking;

import java.util.List;

public class City {
    private String city;
    private String country;
    private List<PopulationCounts> populationCounts;

    public City() {
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

    public List<PopulationCounts> getPopulationCounts() {
        return populationCounts;
    }

    public void setPopulationCounts(List<PopulationCounts> populationCounts) {
        this.populationCounts = populationCounts;
    }
}
