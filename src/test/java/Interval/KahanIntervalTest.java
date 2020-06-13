package Interval;

import exceptions.IllegalIntervalException;
import exceptions.ZeroDivisionException;
import operations.Interval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KahanIntervalTest {
    @Test
    public void divisionKahanTest() throws ZeroDivisionException, IllegalIntervalException {
        Interval a = new KahanInterval(-6, -5);
        Interval b = new KahanInterval(-1, 0);
        assertEquals(a.division(b), new KahanInterval(5, Double.POSITIVE_INFINITY));
        a = new KahanInterval(-6, -5);
        b = new KahanInterval(0, 1);
        assertEquals(a.division(b), new KahanInterval(Double.NEGATIVE_INFINITY, -5));
        a = new KahanInterval(1, 2);
        b = new KahanInterval(-1, 0);
        assertEquals(a.division(b), new KahanInterval(Double.NEGATIVE_INFINITY, -1));
        a = new KahanInterval(1, 2);
        b = new KahanInterval(0, 2);
        assertEquals(a.division(b), new KahanInterval(0.5, Double.POSITIVE_INFINITY));
        a = new KahanInterval(1, 2);
        b = new KahanInterval(0, 0);
        assertEquals(a.division(b), new KahanInterval(Double.NaN, Double.NaN));
        a = new KahanInterval(1, 2);
        b = new KahanInterval(1, 2);
        assertEquals(a.division(b), new KahanInterval(0.5, 1));
        a = new KahanInterval(-5, 5);
        b = new KahanInterval(-6, 6);
        assertEquals(a.division(b), new KahanInterval(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
    }
}
