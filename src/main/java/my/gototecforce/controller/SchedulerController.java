package my.gototecforce.controller;

import my.gototecforce.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping(value = "/scheduler")
public class SchedulerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerController.class);
    private static final AtomicBoolean isSaveActualWeatherEnabled = new AtomicBoolean();

    private final WeatherService weatherService;

    public SchedulerController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Scheduled(fixedDelay = 60 * 60 * 1000, initialDelay = 5000)
    @GetMapping("/saveActualWeather")
    public void saveActualWeather() {
        LOGGER.trace("saveActualWeather - start");
        if (!isSaveActualWeatherEnabled.getAndSet(true)) {
            try {
                LOGGER.debug("saveActualWeather - start saving");
                weatherService.saveActualWeatherInAllCity();
            } catch (Exception e) {
                LOGGER.error("saveActualWeather - ERROR!", e);
            } finally {
                LOGGER.debug("saveActualWeather - save was ended");
                isSaveActualWeatherEnabled.set(false);
            }
        } else {
            LOGGER.debug("saveActualWeather - process already started");
        }
    }
}
