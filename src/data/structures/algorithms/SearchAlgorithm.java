package data.structures.algorithms;

public interface SearchAlgorithm<T> {

    int INT_SEARCH = 1;
    int STRING_SEARCH = 2;
    /**
     * Find item position with the Linear search algorithm
     * @param item - the item that you are looking for
     * @return - a valid position from the list or -1 if the items is not found
     */

    int findItemPosition(T item);

}
