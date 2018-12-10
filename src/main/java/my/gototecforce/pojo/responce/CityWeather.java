package my.gototecforce.pojo.responce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import my.gototecforce.data.entity.Weather;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

public class CityWeather {

    private String city;
    private double temperature;
    private double windSpeed;
    private Timestamp date;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @JsonIgnore
    public static CityWeather createByWeatherObj(@NotNull Weather weather) {
        CityWeather cityWeather = new CityWeather();
        cityWeather.setCity(weather.getCity().getName());
        cityWeather.setDate(weather.getCreatedAt());
        cityWeather.setTemperature(weather.getTemperature());
        cityWeather.setWindSpeed(weather.getWindSpeed());
        return cityWeather;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityWeather that = (CityWeather) o;
        return Double.compare(that.temperature, temperature) == 0 &&
                Double.compare(that.windSpeed, windSpeed) == 0 &&
                Objects.equals(city, that.city) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(city, temperature, windSpeed, date);
    }

    @Override
    public String toString() {
        return "CityWeather{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", date=" + date +
                '}';
    }
}
