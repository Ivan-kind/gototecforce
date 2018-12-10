package my.gototecforce.pojo.yahoo;

import my.gototecforce.pojo.yahoo.Query;

public class YahooResponse {

    private Query query;

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "YahooResponse{" +
                "query=" + query +
                '}';
    }
}
