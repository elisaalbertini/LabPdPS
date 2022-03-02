import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 * The test suite for testing the AbstractCircularListTest implementation
 */
abstract class AbstractCircularListTest {
    protected SimpleCircularList list;

    @BeforeEach
    public void beforeEach() {
        this.list = new SimpleCircularList();
    }

    protected void addToList(List<Integer> elementList) {
        elementList.forEach(element -> this.list.add(element));
    }

    @Test
    public void testIsInitiallyEmpty() {
        assertTrue(this.list.isEmpty());
        assertEquals(0, this.list.size());
    }
}
