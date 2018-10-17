package data.structures.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinearSearchTest {

    @Test
    public void test_findItemPosition_returns_minus_one_if_item_does_not_exist() {
        //given
        final String[] items = new String[]{"One", "Five", "Some", "More", "Nothing", "Else"};
        final LinearSearch<String> tested = new LinearSearch<>(items);
        final int expected = -1;
        //when
        int result = tested.findItemPosition("one");
        //test
        assertEquals(expected, result);
    }

    @Test
    public void test_findItemPosition_returns_item_correct_position() {
        //given
        final String[] items = new String[]{"One", "Five", "Some", "More", "Nothing", "Else"};
        final LinearSearch<String> tested = new LinearSearch<>(items);
        final int expected1 = 0;
        final int expected2 = 4;
        //when
        int result1 = tested.findItemPosition("One");
        int result2 = tested.findItemPosition("Nothing");
        //test
        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
    }
}