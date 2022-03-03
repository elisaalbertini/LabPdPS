import lab01.tdd.SelectStrategy;
import lab01.tdd.StrategyFactory;
import lab01.tdd.StrategyFactoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the EqualsStrategy
 */
public class EqualsStrategyTest extends AbstractCircularListTest {
    public static final int NUMBER = 3;
    private SelectStrategy strategy;

    @BeforeEach
    public void beforeEach() {
        super.beforeEach();
        StrategyFactory strategyFactory = new StrategyFactoryImplementation();
        this.strategy = strategyFactory.createEqualsStrategy(NUMBER);
    }

    @Test
    public void testEqualsStrategyWithOneElementMatchingTheStrategy() {
        this.addToList(List.of(1, 2, 3));

        Optional<Integer> optional = this.list.next(strategy);
        assertTrue(optional.isPresent() && optional.get().equals(3));
    }

    @Test
    public void testEqualsStrategyWithMoreElementsMatchingTheStrategy() {
        this.addToList(List.of(1, 2, 3, 3, 4));

        this.list.next(strategy);
        this.list.next(strategy);
        Optional<Integer> optional = this.list.next();
        assertTrue(optional.isPresent() && optional.get().equals(4));
    }

    @Test
    public void testEqualsStrategyAndListCircularityWithMoreElementsMatchingTheStrategy() {
        this.addToList(List.of(1, 2, 3, 4, 3));

        this.list.next(strategy);
        this.list.next(strategy);
        this.list.next(strategy);
        Optional<Integer> optional = this.list.next();
        assertTrue(optional.isPresent() && optional.get().equals(4));
    }

    @Test
    public void testEqualsStrategyWithNoElementMatchingTheStrategy() {
        this.addToList(List.of(1, 2, 4));

        Optional<Integer> optional = this.list.next(strategy);
        assertFalse(optional.isPresent());
    }
}
