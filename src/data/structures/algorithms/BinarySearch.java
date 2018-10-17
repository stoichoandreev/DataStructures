package data.structures.algorithms;

import com.sun.istack.internal.NotNull;


/**
 * This algorithm works only if the array of items is sorted by ascending order
 *
 * @param <T>
 */
public class BinarySearch<T extends BinarySearchItem> implements SearchAlgorithm<T> {

    private T[] items;
    private int searchAlgorithmType;

    public BinarySearch(@NotNull T[] items) {
        this.items = items;
    }

    public BinarySearch(@NotNull T[] items, int searchAlgorithmType) {
        this(items);
        this.searchAlgorithmType = searchAlgorithmType;
    }

    public void setSearchAlgorithmType(int searchAlgorithmType) {
        this.searchAlgorithmType = searchAlgorithmType;
    }

    @Override
    public int findItemPosition(T item) {
        try {
            return executeBinarySearch(items, 0, items.length - 1, item, searchAlgorithmType);
        } catch (ArrayIndexOutOfBoundsException ex) {
            return items[0].getBinarySearchIntIndex() == item.getBinarySearchIntIndex() ? 0 : -1;
        }
    }

    private static <T extends BinarySearchItem> int executeBinarySearch(@NotNull T[] items,
                                                                        int first,
                                                                        int last,
                                                                        T searchItem,
                                                                        int searchAlgorithmType) {

        if (last >= first) {
            int midPosition = Math.round((last - first) / 2.0f);
            if (isCurrentItem(items[first + midPosition], searchItem, searchAlgorithmType)) {
                return first + midPosition;
            }
            if (searchInLeftSide(items[first + midPosition], searchItem, searchAlgorithmType)) {
                return executeBinarySearch(items, first, midPosition - 1, searchItem, searchAlgorithmType);//search in left sub array
            } else {
                return executeBinarySearch(items, midPosition + 1, last, searchItem, searchAlgorithmType);//search in right sub array
            }
        }
        return -1;
    }

    private static <T extends BinarySearchItem> boolean isCurrentItem(@NotNull T currentItem,
                                                                      @NotNull T searchItem,
                                                                      int searchAlgorithmType) {
        switch (searchAlgorithmType) {
            case SearchAlgorithm.INT_SEARCH:
                return currentItem.getBinarySearchIntIndex() == searchItem.getBinarySearchIntIndex();
            case SearchAlgorithm.STRING_SEARCH:
                return currentItem.getBinarySearchStringIndex().equals(searchItem.getBinarySearchStringIndex());
            default:
                return currentItem.getBinarySearchIntIndex() == searchItem.getBinarySearchIntIndex();

        }
    }

    private static <T extends BinarySearchItem> boolean searchInLeftSide(@NotNull T firstItem,
                                                                         @NotNull T searchItem,
                                                                         int searchAlgorithmType) {
        switch (searchAlgorithmType) {
            case SearchAlgorithm.INT_SEARCH:
                return firstItem.getBinarySearchIntIndex() > searchItem.getBinarySearchIntIndex();
            case SearchAlgorithm.STRING_SEARCH:
                return firstItem.getBinarySearchStringIndex().compareTo(searchItem.getBinarySearchStringIndex()) > 0;
            default:
                return firstItem.getBinarySearchIntIndex() > searchItem.getBinarySearchIntIndex();

        }
    }
}
