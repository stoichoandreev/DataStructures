package data.structures;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void test_enqueue_adds_items_to_the_queue() {
        //given
        final Queue<String> tested = new Queue<>("Start");
        //when
        tested.enqueue("Second");
        tested.enqueue("Third");
        //test
        assertEquals(3, tested.size());
        //when
        tested.enqueue("Forth");
        //test
        assertEquals(4, tested.size());
    }

    @Test
    public void test_dequeue_removes_items_from_the_queue() {
        //given
        final Queue<Integer> tested = new Queue<>(15);
        tested.enqueue(34);
        tested.enqueue(45);
        //test
        assertEquals(3, tested.size());
        //when
        final Integer removedItem1 = tested.dequeue();
        //test
        assertEquals(2, tested.size());
        assertEquals(new Integer(15), removedItem1);
        //when
        final Integer removedItem2 = tested.dequeue();
        assertEquals(new Integer(34), removedItem2);
    }
}