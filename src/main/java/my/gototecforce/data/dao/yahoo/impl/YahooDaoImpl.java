package my.gototecforce.data.dao.yahoo.impl;

import my.gototecforce.data.dao.yahoo.YahooDao;
import my.gototecforce.data.entity.City;
import my.gototecforce.data.entity.yahoo.YahooCity;
import my.gototecforce.utils.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class YahooDaoImpl implements YahooDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(YahooDaoImpl.class);

    @Override
    public YahooCity getYahooCityByCommonCity(City city) {
        LOGGER.trace("getYahooCityByCommonCity - start city : {}", city);
        if (Objects.isNull(city)) return null;
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Query query = session.createQuery("from YahooCity where city_id=:cityId");
            query.setLong("cityId", city.getId());
            YahooCity yahooCity = (YahooCity) query.uniqueResult();
            LOGGER.debug("getYahooCityByCommonCity - find yahooCity : {} city : {}", yahooCity, city);
            return yahooCity;
        }
    }
}
