package lab01.tdd;

public class MultipleOfStrategy implements SelectStrategy {

    private final int number;

    public MultipleOfStrategy(int number) {
        this.number = number;
    }

    @Override
    public boolean apply(int element) {
        return element % this.number == 0;
    }
}
