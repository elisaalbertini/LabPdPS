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
        assertTrue(list.isEmpty());
        assertEquals(0,list.size());
    }

    @Test public void testFirstAdd(){
        list.add(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test public void testNextAdds(){
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    @Test public void testNext(){
        assertEquals(Optional.empty(), list.next());
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i : new int[]{1, 2, 3, 1}) {
            Optional<Integer> optional = list.next();
            assertTrue(optional.isPresent());
            assertEquals(i, optional.get());
        }
    }

    @Test public void testPrevious(){
        assertEquals(Optional.empty(), list.previous());
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i : new int[]{2, 1, 3, 2}) {
            Optional<Integer> optional = list.previous();
            assertTrue(optional.isPresent());
            assertEquals(i, optional.get());
        }
    }

    @Test public void testReset(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.reset();
        testIsInitiallyEmpty();
    }

    @Test public void testEvenStrategy(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        StrategyFactory strategyFactory = new StrategyFactoryImplementation();

        for (int i : new int[]{2, 4, 2}) {
            Optional<Integer> optional = list.next(strategyFactory.createEvenStrategy());
            assertTrue(optional.isPresent());
            assertEquals(i, optional.get());
        }
    }

    @Test public void testMultipleOfStrategy(){
        final int number = 3;

        list.add(1);
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(9);

        StrategyFactory strategyFactory = new StrategyFactoryImplementation();

        for (int i : new int[]{3, 6, 9, 3}) {
            Optional<Integer> optional = list.next(strategyFactory.createMultipleOfStrategy(number));
            assertTrue(optional.isPresent());
            assertEquals(i, optional.get());
        }
    }

    @Test public void testEqualsStrategy(){
        final int number = 3;

        list.add(1);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(4);

        StrategyFactory strategyFactory = new StrategyFactoryImplementation();
        SelectStrategy strategy = strategyFactory.createEqualsStrategy(number);

        for (int i : new int[]{2, 4}) {
            Optional<Integer> strategyOptional = list.next(strategy);
            assertTrue(strategyOptional.isPresent());
            assertEquals(number, strategyOptional.get());
            Optional<Integer>optional = list.next();
            assertTrue(optional.isPresent());
            assertEquals(i, optional.get());
        }
        Optional<Integer> strategyOptional = list.next(strategy);
        assertTrue(strategyOptional.isPresent());
        assertEquals(3, strategyOptional.get());
    }




}
