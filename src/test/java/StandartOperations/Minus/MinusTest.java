package StandartOperations.Minus;

import StandartOperations.Interval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinusTest {
    public Interval interval = new Interval(15,10,20,30);

    @Test
    public void funMinus() {
        Minus minus = new Minus();
        assertEquals(minus.operation(interval), "[-5,-20]");
    }

}