package my.gototecforce.service;

import my.gototecforce.data.dao.CityDao;
import my.gototecforce.data.dao.WeatherDao;
import my.gototecforce.data.entity.City;
import my.gototecforce.data.entity.Weather;
import my.gototecforce.dataadapter.DataAdapter;
import my.gototecforce.pojo.responce.CityWeather;
import my.gototecforce.service.impl.WeatherServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WeatherServiceImplTest {

    @Test
    public void getWeatherInCityTest() {
        WeatherDao weatherDao = Mockito.mock(WeatherDao.class);
        CityDao cityDao = Mockito.mock(CityDao.class);
        DataAdapter dataAdapter = Mockito.mock(DataAdapter.class);
        long daysCnt = 7;
        WeatherService weatherService = new WeatherServiceImpl(weatherDao, cityDao, dataAdapter, daysCnt);
        String cityName = "test";

        City city = new City();
        city.setId(1);
        city.setName(cityName);
        Mockito.when(cityDao.getCityByName(cityName)).thenReturn(city);
        Weather weather = new Weather();
        weather.setTemperature(0);
        weather.setWindSpeed(0);
        weather.setCity(city);
        Mockito.when(weatherDao.getWeatherInCityByTime(Mockito.any(), Mockito.any(), Mockito.eq(city))).thenReturn(Collections.singletonList(weather));

        Assert.assertEquals(CityWeather.createByWeatherObj(weather), weatherService.getWeatherInCity(cityName).get(0));
        Mockito.verify(cityDao, Mockito.times(1)).getCityByName(cityName);
        Mockito.verify(weatherDao, Mockito.times(1)).getWeatherInCityByTime(Mockito.any(), Mockito.any(), Mockito.eq(city));
    }

    @Test
    public void getCurrWeatherByAllCitiesTest() {
        WeatherDao weatherDao = Mockito.mock(WeatherDao.class);
        CityDao cityDao = Mockito.mock(CityDao.class);
        DataAdapter dataAdapter = Mockito.mock(DataAdapter.class);
        long daysCnt = 7;
        WeatherService weatherService = new WeatherServiceImpl(weatherDao, cityDao, dataAdapter, daysCnt);

        City city1 = new City();
        city1.setId(1);
        city1.setName("name1");

        City city2 = new City();
        city2.setId(1);
        city2.setName("name2");
        Mockito.when(cityDao.getAllCities()).thenReturn(Arrays.asList(city1, city2));

        Weather weather1 = new Weather();
        weather1.setTemperature(0);
        weather1.setWindSpeed(0);
        weather1.setCity(city1);

        Weather weather2 = new Weather();
        weather2.setTemperature(1);
        weather2.setWindSpeed(1);
        weather2.setCity(city2);
        Mockito.when(weatherDao.getActualWeatherInCity(Mockito.eq(city1))).thenReturn(weather1);
        Mockito.when(weatherDao.getActualWeatherInCity(Mockito.eq(city2))).thenReturn(weather2);

        List<CityWeather> cityWeathers = weatherService.getCurrWeatherByAllCities();
        Assert.assertTrue(cityWeathers.contains(CityWeather.createByWeatherObj(weather1)));
        Assert.assertTrue(cityWeathers.contains(CityWeather.createByWeatherObj(weather2)));
        Mockito.verify(cityDao, Mockito.times(1)).getAllCities();
        Mockito.verify(weatherDao, Mockito.times(1)).getActualWeatherInCity(city1);
        Mockito.verify(weatherDao, Mockito.times(1)).getActualWeatherInCity(city2);
    }
}
