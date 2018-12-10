package my.gototecforce.controller;

import my.gototecforce.service.WeatherService;
import org.junit.Test;
import org.mockito.Mockito;

public class SchedulerControllerTest {

    @Test
    public void saveActualWeatherTest() {
        WeatherService weatherService = Mockito.mock(WeatherService.class);
        SchedulerController schedulerController = new SchedulerController(weatherService);
        schedulerController.saveActualWeather();
        Mockito.verify(weatherService, Mockito.only()).saveActualWeatherInAllCity();
    }
}
