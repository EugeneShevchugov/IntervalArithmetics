package Interval;

import exceptions.IllegalIntervalException;
import exceptions.ZeroDivisionException;
import operations.Interval;
import operations.Ceiling;
import types.Type;

import java.io.Serializable;
import java.util.Objects;

/**
 * Простой интервал
 *
 * @author Evgeny Shevchugov.
 * @implements Interval, Serializable
 */

public class SimpleInterval implements Interval, Serializable {
    private final double from;
    private final double to;

    /**
     * Базовый Конструктор интервала
     *
     * @param from - левая граница
     * @param to   - правая граница
     * @author Evgeny Shevchugov.
     */
    public SimpleInterval(double from, double to) throws IllegalIntervalException {
        if (from > to) {
            throw new IllegalIntervalException();
        }
        this.from = from;
        this.to = to;
    }

    @Override
    public double getFrom() {
        return from;
    }

    @Override
    public double getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "[" + from + "," + to + "]";
    }

    private String chooseType() {
        if (from >= 0 && to >= 0) {
            return String.valueOf(Type.NON_NEGATIVE_INTERVAL);
        }
        if (from <= 0 && to <= 0) {
            return String.valueOf(Type.ZERO_CONTAINS_INTERVAL);
        }
        if (middle() == 0) {
            return String.valueOf(Type.BALANCED);
        }
        return "Error";
    }

    /**
     * Метод получения типа
     *
     * @return String
     */
    @Override
    public String getType() {
        return this.getClass().getName() + "." + chooseType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleInterval interval = (SimpleInterval) o;
        return Double.compare(interval.from, from) == 0 &&
                Double.compare(interval.to, to) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public Interval plus(Interval b) throws IllegalIntervalException {
        return new SimpleInterval(Ceiling.ceil(this.getFrom() + b.getFrom()), Ceiling.ceil(this.getTo() + b.getTo()));
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public Interval plus(double number) throws IllegalIntervalException {
        return new SimpleInterval(Ceiling.ceil(this.getFrom() + number), Ceiling.ceil(this.getTo() + number));
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public Interval minus(Interval b) throws IllegalIntervalException {
        return new SimpleInterval(Ceiling.ceil(this.getFrom() - b.getTo()), Ceiling.ceil(this.getTo() - b.getFrom()));
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public Interval minus(double number) throws IllegalIntervalException {
        return new SimpleInterval(Ceiling.ceil(this.getFrom() - number), Ceiling.ceil(this.getTo() - number));
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public Interval multiply(Interval b) throws IllegalIntervalException {
        Interval f = this.multiply(b.getFrom());
        Interval s = this.multiply(b.getTo());
        return new SimpleInterval(Ceiling.ceil(Math.min(f.getFrom(), s.getFrom())), Ceiling.ceil(Math.max(f.getTo(), s.getTo())));
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public Interval multiply(double number) throws IllegalIntervalException {
        double f = this.getFrom() * number;
        double s = this.getTo() * number;
        return new SimpleInterval(Ceiling.ceil(Math.min(f, s)), Ceiling.ceil(Math.max(f, s)));
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public Interval division(Interval b) throws ZeroDivisionException, IllegalIntervalException {
        if (b.getFrom() == 0 || b.getTo() == 0) throw new ZeroDivisionException("Деление границы интервала на 0");
        Interval f = this.division(b.getFrom());
        Interval s = this.division(b.getTo());
        return new SimpleInterval(Ceiling.ceil(Math.min(f.getFrom(), s.getFrom())), Ceiling.ceil(Math.max(f.getTo(), s.getTo())));
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public Interval division(double number) throws ZeroDivisionException, IllegalIntervalException {
        if (number == 0) throw new ZeroDivisionException("Деление границы интервала на 0");
        double f = this.getFrom() / number;
        double s = this.getTo() / number;
        return new SimpleInterval(Ceiling.ceil(Math.min(f, s)), Ceiling.ceil(Math.max(f, s)));
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public double middle() {
        return 0.5 * (this.getTo() + this.getFrom());
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public double width() {
        return (this.getTo() - this.getFrom());
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public double radius() {
        return 0.5 * (this.getTo() - this.getFrom());
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public double magnitude() {
        return Math.max(Math.abs(this.getFrom()), Math.abs(this.getTo()));
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public double mignitude() {
        return Math.min(Math.abs(this.getFrom()), Math.abs(this.getTo()));
    }

    /**
     * @author Evgeny Shevchugov.
     * @see Interval
     */
    @Override
    public double deviation() {
        return Math.abs(Math.max(this.getFrom(), this.getTo()));
    }

}
