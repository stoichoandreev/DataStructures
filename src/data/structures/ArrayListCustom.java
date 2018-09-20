package data.structures;

import java.util.Arrays;

public class ArrayListCustom<E> {

    private static final int DEFAULT_CAPACITY = 15;

    private int size;

    @SuppressWarnings("unchecked")
    private E elements[] = (E[]) new Object[DEFAULT_CAPACITY];

    public void add(E item) {
        if (size == elements.length) {
            increaseBufferSize();
        }
        elements[size] = item;
        size++;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size );
        }
        return elements[index];
    }

    public int size() {
        return size;
    }

    private void increaseBufferSize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
