import lab01.tdd.SelectStrategy;
import lab01.tdd.StrategyFactory;
import lab01.tdd.StrategyFactoryImplementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenStrategyTest extends AbstractCircularListTest{
    private SelectStrategy strategy;

    @BeforeEach
    public void beforeEach() {
        super.beforeEach();
        StrategyFactory strategyFactory = new StrategyFactoryImplementation();
        this.strategy = strategyFactory.createEvenStrategy();
    }

    @Test
    public void testEvenStrategyWithOneElementMatchingTheStrategy() {
        this.addToList(List.of(1, 2, 3));

        Optional<Integer> optional = this.list.next(this.strategy);
        assertTrue(optional.isPresent() && optional.get().equals(2));
    }

    @Test
    public void testEvenStrategyWithMoreElementsMatchingTheStrategy() {
        this.addToList(List.of(1, 2, 3, 4));

        this.list.next(this.strategy);
        Optional<Integer> optional = this.list.next(this.strategy);
        assertTrue(optional.isPresent() && optional.get().equals(4));
    }

    @Test
    public void testEvenStrategyAndListCircularityWithMoreElementsMatchingTheStrategy() {
        this.addToList(List.of(1, 2, 3, 4));

        this.list.next(this.strategy);
        this.list.next(this.strategy);
        Optional<Integer> optional = this.list.next(this.strategy);
        assertTrue(optional.isPresent() && optional.get().equals(2));
    }


    @Test
    public void testEvenStrategyWithNoElementMatchingTheStrategy() {
        this.addToList(List.of(1, 3, 5));

        Optional<Integer> optional = this.list.next(this.strategy);
        assertFalse(optional.isPresent());
    }
}
