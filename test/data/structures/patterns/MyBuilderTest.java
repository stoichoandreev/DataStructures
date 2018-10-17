package data.structures.patterns;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyBuilderTest {

    @Test
    public void test_builder_creates_new_object_with_default_properties() {
        //when
        final MyBuilder builder = new MyBuilder.Builder().build();
        //test
        assertNotNull(builder);
        assertNull(builder.getName());
        assertNull(builder.getDate());
        assertEquals(0, builder.getAge());
    }

    @Test
    public void test_builder_creates_new_object_with_all_properties() {
        //when
        final MyBuilder builder = new MyBuilder.Builder()
                .name("name")
                .date("15-10-2018")
                .age(20)
                .build();
        //test
        assertNotNull(builder);
        assertEquals("name", builder.getName());
        assertEquals("15-10-2018", builder.getDate());
        assertEquals(20, builder.getAge());
    }

}