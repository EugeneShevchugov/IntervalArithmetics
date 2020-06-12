package exceptions;

/**
 * ZeroDivisionException выбрасывается в том случае, когда:
 * - Происходит деление на 0 обеих границ интервала
 * - Происходит деление границы на границу, и делитель = 0
 * @author Evgeny Shevchugov.
 */
public class ZeroDivisionException extends Exception {
    public ZeroDivisionException(String s) {
        super(s);
    }
}
