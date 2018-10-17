package data.structures.patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class MySingletonTest {

    @Test
    public void test_getInstance_returns_none_null_object() {
        //given
        final MySingleton tested = MySingleton.getInstance();

        //test
        assertNotNull(tested);
    }

    @Test
    public void test_getInstance_returns_same_instance() {
        //given
        final MySingleton tested1 = MySingleton.getInstance();
        final MySingleton tested2 = MySingleton.getInstance();

        //test
        assertEquals(tested1, tested2);
    }
}