package lab01.tdd;

public class EqualsStrategy implements SelectStrategy {

    private final int number;

    public EqualsStrategy(int number) {
        this.number = number;
    }

    @Override
    public boolean apply(int element) {
        return element == this.number;
    }
}
