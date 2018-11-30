package my.gototecforce.client;

import feign.Param;
import feign.RequestLine;

public interface YahooWetherClient {

    @RequestLine("GET /public/yql?q={query}")
    public Object getWeatherFromCity(@Param("query") String query);
}
