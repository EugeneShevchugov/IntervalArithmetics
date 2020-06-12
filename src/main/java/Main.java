import exceptions.IllegalIntervalException;
import exceptions.ZeroDivisionException;
import operations.Interval;
import Interval.KahanInterval;

public class Main {
    public static void main(String[] args) throws ZeroDivisionException, IllegalIntervalException {
        Interval interval = new KahanInterval(-10, 200);
        Interval interval1 = new KahanInterval(-10, 20);
        Interval div = interval.division(interval1);
        System.out.println(div);
    }
}
