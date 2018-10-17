package data.structures.algorithms;

import com.sun.istack.internal.NotNull;


/**
 * This algorithm works only if the array of items is sorted by ascending order
 *
 * @param <T>
 */
public class BinarySearch<T extends BinarySearchItem> implements SearchAlgorithm<T> {

    private T[] items;

    public BinarySearch(@NotNull T[] items) {
        this.items = items;
    }

    @Override
    public int findItemPosition(T item) {
        try {
            return executeBinarySearch(items, 0, items.length - 1, item);
        } catch (ArrayIndexOutOfBoundsException ex) {
            return items[0].getBinarySearchCriteria() == item.getBinarySearchCriteria() ? 0 : -1;
        }
    }

    private static <T extends BinarySearchItem> int executeBinarySearch(@NotNull T[] items, int first, int last, T searchItem) {

        if (last >= first) {
            int midPosition = Math.round((last - first) / 2.0f);
            if (items[first + midPosition].getBinarySearchCriteria() == searchItem.getBinarySearchCriteria()) {
                return first + midPosition;
            }
            if (items[first + midPosition].getBinarySearchCriteria() > searchItem.getBinarySearchCriteria()) {
                return executeBinarySearch(items, first, midPosition - 1, searchItem);//search in left sub array
            } else {
                return executeBinarySearch(items, midPosition + 1, last, searchItem);//search in right sub array
            }
        }
        return -1;
    }
}
