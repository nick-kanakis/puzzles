package OOD;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Question:
 * Implement a circular array class that supports an array-like data structure which can be efficiently rotated.
 * The class should use a generic type and support iteration.
 *
 * Mistakes:
 * > Iterator implementation, use a int pointer and increment it with each next
 * > Keep track of the size
 * > Watch the use of (size) & (size - 1)
 *
 * Solution:
 *  Instead of shift the elements shift the pointer of the head, calculate the position of the elements,
 *  based on the header pointer.
 *
 *  SOS you can use an array instead of arraylist.
 *  private T[] underlyingArray;
 *  ...
 *  items = (T[]) new Object[size]
 */
public class CircularArray<T> implements Iterable<T>{
    ArrayList<T> underlyingArray = new ArrayList<>();
    int size = 0;
    //head of array is at position 0
    int head = 0;

    public CircularArray(int size) {
        this.size = size;
    }

    public void add(int position, T value) {
        if(underlyingArray.size() > size- 1)
            return;
        int actualPosition = calculatePosition(position);
        underlyingArray.add(actualPosition, value);
    }

    public T get(int position) {
        int actualPosition = calculatePosition(position);
        return underlyingArray.get(actualPosition);
    }

    public T remove(int position) {
        size--;
        int actualPosition = calculatePosition(position);
        return underlyingArray.set(actualPosition, null);
    }

    public void shiftRightBy(int positions) {
        head -= positions;
        if(head <0){
            head = (head + size) % size;
        }
    }

    private int calculatePosition(int position) {
        int tmpPosition = head + position;
        if(tmpPosition >= size){
            return tmpPosition % size;
        }
        return tmpPosition;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator();
    }

    private class CircularArrayIterator implements Iterator<T>{
        private int index = head - 1;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public T next() {
            index++;
            return (T) underlyingArray.get(calculatePosition(index));
        }

        @Override
        public void remove() {

        }
    }
}
