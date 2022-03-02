package lab01.tdd;

import java.util.Optional;

/**
 * Represent an Iterator for a circular list
 */
public interface CircularIterator {
    /**
     * Starting from the current element of the list
     *
     * @return the next element of the list.
     * Being a circular list, the next element of the last element added is the first one.
     */
    Optional<Integer> next();

    /**
     * Starting from the current element of the list
     *
     * @return the previous element of the list.
     * Being a circular list, the previous element of the first element added is the last one.
     */
    Optional<Integer> previous();
}
