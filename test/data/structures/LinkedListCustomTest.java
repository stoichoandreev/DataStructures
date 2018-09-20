package data.structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListCustomTest {

    @Test
    public void testedIsEmptyAtTheBeginning() {
        //given
        final LinkedListCustom<String> tested = new LinkedListCustom<>();
        //test
        assertTrue( 0 == tested.size());
    }

    @Test
    public void testedAddsNewItems() {
        //given
        final LinkedListCustom<String> tested = new LinkedListCustom<>();
        //when
        tested.add("Item 1");
        tested.add("Item 2");
        //test
        assertTrue( 2 == tested.size());
    }

    @Test
    public void testedAddsNewItemOnSpecificIndex() {
        //given
        final LinkedListCustom<String> tested = new LinkedListCustom<>();
        final String custom = "Custom";
        final int randomPosition = 2;
        //when
        tested.add("Item 1");
        tested.add("Item 2");
        tested.add("Item 3");
        tested.add("Item 4");
        tested.add(custom, randomPosition);
        //test
        assertTrue( tested.get(randomPosition).equals(custom));
    }

    @Test
    public void testedReturnsCorrectItemByIndex() {
        //given
        final LinkedListCustom<Integer> tested = new LinkedListCustom<>();
        //when
        tested.add(12);
        tested.add(34);
        tested.add(120);
        //test
        assertTrue( 34 == tested.get(1));
    }

    @Test
    public void testedReturnsCorrectSizeWhenAdd() {
        //given
        final LinkedListCustom<Integer> tested = new LinkedListCustom<>();
        //when
        tested.add(12);
        tested.add(34);
        tested.add(120);
        tested.add(2345);
        tested.add(2345);
        //test
        assertTrue( 5 == tested.size());
    }

    @Test
    public void testedReturnsCorrectSizeWhenAddAndRemove() {
        //given
        final LinkedListCustom<Integer> tested = new LinkedListCustom<>();
        //when
        tested.add(12);
        tested.add(34);
        tested.add(120);
        tested.add(2345);
        tested.add(2345);
        tested.remove(3);
        tested.remove(1);
        //test
        assertTrue( 3 == tested.size());
    }

    @Test
    public void testedRemovesItem() {
        //given
        final LinkedListCustom<Object> tested = new LinkedListCustom<>();
        //when
        tested.add(new Object());
        tested.add(new Object());
        tested.add(new Object());
        tested.remove(1);
        //test
        assertTrue(2 == tested.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testedRemovesItemThrowsIndexOutOfBoundsExceptionWithSmallIndex() {
        //given
        final LinkedListCustom<Object> tested = new LinkedListCustom<>();
        //when
        tested.add(new Object());
        tested.add(new Object());
        tested.add(new Object());
        //test
        tested.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testedRemovesItemThrowsIndexOutOfBoundsExceptionWithBigIndex() {
        //given
        final LinkedListCustom<Object> tested = new LinkedListCustom<>();
        //when
        tested.add(new Object());
        tested.add(new Object());
        tested.add(new Object());
        //test
        tested.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testedReturnsItemThrowsIndexOutOfBoundsExceptionWithNegativeIndex() {
        //given
        final LinkedListCustom<Object> tested = new LinkedListCustom<>();
        //when
        tested.add(new Object());
        tested.add(new Object());
        tested.add(new Object());
        //test
        tested.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testedReturnsItemThrowsIndexOutOfBoundsExceptionWithBigIndex() {
        //given
        final LinkedListCustom<Object> tested = new LinkedListCustom<>();
        //when
        tested.add(new Object());
        tested.add(new Object());
        tested.add(new Object());
        //test
        tested.remove(5);
    }


    @Test
    public void testedReturnsCorrectToStringValue() {
        //give
        final LinkedListCustom<String> tested = new LinkedListCustom<>();
        final String expected = "[one][two]";
        //when
        tested.add("one");
        tested.add("two");
        final String result = tested.toString();
        //test
        assertTrue(result.equals(expected));
    }

    @Test
    public void testedNodeConstructorStoresData() {
        //give
        final Integer expected = 123;
        final LinkedListCustom.Node<Integer> tested = new LinkedListCustom.Node<>(expected);
        //when
        final Integer result = tested.getData();
        //test
        assertTrue(result.equals(expected));
    }

    @Test
    public void testedNodeConstructorStoresDataAndNext() {
        //give
        final Integer expectedData = 123;
        final LinkedListCustom.Node<Integer> expectedNext = new LinkedListCustom.Node<>(321);
        final LinkedListCustom.Node<Integer> tested = new LinkedListCustom.Node<>(expectedData, expectedNext);
        //when
        final Integer dataResult = tested.getData();
        final LinkedListCustom.Node<Integer> nextResult = tested.getNext();
        //test
        assertTrue(dataResult.equals(expectedData));
        assertTrue(nextResult.equals(expectedNext));
    }

    @Test
    public void testedNodeStoresData() {
        //give
        final Integer expected = 123;
        final LinkedListCustom.Node<Integer> tested = new LinkedListCustom.Node<>(345);
        //when
        tested.setData(expected);
        final Integer result = tested.getData();
        //test
        assertTrue(result.equals(expected));
    }
}
