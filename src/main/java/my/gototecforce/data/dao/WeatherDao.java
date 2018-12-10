package my.gototecforce.data.dao;

import my.gototecforce.data.entity.City;
import my.gototecforce.data.entity.Weather;

import java.sql.Timestamp;
import java.util.List;

public interface WeatherDao {

    /**
     * Method that find all weather records of city by time
     *
     * @param timeFrom time from
     * @param timeTo time to
     * @param city city to find
     * @return list of weathers object
     */
    public List<Weather> getWeatherInCityByTime(Timestamp timeFrom, Timestamp timeTo, City city);

    /**
     * Method that find last weather record of city
     *
     * @param city city to find
     * @return single weather object
     */
    public Weather getActualWeatherInCity(City city);

    /**
     * Method that save new weather records
     *
     * @param weather weather object to save
     */
    public void saveWeather(Weather weather);
}
