package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    private final List<Integer> list;
    private int currentElement;

    public SimpleCircularList() {
        this.list = new ArrayList<>();
        this.currentElement = -1;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
        this.currentElement = this.list.size() - 1;
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.size() == 0;
    }

    private void nextIndex() {
        this.currentElement = (this.currentElement == this.list.size() - 1) ? 0 : this.currentElement + 1;
    }

    private void previousIndex() {
        this.currentElement = (this.currentElement == 0) ? this.list.size() - 1 : this.currentElement - 1;
    }

    private Optional<Integer> getElement(int index) {
        if (this.list.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(this.list.get(index));
        }
    }

    @Override
    public Optional<Integer> next() {
        this.nextIndex();
        return this.getElement(this.currentElement);
    }

    @Override
    public Optional<Integer> previous() {
        this.previousIndex();
        return this.getElement(this.currentElement);
    }

    @Override
    public void reset() {
        if(this.list.size() > 0){
            this.currentElement = 0;
        }
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {

        this.nextIndex();
        for(int count = 0; count < this.list.size(); count++){
            if (strategy.apply(list.get(this.currentElement))) {
                return Optional.of(list.get(this.currentElement));
            } else {
                this.nextIndex();
            }
        }

        return Optional.empty();
    }
}
