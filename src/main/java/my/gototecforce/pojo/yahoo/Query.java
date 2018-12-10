package my.gototecforce.pojo.yahoo;

import java.sql.Timestamp;

public class Query {

    private int count;
    private Timestamp created;
    private String lang;
    private Results results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Query{" +
                "count=" + count +
                ", created=" + created +
                ", lang='" + lang + '\'' +
                ", results=" + results +
                '}';
    }
}
