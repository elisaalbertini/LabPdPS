import lab01.tdd.SimpleCircularList;
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
        assertEquals(1, list.next().get());
        assertEquals(2, list.next().get());
        assertEquals(3, list.next().get());
        assertEquals(1, list.next().get());
    }

    @Test public void testPrevious(){ //TODO non va!!
        assertEquals(Optional.empty(), list.previous());
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(2, list.previous().get());
        assertEquals(1, list.previous().get());
        assertEquals(3, list.previous().get());
        assertEquals(2, list.previous().get());
    }

    @Test public void testReset(){
        list.add(1);
        list.add(2);
        list.add(3);
        list.reset();
        testIsInitiallyEmpty();
    }


}
