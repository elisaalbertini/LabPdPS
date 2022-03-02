package lab01.tdd;

import java.util.List;
import java.util.Optional;

public class CircularIteratorImplementation implements CircularIterator {
    private List<Integer> list;
    private int currentElement;

    public CircularIteratorImplementation(List<Integer> list) {
        this.list = list;
        this.currentElement = 0;
    }

    private void nextIndex() {
        this.currentElement = (this.currentElement == this.list.size() - 1) ? 0 : this.currentElement + 1;
    }

    private void previousIndex() {
        this.currentElement = (this.currentElement == 0) ? this.list.size() - 1 : this.currentElement - 1;
    }

    @Override
    public Optional<Integer> next() {
        if (!this.list.isEmpty()) {
            this.nextIndex();
            return Optional.of(this.list.get(this.currentElement));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Integer> previous() {
        if (!this.list.isEmpty()) {
            this.previousIndex();
            return Optional.of(this.list.get(this.currentElement));
        }
        return Optional.empty();
    }
}
