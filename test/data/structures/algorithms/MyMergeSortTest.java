package data.structures.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyMergeSortTest {

    @Test
    public void test_sort_items() {
        //given
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
        int[] expected = {4,11,23,28,43,45,65,77,89,98};
        MyMergeSort tested = new MyMergeSort();
        //when
        tested.sort(inputArr);

        //test
        assertArrayEquals(expected, inputArr);
    }
}