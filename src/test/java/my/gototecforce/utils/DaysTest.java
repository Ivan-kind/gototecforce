package my.gototecforce.utils;

import org.junit.Assert;
import org.junit.Test;

public class DaysTest {

    @Test
    public void test() {
        long testDaysCnt = 7;
        long testTimeTo = System.currentTimeMillis();

        Days days = new Days(testTimeTo, testDaysCnt);
        Assert.assertEquals(testTimeTo, days.getTo());
        Assert.assertEquals(testTimeTo - (testDaysCnt * 24 * 60 * 60 * 1000), days.getFrom());
    }
}
