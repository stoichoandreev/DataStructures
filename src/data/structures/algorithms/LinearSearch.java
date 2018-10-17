package data.structures.algorithms;

public class LinearSearch<T> implements SearchAlgorithm<T> {

    private final T[] items;

    public LinearSearch(T[] items) {
        this.items = items;
    }

    public int findItemPosition(T item) {
        int result = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {
                result = i;
                break;
            }
        }

        return result;
    }
}
