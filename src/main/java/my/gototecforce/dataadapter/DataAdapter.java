package my.gototecforce.dataadapter;

import my.gototecforce.data.entity.City;
import my.gototecforce.data.entity.Weather;

public interface DataAdapter {

    /**
     * Method that find actual weather for city by different source
     *
     * @param city city to find
     * @return weather object
     */
    public Weather getActualWeatherInCity(City city);
}
