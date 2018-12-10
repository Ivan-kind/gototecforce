package my.gototecforce.service.impl;

import my.gototecforce.data.dao.CityDao;
import my.gototecforce.data.dao.WeatherDao;
import my.gototecforce.data.entity.City;
import my.gototecforce.data.entity.Weather;
import my.gototecforce.dataadapter.DataAdapter;
import my.gototecforce.pojo.responce.CityWeather;
import my.gototecforce.service.WeatherService;
import my.gototecforce.utils.Days;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherServiceImpl.class);

    private final WeatherDao weatherDao;
    private final CityDao cityDao;
    private final DataAdapter dataAdapter;
    private final long daysCnt;

    @Autowired
    public WeatherServiceImpl(WeatherDao weatherDao, CityDao cityDao, ApplicationContext applicationContext,  @Value("${weather.daysFrom:28}") long daysCnt) {
        this(weatherDao, cityDao, applicationContext.getBean("yahooDataAdapter", DataAdapter.class), daysCnt);
    }

    public WeatherServiceImpl(WeatherDao weatherDao, CityDao cityDao, DataAdapter dataAdapter, long daysCnt) {
        this.weatherDao = weatherDao;
        this.cityDao = cityDao;
        this.dataAdapter = dataAdapter;
        this.daysCnt = daysCnt;
    }

    @Override
    public List<CityWeather> getWeatherInCity(String cityName) {
        LOGGER.trace("getWeatherInCity - start  cityName : {}", cityName);
        if (Objects.isNull(cityName)) return null;
        City city = cityDao.getCityByName(cityName);
        Days days = new Days(System.currentTimeMillis(), daysCnt);
        List<Weather> weathers = weatherDao.getWeatherInCityByTime(new Timestamp(days.getFrom()), new Timestamp(days.getTo()), city);
        LOGGER.debug("getWeatherInCity - found weathers : {} in city : {}", weathers, city);
        return weathers.stream()
                .filter(Objects::nonNull)
                .map(CityWeather::createByWeatherObj)
                .collect(Collectors.toList());
    }

    @Override
    public boolean saveActualWeatherInCity(String cityName) {
        return false;
    }

    @Override
    public void saveActualWeatherInAllCity() {
        LOGGER.trace("saveActualWeatherInAllCity - start");
        List<City> cities = cityDao.getAllCities();
        cities.forEach(oneCity -> {
            Weather weather = dataAdapter.getActualWeatherInCity(oneCity);
            weatherDao.saveWeather(weather);
        });
    }

    @Override
    public List<CityWeather> getCurrWeatherByAllCities() {
        LOGGER.trace("getCurrWeatherByAllCities - start");
        List<City> cities = cityDao.getAllCities();
        return cities.stream()
                .filter(Objects::nonNull)
                .map(weatherDao::getActualWeatherInCity)
                .map(CityWeather::createByWeatherObj)
                .collect(Collectors.toList());
    }
}
