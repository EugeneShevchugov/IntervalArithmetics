package StandartOperations.Minus;

import StandartOperations.AnyOperation;
import StandartOperations.Interval;

public class Minus implements AnyOperation {
    private Interval interval;

    @Override
    public String operation(Interval a) {
        return "[" + (a.getA() - a.getC()) + "," + (a.getB() - a.getD()) + "]";
    }
}
