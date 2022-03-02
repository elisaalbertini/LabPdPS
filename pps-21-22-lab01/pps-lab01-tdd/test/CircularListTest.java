import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest extends AbstractCircularListTest{

    @Test
    public void testFirstAdd() {
        this.addToList(List.of(1));
        assertFalse(this.list.isEmpty());
        assertEquals(1, this.list.size());
    }

    @Test
    public void testMultipleAdds() {
        this.addToList(List.of(1, 2, 3));
        assertEquals(3, this.list.size());
    }

    @Test
    public void testNextWithEmptyList() {
        assertEquals(Optional.empty(), this.list.next());
        Optional<Integer> optional = this.list.next();
        assertFalse(optional.isPresent());
    }

    @Test
    public void testNext(){
        this.addToList(List.of(1, 2, 3));

        Optional<Integer> optional = this.list.next();
        assertTrue(optional.isPresent() && optional.get().equals(1));
    }

    @Test
    public void testMultipleNext(){
        this.addToList(List.of(1, 2, 3));

        this.list.next();
        this.list.next();
        this.list.next();
        Optional<Integer> optional = this.list.next();
        assertTrue(optional.isPresent() && optional.get().equals(1));
    }

    @Test
    public void testPreviousWithEmptyList() {
        assertEquals(Optional.empty(), this.list.previous());
        Optional<Integer> optional = this.list.previous();
        assertFalse(optional.isPresent());
    }

    @Test
    public void testPrevious(){
        this.addToList(List.of(1, 2, 3));

        Optional<Integer> optional = this.list.previous();
        assertTrue(optional.isPresent() && optional.get().equals(2));
    }

    @Test
    public void testMultiplePrevious(){
        this.addToList(List.of(1, 2, 3));

        this.list.previous();
        this.list.previous();
        Optional<Integer> optional = this.list.previous();
        assertTrue(optional.isPresent() && optional.get().equals(3));
    }

    @Test
    public void testResetWithEmptyList() {
        this.list.reset();

        Optional<Integer> optional = this.list.next();
        assertFalse(optional.isPresent());
    }

    @Test
    public void testResetWithNext() {
        this.addToList(List.of(1, 2, 3));

        this.list.next();
        this.list.next();
        this.list.reset();

        Optional<Integer> optional = this.list.next();
        assertTrue(optional.isPresent() && optional.get().equals(2));
    }

    @Test
    public void testResetWithPrevious() {
        this.addToList(List.of(1, 2, 3));

        this.list.previous();
        this.list.previous();
        this.list.reset();

        Optional<Integer> optional = this.list.previous();
        assertTrue(optional.isPresent() && optional.get().equals(3));
    }
}
