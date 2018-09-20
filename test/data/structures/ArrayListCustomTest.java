package data.structures;

import org.junit.Test;


import static org.junit.Assert.*;

public class ArrayListCustomTest {

    @Test
    public void testedIsEmptyAtTheBeginning() {
        //given
        final ArrayListCustom<Integer> tested = new ArrayListCustom<>();
        //test
        assertTrue(0 == tested.size());
    }

    @Test
    public void testedAddsNewItems() {
        //given
        final ArrayListCustom<Integer> tested = new ArrayListCustom<>();
        //when
        tested.add(1);
        tested.add(2);
        tested.add(3);
        tested.add(4);
        tested.add(5);
        //test
        assertTrue(5 == tested.size());
    }

    @Test
    public void testedReturnsCorrectItemByIndex() {
        //give
        final ArrayListCustom<Integer> tested = new ArrayListCustom<>();
        //when
        tested.add(1);
        tested.add(2);
        tested.add(3);
        tested.add(4);
        tested.add(5);
        //test
        assertTrue(2 == tested.get(1));
        assertTrue(3 == tested.get(2));
        assertTrue(5 == tested.get(4));
    }

    @Test
    public void testedReturnsCorrectSize() {
        //given
        final ArrayListCustom<Integer> tested = new ArrayListCustom<>();
        //when
        tested.add(1);
        tested.add(2);
        //test
        assertTrue(2 == tested.size());
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testedThrowsIndexOutOfBoundsExceptionWithBigIndex() {
        //given
        final ArrayListCustom<Integer> tested = new ArrayListCustom<>();
        //when
        tested.add(1);
        tested.add(100);
        tested.add(10000);
        //test
        tested.get(16);
    }


    @Test(expected=IndexOutOfBoundsException.class)
    public void testedThrowsIndexOutOfBoundsExceptionWithNegativeIndex() {
        //given
        final ArrayListCustom<Integer> tested = new ArrayListCustom<>();
        //when
        tested.add(1);
        tested.add(2);
        tested.add(3);
        tested.add(3);
        tested.add(4);
        //test
        tested.get(-1);
    }
}
