package my.gototecforce.pojo.yahoo;

public class Atmosphere {

    private String humidity;
    private String pressure;
    private String rising;
    private String visibility;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getRising() {
        return rising;
    }

    public void setRising(String rising) {
        this.rising = rising;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "Atmosphere{" +
                "humidity='" + humidity + '\'' +
                ", pressure='" + pressure + '\'' +
                ", rising='" + rising + '\'' +
                ", visibility='" + visibility + '\'' +
                '}';
    }
}