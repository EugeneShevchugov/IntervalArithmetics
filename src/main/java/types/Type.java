package types;

/**
 * Определение типа интервала.
 * - NON_NEGATIVE_INTERVAL - если from >= 0 и to >= 0
 * - ZERO_CONTAINS_INTERVAL - если from <= 0 <= to
 * - BALANCED - если from = -to или mid = 0
 * @author Evgeny Shevchugov.
 */
public enum Type {
    NON_NEGATIVE_INTERVAL,
    ZERO_CONTAINS_INTERVAL,
    BALANCED
}
