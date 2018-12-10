package my.gototecforce.data.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "WEATHER")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "TEMPERATURE")
    private double temperature;

    @Column(name = "WIND_SPEED")
    private double windSpeed;

    @Column(name = "CREATED_AT")
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="city_id")
    private City city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", createdAt=" + createdAt +
                ", city=" + city +
                '}';
    }
}
