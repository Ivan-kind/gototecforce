package my.gototecforce.service;

import my.gototecforce.pojo.responce.CityWeather;

import java.util.List;

public interface WeatherService {

    /**
     * Method that find in db weather of city by some time period
     *
     * @param cityName city to find
     * @return
     */
    public List<CityWeather> getWeatherInCity(String cityName);

    public boolean saveActualWeatherInCity(String cityName);

    /**
     * Method that find and save actual weather for all cities in db
     */
    public void saveActualWeatherInAllCity();

    /**
     * Method that find in db actual weather for all cities
     *
     * @return
     */
    public List<CityWeather> getCurrWeatherByAllCities();
}
