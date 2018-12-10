package my.gototecforce.data.dao.impl;

import my.gototecforce.data.dao.CityDao;
import my.gototecforce.data.entity.City;
import my.gototecforce.utils.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CityDaoImpl implements CityDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityDaoImpl.class);

    @Override
    public City getCityByName(String cityName) {
        LOGGER.trace("getCiteByName - start cityName : {}", cityName);
        if (Objects.isNull(cityName)) return null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("from City where name=:cityName");
            query.setString("cityName", cityName);
            City city = (City) query.uniqueResult();
            LOGGER.debug("getCityByName - found city : {}", city);
            return city;
        }
    }

    @Override
    public List<City> getAllCities() {
        LOGGER.trace("getAllCities - start");
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("from City");
            List<City> cities = query.list();
            LOGGER.debug("getCityByName - found cities : {}", cities);
            return cities;
        }
    }
}
