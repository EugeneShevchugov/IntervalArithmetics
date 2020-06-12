package exceptions;

public class IllegalIntervalException extends Exception {
    public IllegalIntervalException() {
        System.out.println("Некорректный интервал");
    }
}
