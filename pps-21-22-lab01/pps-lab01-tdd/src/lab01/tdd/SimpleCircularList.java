package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    private final List<Integer> elementList;
    private int currentIndex;

    public SimpleCircularList() {
        this.elementList = new ArrayList<>();
        this.currentIndex = -1;
    }

    @Override
    public void add(int element) {
        this.elementList.add(element);
        this.currentIndex = this.elementList.size() - 1;
    }

    @Override
    public int size() {
        return this.elementList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elementList.size() == 0;
    }

    private void nextIndex() {
        this.currentIndex = (this.currentIndex == this.elementList.size() - 1) ? 0 : this.currentIndex + 1;
    }

    private void previousIndex() {
        this.currentIndex = (this.currentIndex == 0) ? this.elementList.size() - 1 : this.currentIndex - 1;
    }

    private Optional<Integer> getElement(int index) {
        if (this.elementList.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(this.elementList.get(index));
        }
    }

    @Override
    public Optional<Integer> next() {
        this.nextIndex();
        return this.getElement(this.currentIndex);
    }

    @Override
    public Optional<Integer> previous() {
        this.previousIndex();
        return this.getElement(this.currentIndex);
    }

    @Override
    public void reset() {
        if(this.elementList.size() > 0){
            this.currentIndex = 0;
        }
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {

        this.nextIndex();
        for(int count = 0; count < this.elementList.size(); count++){
            if (strategy.apply(elementList.get(this.currentIndex))) {
                return Optional.of(elementList.get(this.currentIndex));
            } else {
                this.nextIndex();
            }
        }

        return Optional.empty();
    }
}
