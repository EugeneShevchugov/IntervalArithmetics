package Interval;

import exceptions.IllegalIntervalException;
import exceptions.ZeroDivisionException;
import operations.Interval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleIntervalTest {
    @Test
    public void arithmeticNumbersTest() throws IllegalIntervalException, ZeroDivisionException {
        Interval a = new SimpleInterval(5, 10);
        assertEquals(a.plus(5), new SimpleInterval(10, 15));
        assertEquals(a.minus(5), new SimpleInterval(0, 5));
        assertEquals(a.multiply(5), new SimpleInterval(25, 50));
        assertEquals(a.division(5), new SimpleInterval(1, 2));
    }

    @Test
    public void characteristicOpsTest() throws IllegalIntervalException {
        Interval a = new SimpleInterval(5, 10);
        assertEquals(a.middle(), 7.5);
        assertEquals(a.width(), 5);
        assertEquals(a.radius(), 2.5);
        assertEquals(a.magnitude(), 10);
        assertEquals(a.mignitude(), 5);
        assertEquals(a.deviation(), 10);
    }

    @Test
    public void typeTest() throws IllegalIntervalException {
        Interval a = new SimpleInterval(5, 10);
        assertEquals(a.getType(), SimpleInterval.class.getName() + "." + "NON_NEGATIVE_INTERVAL");
        a = new SimpleInterval(-5, 0);
        assertEquals(a.getType(), SimpleInterval.class.getName() + "." + "ZERO_CONTAINS_INTERVAL");
        a = new SimpleInterval(-5, 5);
        assertEquals(a.getType(), SimpleInterval.class.getName() + "." + "BALANCED");
    }

    @Test
    public void intervalOpsTest() throws IllegalIntervalException, ZeroDivisionException {
        Interval a = new SimpleInterval(5, 10);
        Interval b = new SimpleInterval(15, 40);
        assertEquals(a.plus(b), new SimpleInterval(20, 50));
        assertEquals(a.minus(b), new SimpleInterval(-35, -5));
        assertEquals(a.multiply(b), new SimpleInterval(75, 400));
        assertEquals(a.division(b), new SimpleInterval(0.125, 0.667));
    }
}