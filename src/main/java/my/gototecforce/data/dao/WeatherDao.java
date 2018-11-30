package my.gototecforce.data.dao;

import my.gototecforce.data.entity.Weather;

import java.sql.Timestamp;
import java.util.List;

public interface WeatherDao {

    public List<Weather> getWeatherInCityByTime(Timestamp timeFrom, Timestamp timeTo, long cityId);


}
