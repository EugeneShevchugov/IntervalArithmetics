package operations;

/**
 * Класс для округления интервала до сотых.
 * @author Evgeny Shevchugov.
 */
public class Ceiling {
    private Ceiling() {
    }

    public static double ceil(double x) {
        x = x * 1000;
        double i = Math.round(x);
        x = i / 1000;
        return x;
    }
}
