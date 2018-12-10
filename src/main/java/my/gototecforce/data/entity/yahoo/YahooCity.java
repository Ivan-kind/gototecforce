package my.gototecforce.data.entity.yahoo;

import my.gototecforce.data.entity.City;

import javax.persistence.*;

@Entity
@Table(name = "YAHOO_CITY")
public class YahooCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "CODE")
    private String code;

    @OneToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="city_id")
    private City city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "YahooCity{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", city=" + city +
                '}';
    }
}
