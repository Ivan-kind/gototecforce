package my.gototecforce.data.dao;

import my.gototecforce.data.entity.City;

import java.util.List;

public interface CityDao {

    /**
     * Method that find city by name
     *
     * @param cityName name of city
     * @return city object
     */
    public City getCityByName(String cityName);

    /**
     * Method that find all city of DB
     *
     * @return list of cities
     */
    public List<City> getAllCities();
}
