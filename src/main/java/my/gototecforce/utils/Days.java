package my.gototecforce.utils;

public class Days {

    private long from;
    private long to;

    public Days(long timeTo, long daysCnt) {
        this.to = timeTo;
        this.from = timeTo - (daysCnt * 24 * 60 * 60 * 1000);
    }

    public long getFrom() {
        return from;
    }

    public long getTo() {
        return to;
    }
}
