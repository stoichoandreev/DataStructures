package data.structures.algorithms;

import java.util.Comparator;

public class MySorter implements Comparator<Integer> {

    private boolean isDESC;

    public MySorter(boolean isDESC) {
        this.isDESC = isDESC;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return isDESC? o1 - o2 : o2 - o1;
    }
}
