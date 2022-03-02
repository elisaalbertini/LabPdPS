import lab01.tdd.SelectStrategy;
import lab01.tdd.StrategyFactory;
import lab01.tdd.StrategyFactoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MultipleOfStrategyTest extends AbstractCircularListTest{
    public static final int NUMBER = 3;
    private SelectStrategy strategy;

    @BeforeEach
    public void beforeEach() {
        super.beforeEach();
        StrategyFactory strategyFactory = new StrategyFactoryImplementation();
        this.strategy = strategyFactory.createMultipleOfStrategy(NUMBER);
    }

    @Test
    public void testMultipleOfStrategyWithOneElementMatchingTheStrategy() {
        this.addToList(List.of(4, 5, 6));

        Optional<Integer> optional = this.list.next(this.strategy);
        assertTrue(optional.isPresent() && optional.get().equals(6));
    }

    @Test
    public void testMultipleOfStrategyWithMoreElementsMatchingTheStrategy() {
       this.addToList(List.of(6, 7, 8, 9));

        this.list.next(this.strategy);
        Optional<Integer> optional = this.list.next(this.strategy);
        assertTrue(optional.isPresent() && optional.get().equals(9));
    }

    @Test
    public void testMultipleOfStrategyAndListCircularityWithMoreElementsMatchingTheStrategy() {
        this.addToList(List.of(6, 7, 8, 9));

        this.list.next(this.strategy);
        this.list.next(this.strategy);
        Optional<Integer> optional = this.list.next(this.strategy);
        assertTrue(optional.isPresent() && optional.get().equals(6));
    }

    @Test
    public void WithNoElementMatchingTheStrategy() {
        this.addToList(List.of(1, 2, 4));

        Optional<Integer> optional = this.list.next(this.strategy);
        assertFalse(optional.isPresent());
    }
}
