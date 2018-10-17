package data.structures.patterns;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class MyFactoryTest {

    @Test
    public void test_createShape_returns_triangle() {
        //when
        Shape result = MyFactory.createShape(3);
        //test
        assertThat(result, instanceOf(Triangle.class));
    }

    @Test
    public void test_createShape_returns_rectangle() {
        //when
        Shape result = MyFactory.createShape(4);
        //test
        assertThat(result, instanceOf(Rectangle.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_createShape_throws_exception_if_shape_can_not_be_provided() {
        //when
        MyFactory.createShape(5);

    }
}