package my.gototecforce.service;

public interface WeatherService {

    public Object getWeatherInCity(long cityId);

    public Object saveWeatherInCity(long cityId, Object weather);

    public Object getCurrWeatherByAllCities();
}
