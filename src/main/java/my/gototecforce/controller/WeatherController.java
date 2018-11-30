package my.gototecforce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    @GetMapping("city/{id}")
    public Object getWetatherFromCity(@PathVariable("id") long cityId) {
        return null;
    }

    @GetMapping("city")
    public Object getWeather() {
        return null;
    }
}
