package Interval;

import exceptions.IllegalIntervalException;
import operations.Ceiling;
import operations.Interval;

public class KahanInterval extends SimpleInterval {
    public KahanInterval(double from, double to) throws IllegalIntervalException {
        super(from, to);
    }

    @Override
    public Interval division(Interval b) throws IllegalIntervalException {
        if (this.getTo() < 0 && (b.getTo() == 0 && b.getFrom() < b.getTo())) {
            return new KahanInterval(this.getTo() / b.getFrom(), Double.POSITIVE_INFINITY);
        }
        if (this.getTo() < 0 && (b.getFrom() == 0 && b.getFrom() < b.getTo())) {
            return new KahanInterval(Double.NEGATIVE_INFINITY, this.getTo() / b.getTo());
        }
        if (this.getFrom() > 0 && (b.getTo() == 0 && b.getFrom() < b.getTo())) {
            return new KahanInterval(Double.NEGATIVE_INFINITY, this.getFrom() / b.getFrom());
        }
        if (this.getFrom() > 0 && (b.getFrom() == 0 && b.getFrom() < b.getTo())) {
            return new KahanInterval(this.getFrom() / b.getTo(), Double.POSITIVE_INFINITY);
        }
        if (!isContainsZero(this) && (b.getFrom() == 0 && b.getTo() == 0)) {
            return new KahanInterval(Double.NaN, Double.NaN);
        }
        if (!isContainsZero(b)) {
            double f = 1 / this.getTo();
            double s = 1 / b.getTo();
            b = new KahanInterval(Ceiling.ceil(Math.min(f, s)), Ceiling.ceil(Math.max(f, s)));
            return new KahanInterval(this.getFrom(), this.getTo()).multiply(b);
        }
        if (isContainsZero(this) && isContainsZero(b)) {
            return new KahanInterval(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
        }
        throw new IllegalIntervalException();
    }

    private boolean isContainsZero(Interval interval) {
        return 0 > interval.getFrom() && 0 < interval.getTo();
    }
}
