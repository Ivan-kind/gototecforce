package my.gototecforce.client;

import feign.Param;
import feign.RequestLine;
import my.gototecforce.pojo.yahoo.YahooResponse;

public interface YahooWetherClient {

    @RequestLine("GET /public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22{cityName}%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    public YahooResponse getWeatherFromCity(@Param("cityName") String cityName);
}
