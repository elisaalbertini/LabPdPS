package lab01.tdd;

/**
 * Rapresent an abstract factory of different strategy
 */
public interface StrategyFactory {

    /**
     * Strategy to get the next even element
     *
     * @return the strategy
     */
    SelectStrategy createEvenStrategy();

    /**
     * Strategy to get the next multiple of a given number
     *
     * @param number to use inside the strategy
     * @return the strategy
     */
    SelectStrategy createMultipleOfStrategy(int number);

    /**
     * Strategy  to get the next equal element of a given one
     *
     * @param number to use inside the strategy
     * @return the strategy
     */
    SelectStrategy createEqualsStrategy(int number);
}
