package my.gototecforce.pojo.yahoo;

public class Wind {

    private String chill;
    private String dirrection;
    private String speed;

    public String getChill() {
        return chill;
    }

    public void setChill(String chill) {
        this.chill = chill;
    }

    public String getDirrection() {
        return dirrection;
    }

    public void setDirrection(String dirrection) {
        this.dirrection = dirrection;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "chill='" + chill + '\'' +
                ", dirrection='" + dirrection + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }
}
