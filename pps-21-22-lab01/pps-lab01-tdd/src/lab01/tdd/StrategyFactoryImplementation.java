package lab01.tdd;

public final class StrategyFactoryImplementation implements StrategyFactory{

    @Override
    public SelectStrategy createEvenStrategy() {
        return new EvenStrategy() ;
    }

    @Override
    public SelectStrategy createMultipleOfStrategy(int number) {
        return new MultipleOfStrategy(number);
    }

    @Override
    public SelectStrategy createEqualsStrategy(int number) {
        return new EqualsStrategy(number);
    }
}
