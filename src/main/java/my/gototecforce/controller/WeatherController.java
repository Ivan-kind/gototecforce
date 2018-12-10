package my.gototecforce.controller;

import my.gototecforce.pojo.ResultOperation;
import my.gototecforce.pojo.responce.CityWeather;
import my.gototecforce.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherController.class);
    public static final int SOME_ERROR_CODE = 1;

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/city/{name}")
    public ResultOperation getWeatherFromCity(@PathVariable("name") String name) {
        LOGGER.trace("getWeatherFromCity - start name : {}", name);
        try {
            List<CityWeather> cityWeathers = weatherService.getWeatherInCity(name);
            LOGGER.debug("getWeatherFromCity - cityWeathers : {}", cityWeathers);
            return ResultOperation.ok(cityWeathers);
        } catch (Exception e) {
            LOGGER.error("getWeatherFromCity - ERROR!", e);
            return ResultOperation.error(SOME_ERROR_CODE, e.getMessage());
        }
    }

    @GetMapping("/city")
    public ResultOperation getWeather() {
        LOGGER.trace("getWeather - start");
        try {
            List<CityWeather> cityWeathers = weatherService.getCurrWeatherByAllCities();
            LOGGER.debug("getWeather - cityWeathers : {}", cityWeathers);
            return ResultOperation.ok(cityWeathers);
        } catch (Exception e) {
            LOGGER.error("getWeather - ERROR!", e);
            return ResultOperation.error(SOME_ERROR_CODE, e.getMessage());
        }
    }
}
