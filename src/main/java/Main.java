import exceptions.IllegalIntervalException;
import exceptions.ZeroDivisionException;
import operations.Interval;
import Interval.SimpleInterval;

public class Main {
    public static void main(String[] args) throws ZeroDivisionException, IllegalIntervalException {
        Interval interval = new SimpleInterval(1, 2);
        Interval interval1 = new SimpleInterval(-2, -1);
        Interval div = interval.division(interval1);
        System.out.println(div);
    }
}
