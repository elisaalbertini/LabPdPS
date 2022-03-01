import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private SimpleCircularList list;

    @BeforeEach
    public void beforeEach() {
        this.list = new SimpleCircularList();
    }

    @Test public void testIsInitiallyEmpty(){
        assertTrue(this.list.isEmpty());
        assertEquals(0,this.list.size());
    }

    @Test public void testFirstAdd(){
        this.list.add(1);
        assertFalse(this.list.isEmpty());
        assertEquals(1, this.list.size());
    }

    @Test public void testMultipleAdds(){
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        assertEquals(3, this.list.size());
    }

    @Test public void testNext(){
        assertEquals(Optional.empty(), this.list.next());
        Optional<Integer> emptyOptional = this.list.next();
        assertFalse(emptyOptional.isPresent());

        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        for (int i : new int[]{1, 2, 3, 1}) {
            Optional<Integer> optional = this.list.next();
            assertTrue(optional.isPresent());
            assertEquals(i, optional.get());
        }
    }

    @Test public void testPrevious(){
        assertEquals(Optional.empty(), this.list.previous());
        Optional<Integer> emptyOptional = this.list.previous();
        assertFalse(emptyOptional.isPresent());

        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        for (int i : new int[]{2, 1, 3, 2}) {
            Optional<Integer> optional = this.list.previous();
            assertTrue(optional.isPresent());
            assertEquals(i, optional.get());
        }
    }

    @Test public void testReset(){
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);

        this.list.next();
        this.list.next();
        Optional<Integer> optional = this.list.next();
        assertTrue(optional.isPresent());
        assertEquals(3, optional.get());

        this.list.reset();

        Optional<Integer> nextOptional = this.list.next();
        assertTrue(nextOptional.isPresent());
        assertEquals(2, nextOptional.get());
    }

    @Test public void testEvenStrategyPositiveCase(){
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);

        StrategyFactory strategyFactory = new StrategyFactoryImplementation();

        for (int i : new int[]{2, 4, 2}) {
            Optional<Integer> optional = this.list.next(strategyFactory.createEvenStrategy());
            assertTrue(optional.isPresent());
            assertEquals(i, optional.get());
        }
    }

    @Test public void testEvenStrategyNegativeCase() {
        this.list.add(1);
        this.list.add(3);
        this.list.add(5);

        StrategyFactory strategyFactory = new StrategyFactoryImplementation();

        Optional<Integer> optional = this.list.next(strategyFactory.createEvenStrategy());
        assertFalse(optional.isPresent());
    }

    @Test public void testMultipleOfStrategyPositiveCase(){
        final int number = 3;

        this.list.add(1);
        this.list.add(3);
        this.list.add(6);
        this.list.add(8);
        this.list.add(9);

        StrategyFactory strategyFactory = new StrategyFactoryImplementation();

        for (int i : new int[]{3, 6, 9, 3}) {
            Optional<Integer> optional = this.list.next(strategyFactory.createMultipleOfStrategy(number));
            assertTrue(optional.isPresent());
            assertEquals(i, optional.get());
        }
    }

    @Test public void testMultipleOfStrategyNegativeCase() {
        final int number = 3;

        this.list.add(1);
        this.list.add(2);
        this.list.add(4);

        StrategyFactory strategyFactory = new StrategyFactoryImplementation();

        Optional<Integer> optional = this.list.next(strategyFactory.createMultipleOfStrategy(number));
        assertFalse(optional.isPresent());
    }

    @Test public void testEqualsStrategyPositiveCase(){
        final int number = 3;

        this.list.add(1);
        this.list.add(3);
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);

        StrategyFactory strategyFactory = new StrategyFactoryImplementation();
        SelectStrategy strategy = strategyFactory.createEqualsStrategy(number);

        for (int i : new int[]{2, 4}) {
            Optional<Integer> strategyOptional = this.list.next(strategy);
            assertTrue(strategyOptional.isPresent());
            assertEquals(number, strategyOptional.get());
            Optional<Integer>optional = this.list.next();
            assertTrue(optional.isPresent());
            assertEquals(i, optional.get());
        }
        Optional<Integer> strategyOptional = this.list.next(strategy);
        assertTrue(strategyOptional.isPresent());
        assertEquals(3, strategyOptional.get());
    }

    @Test public void testEqualsStrategyNegativeCase() {
        final int number = 3;

        this.list.add(1);
        this.list.add(2);
        this.list.add(4);

        StrategyFactory strategyFactory = new StrategyFactoryImplementation();
        SelectStrategy strategy = strategyFactory.createEqualsStrategy(number);

        Optional<Integer> strategyOptional = this.list.next(strategy);
        assertFalse(strategyOptional.isPresent());
    }




}
