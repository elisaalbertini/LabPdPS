package lab01.tdd;

import java.util.LinkedList;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    private final LinkedList<Integer> elementList;
    private int currentIndex;

    public SimpleCircularList() {
        this.elementList = new LinkedList<>();
        this.currentIndex = -1;
    }

    @Override
    public void add(int element) {
        this.elementList.add(element);
        this.currentIndex = (this.currentIndex == -1) ? 0 : this.elementList.size() - 1;
    }

    @Override
    public int size() {
        return this.elementList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elementList.size() == 0;
    }

    private int getNextIndex(){
        this.currentIndex = (this.currentIndex == this.elementList.size()-1) ? 0 : this.currentIndex +1;
        return this.currentIndex;
    }

    private int getPreviousIndex(){
        this.currentIndex = (this.currentIndex == 0) ? this.elementList.size()-1 : this.currentIndex -1;
        return this.currentIndex;
    }

    private Optional<Integer> getElement(int index){
        if(this.elementList.isEmpty()){
            return Optional.empty();
        }else {
            return Optional.ofNullable(this.elementList.get(index));
        }
    }

    @Override
    public Optional<Integer> next() {
        return getElement(getNextIndex());
    }

    @Override
    public Optional<Integer> previous() {
        return getElement(getPreviousIndex());
    }

    @Override
    public void reset() {
        this.elementList.clear();
        this.currentIndex = -1;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
