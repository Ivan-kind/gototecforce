package my.gototecforce.controller;

import my.gototecforce.pojo.ResultOperation;
import my.gototecforce.service.WeatherService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class WeatherControllerTest {

    @Test
    public void getWeatherTest() {
        WeatherService weatherService = Mockito.mock(WeatherService.class);
        WeatherController weatherController = new WeatherController(weatherService);
        Assert.assertEquals(ResultOperation.SUCCESS_CODE, weatherController.getWeather().getCode());

        Mockito.when(weatherService.getCurrWeatherByAllCities()).thenThrow(new RuntimeException());
        Assert.assertEquals(WeatherController.SOME_ERROR_CODE, weatherController.getWeather().getCode());
    }

    @Test
    public void getWeatherFromCityTest() {
        WeatherService weatherService = Mockito.mock(WeatherService.class);
        WeatherController weatherController = new WeatherController(weatherService);
        Assert.assertEquals(ResultOperation.SUCCESS_CODE, weatherController.getWeatherFromCity("cityName").getCode());

        Mockito.when(weatherService.getWeatherInCity("cityName")).thenThrow(new RuntimeException());
        Assert.assertEquals(WeatherController.SOME_ERROR_CODE, weatherController.getWeatherFromCity("cityName").getCode());
    }
}
