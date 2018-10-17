package data.structures.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test_findItemPosition_returns_minus_one_if_item_does_not_exist() {
        //given
        final TestBinarySearchItem[] items = new TestBinarySearchItem[] {};
        final BinarySearch<TestBinarySearchItem> tested = new BinarySearch<>(items);
        final int expected = -1;
        //when
        final int result = tested.findItemPosition(new TestBinarySearchItem(23));
        //test
        assertEquals(expected, result);

    }

    @Test
    public void test_findItemPosition_returns_item_correct_position() {
        //given
        final TestBinarySearchItem[] items = new TestBinarySearchItem[] {
                new TestBinarySearchItem(12),
                new TestBinarySearchItem(15),
                new TestBinarySearchItem(20),
                new TestBinarySearchItem(456)
        };
        final BinarySearch<TestBinarySearchItem> tested = new BinarySearch<>(items);
        final int expected1 = 2;
        final int expected2 = 3;
        //when
        final int result1 = tested.findItemPosition(new TestBinarySearchItem(20));
        final int result2 = tested.findItemPosition(new TestBinarySearchItem(456));
        //test
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);

    }

    static class TestBinarySearchItem extends BinarySearchItem {

        private int value;

        public TestBinarySearchItem(int value) {
            this.value = value;
        }

        @Override
        public int getBinarySearchCriteria() {
            return value;
        }
    }
}