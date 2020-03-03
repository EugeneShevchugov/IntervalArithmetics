package StandartOperations.Plus;

import StandartOperations.AnyOperation;
import StandartOperations.Interval;

public class Plus implements AnyOperation {
    private Interval interval;

    @Override
    public String operation(Interval a) {
        this.interval = a;
        return "[" + (a.getA() + a.getC()) + "," + (a.getB() + a.getD()) + "]";
    }
}
