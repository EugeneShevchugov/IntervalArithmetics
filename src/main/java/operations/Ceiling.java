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
        int i = (int) Math.round(x);
        x = (double) i / 1000;
        return x;
    }
}
