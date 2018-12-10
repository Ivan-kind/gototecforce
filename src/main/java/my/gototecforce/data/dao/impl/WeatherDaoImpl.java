package my.gototecforce.data.dao.impl;

import my.gototecforce.data.dao.WeatherDao;
import my.gototecforce.data.entity.City;
import my.gototecforce.data.entity.Weather;
import my.gototecforce.utils.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
public class WeatherDaoImpl implements WeatherDao {

    private final static Logger LOGGER = LoggerFactory.getLogger(WeatherDaoImpl.class);

    @Override
    public List<Weather> getWeatherInCityByTime(Timestamp timeFrom, Timestamp timeTo, City city) {
        LOGGER.trace("getWeatherInCityByTime - start city : {}", city);
        if (Objects.isNull(city) || Objects.isNull(timeFrom) || Objects.isNull(timeTo)) return null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("from Weather where city_id=:cityId and created_at>=:timeFrom and created_at<=:timeTo");
            query.setTimestamp("timeFrom", timeFrom);
            query.setTimestamp("timeTo", timeTo);
            query.setLong("cityId", city.getId());
            List<Weather> weather = query.list();
            LOGGER.debug("getWeatherInCityByTime - weather : {} city : {}", weather, city);
            return weather;
        }
    }

    @Override
    public Weather getActualWeatherInCity(City city) {
        LOGGER.trace("getActualWeatherInCity - start city : {}", city);
        if (Objects.isNull(city)) return null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            SQLQuery sqlQuery = session.createSQLQuery("select w.id, w.temperature, w.wind_speed, w.created_at, c.id as city_id, c.name " +
                    "from weather w join city c on c.id = w.city_id " +
                    "where c.id = :cityId " +
                    "order by w.created_at DESC");
            sqlQuery.setLong("cityId", city.getId());
            List<Object[]> rows = sqlQuery.list();
            if (Objects.isNull(rows) || rows.isEmpty()) {
                LOGGER.warn("getActualWeatherInCity - cannot find weather of city : {}", city);
            }
            Object[] row = rows.get(0);
            Weather weather = new Weather();
            weather.setId(Long.parseLong(row[0].toString()));
            weather.setTemperature(Double.parseDouble(row[1].toString()));
            weather.setWindSpeed(Double.parseDouble(row[2].toString()));
            weather.setCreatedAt((Timestamp) row[3]);
            weather.setCity(city);
            LOGGER.debug("getActualWeatherInCity - actualWeather : {} city : {}", weather, city);
            return weather;
        }
    }

    @Override
    public void saveWeather(Weather weather) {
        LOGGER.trace("saveWeather - start weather : {}", weather);
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.save(weather);
        }
    }
}
