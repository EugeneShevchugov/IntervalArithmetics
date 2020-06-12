package operations;

import exceptions.IllegalIntervalException;
import exceptions.ZeroDivisionException;

/**
 * Базовый интерфейс для интервала любого типа
 * @throws ZeroDivisionException, если
 * - Граница-делитель = 0
 * - Происходит деление границ(ы) интервала на 0
 * @author Evgeny Shevchugov.
 */
public interface Interval {
    double getFrom();
    double getTo();
    /**
     * Метод возвращает тип интервала
     * @return String
     * @author Evgeny Shevchugov.
     */
    String getType();

    /**
     * Выполняет сложение интервала по определенной формуле
     * @param b - Интервал любого типа
     * @return Interval
     * @author Evgeny Shevchugov.
     */
    Interval plus(Interval b) throws IllegalIntervalException;

    /**
     * Выполняет сложение интервала с числом по принципу : from + number, to + number
     * @param number - число для сложения
     * @return double
     * @author Evgeny Shevchugov.
     */
    Interval plus(double number) throws IllegalIntervalException;

    /**
     * Выполняет вычитание интервала по определенной формуле
     * @param b - Интервал любого типа
     * @return Interval
     * @author Evgeny Shevchugov.
     */
    Interval minus(Interval b) throws IllegalIntervalException;

    /**
     * Выполняет вычитание интервала с числом по принципу : from - number, to - number
     * @param number - число для вычитания
     * @return double
     * @author Evgeny Shevchugov.
     */
    Interval minus(double number) throws IllegalIntervalException;

    /**
     * Выполняет умножения интервала по определенной формуле
     * @param b - Интервал любого типа
     * @return Interval
     * @author Evgeny Shevchugov.
     */
    Interval multiply(Interval b) throws IllegalIntervalException;

    /**
     * Выполняет умножения интервала с числом по принципу : from * number, to * number
     * @param number - число для умножения
     * @return double
     * @author Evgeny Shevchugov.
     */
    Interval multiply(double number) throws IllegalIntervalException;

    /**
     * Выполняет вычитание интервала по определенной формуле
     * @param b - Интервал любого типа
     * @return Interval
     * @throws ZeroDivisionException при неверном аргументе(0)
     * @author Evgeny Shevchugov.
     */
    Interval division(Interval b) throws ZeroDivisionException, IllegalIntervalException;

    /**
     * Выполняет деление интервала с числом по принципу : from / number, to / number
     * Число не должно быть 0
     * @param number - число для деления
     * @return double
     * @throws ZeroDivisionException при неверном аргументе(0)
     * @author Evgeny Shevchugov.
     */
    Interval division(double number) throws ZeroDivisionException, IllegalIntervalException;

    /**
     * Метод нахождения середины интервала
     * @return double
     * @author Evgeny Shevchugov.
     */
    double middle();

    /**
     * Метод нахождения ширины интервала
     * @return double
     * @author Evgeny Shevchugov.
     */
    double width();

    /**
     * Метод нахождения радиуса интервала
     * @return double
     * @author Evgeny Shevchugov.
     */
    double radius();

    /**
     * Метод нахождения магнитуды интервала
     * @return double
     * @author Evgeny Shevchugov.
     */
    double magnitude();

    /**
     * Метод нахождения мигнитуды интервала
     * @return double
     * @author Evgeny Shevchugov.
     */
    double mignitude();

    /**
     * Метод нахождения девиации интервала
     * @return double
     * @author Evgeny Shevchugov.
     */
    double deviation();
}
