package lab01.tdd;

import java.util.*;

public class CircularListImplementation implements CircularList {

    private final List<Integer> list;
    private ListIterator<Integer> iterator;

    public CircularListImplementation() {
        this.list = new ArrayList<>();
        this.iterator = this.list.listIterator();
    }

    @Override
    public void add(int element) {
        this.list.add(element);
        this.iterator = this.list.listIterator();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    private Optional<Integer> move(boolean isNext) {
        final Optional<Integer> optional;
        if (this.list.isEmpty()) {
            return Optional.empty();
        } else {
            if (isNext) {
                if (!this.iterator.hasNext()) {
                    this.iterator = this.list.listIterator();
                }
                optional = Optional.of(this.iterator.next());
            } else {
                if (!this.iterator.hasPrevious()) {
                    this.iterator = this.list.listIterator(this.list.size());
                }
                optional = Optional.of(this.iterator.previous());
            }
        }
        return optional;
    }

    @Override
    public Optional<Integer> next() {
        return this.move(true);
    }

    @Override
    public Optional<Integer> previous() {
        return this.move(false);
    }

    @Override
    public void reset() {
        if (this.list.size() > 0) {
            this.iterator = this.list.listIterator();
        }
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        for (int count = 0; count < this.list.size(); count++) {
            Optional<Integer> optional = this.next();
            if (optional.isPresent()) {
                int element = optional.get();
                if (strategy.apply(element)) {
                    return Optional.of(element);
                }
            } else {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}
