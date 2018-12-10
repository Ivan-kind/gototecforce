package my.gototecforce.pojo.yahoo;

public class Channel {

    private Units units;
    private String title;
    private String link;
    private String language;
    private String ttl;
    private Location location;
    private Wind wind;
    private Atmosphere atmosphere;
    private Item item;

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "units=" + units +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", language='" + language + '\'' +
                ", ttl='" + ttl + '\'' +
                ", location=" + location +
                ", wind=" + wind +
                ", atmosphere=" + atmosphere +
                ", item=" + item +
                '}';
    }
}