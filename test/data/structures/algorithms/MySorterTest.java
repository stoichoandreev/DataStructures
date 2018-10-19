package data.structures.algorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class MySorterTest {

    @Test
    public void test_desc_sort() {

        final MySorter tested = new MySorter(true);
        List<Integer> list = new ArrayList<>(5);
        list.add(34);
        list.add(4);
        list.add(44);
        list.add(24);
        Collections.sort(list, tested);
        assertEquals(4, list.get(0).intValue());
        assertEquals(24, list.get(1).intValue());
        assertEquals(34, list.get(2).intValue());
        assertEquals(44, list.get(3).intValue());
    }

    @Test
    public void test_asc_sort() {

        final MySorter tested = new MySorter(false);
        List<Integer> list = new ArrayList<>(5);
        list.add(34);
        list.add(4);
        list.add(44);
        list.add(24);
        Collections.sort(list, tested);
        assertEquals(4, list.get(3).intValue());
        assertEquals(24, list.get(2).intValue());
        assertEquals(34, list.get(1).intValue());
        assertEquals(44, list.get(0).intValue());
    }
}