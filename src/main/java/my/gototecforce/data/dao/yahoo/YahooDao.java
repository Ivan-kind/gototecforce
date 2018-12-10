package my.gototecforce.data.dao.yahoo;

import my.gototecforce.data.entity.City;
import my.gototecforce.data.entity.yahoo.YahooCity;

public interface YahooDao {

    /**
     * Method that find YahooCity by common City
     *
     * @param city common city
     * @return yahoo city
     */
    public YahooCity getYahooCityByCommonCity(City city);
}
