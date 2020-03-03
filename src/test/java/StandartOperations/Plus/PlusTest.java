package StandartOperations.Plus;

import StandartOperations.Interval;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlusTest {
    public Interval interval = new Interval(15,15,15,15);
    @Test
    public void funPlus() {
        Plus plus = new Plus();
        assertEquals(plus.operation(interval), "[30,30]");
    }

}