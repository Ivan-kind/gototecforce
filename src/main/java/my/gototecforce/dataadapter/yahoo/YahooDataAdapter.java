package my.gototecforce.dataadapter.yahoo;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import my.gototecforce.client.YahooWetherClient;
import my.gototecforce.data.dao.yahoo.YahooDao;
import my.gototecforce.data.entity.City;
import my.gototecforce.data.entity.Weather;
import my.gototecforce.data.entity.yahoo.YahooCity;
import my.gototecforce.dataadapter.DataAdapter;
import my.gototecforce.pojo.yahoo.Channel;
import my.gototecforce.pojo.yahoo.YahooResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class YahooDataAdapter implements DataAdapter {

    private static  final Logger LOGGER = LoggerFactory.getLogger(YahooDataAdapter.class);

    private final YahooDao yahooDao;
    private final YahooWetherClient yahooWetherClient;

    @Autowired
    public YahooDataAdapter(YahooDao yahooDao) {
        this.yahooDao = yahooDao;
        this.yahooWetherClient = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .logLevel(feign.Logger.Level.FULL)
                .target(YahooWetherClient.class, "https://query.yahooapis.com/v1/");
    }

    @Override
    public Weather getActualWeatherInCity(City city) {
        LOGGER.trace("getActualWeatherInCity - start city : {}", city);
        if (Objects.isNull(city)) return null;
        YahooCity yahooCity = yahooDao.getYahooCityByCommonCity(city);
        LOGGER.debug("getActualWeatherInCity - yahooCity : {}", yahooCity);
        YahooResponse yahooResponse = yahooWetherClient.getWeatherFromCity(yahooCity.getCode());
        Weather weather = new Weather();
        weather.setCity(city);
        Channel channel = yahooResponse.getQuery()
                .getResults()
                .getChannel();
        weather.setWindSpeed(Double.parseDouble(channel.getWind().getSpeed()));
        weather.setTemperature(Double.parseDouble(channel.getItem().getCondition().getTemp()));
        LOGGER.debug("getActualWeatherInCity - find weather : {}", weather);
        return weather;
    }
}
