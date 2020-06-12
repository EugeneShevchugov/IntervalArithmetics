//package Interval;
//
//import exceptions.IllegalIntervalException;
//import exceptions.ZeroDivisionException;
//import operations.Interval;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class SimpleIntervalTest {
//    SimpleInterval f_interval;
//    SimpleInterval s_interval;
//    {
//        try {
//            f_interval = new SimpleInterval(10, 20);
//            s_interval = new SimpleInterval(20, 30);
//        } catch (IllegalIntervalException e) {
//            e.printStackTrace();
//        }
//    }
//    @Test
//    public void sumWithInterval() throws IllegalIntervalException {
//        Interval test = f_interval.plus(s_interval);
//        assertEquals(test, new SimpleInterval(30, 50));
//    }
//
//    @Test
//    public void sumWithNumber() throws IllegalIntervalException {
//        Interval test = f_interval.plus(50);
//        assertEquals(test, new SimpleInterval(60, 70));
//    }
//
//    @Test
//    public void minusWithInterval() throws IllegalIntervalException {
//        Interval test = f_interval.minus(s_interval);
//        assertEquals(test, new SimpleInterval(-20,0));
//    }
//
//    @Test
//    public void minusWithNumber() throws IllegalIntervalException {
//        Interval test = f_interval.minus(10);
//        assertEquals(test, new SimpleInterval(0, 10));
//    }
//
//    @Test
//    public void multiplyWithInterval() throws IllegalIntervalException {
//        Interval test = f_interval.multiply(s_interval);
//        assertEquals(test, new SimpleInterval(200, 600));
//    }
//
//    @Test
//    public void multiplyWithNumber() throws IllegalIntervalException {
//        Interval test = f_interval.multiply(5);
//        assertEquals(test, new SimpleInterval(50, 100));
//    }
//
//    @Test
//    public void divisionWithInterval() throws IllegalIntervalException, ZeroDivisionException {
//        Interval test = f_interval.division(s_interval);
//        assertEquals(test, new SimpleInterval(0.333, 1));
//    }
//
//    @Test
//    public void divisionWithNumber() {
//        try {
//            Interval test = f_interval.division(5);
//            assertEquals(test, new SimpleInterval(2, 4));
//        } catch (ZeroDivisionException | IllegalIntervalException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void middleTest() {
//        assertEquals(15, f_interval.middle());
//    }
//
//    @Test
//    public void widthTest() {
//        assertEquals(10, f_interval.width());
//    }
//
//    @Test
//    public void radiusTest() {
//        assertEquals(5, f_interval.radius());
//    }
//
//    @Test
//    public void magnitudeTest() {
//        assertEquals(20, f_interval.magnitude());
//    }
//
//    @Test
//    public void mignitudeTest() {
//        assertEquals(10, f_interval.mignitude());
//    }
//
//    @Test
//    public void deviationTest() {
//        assertEquals(20, f_interval.deviation());
//    }
//}