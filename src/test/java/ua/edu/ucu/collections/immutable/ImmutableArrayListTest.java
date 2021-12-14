package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest{
    ImmutableArrayList immutableArrayList;
    @Before
    public void setUp(){
        immutableArrayList = new ImmutableArrayList(new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testAdd() {
        ImmutableArrayList list1 = (ImmutableArrayList) immutableArrayList.add(9);
        ImmutableArrayList list2 = (ImmutableArrayList) immutableArrayList.add(0, 2);

        assertArrayEquals(list1.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        assertArrayEquals(list2.toArray(), new Object[]{2, 1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList list1 = (ImmutableArrayList) immutableArrayList.addAll(new Object[]{9, 10});
        ImmutableArrayList list2 = (ImmutableArrayList) immutableArrayList.addAll(0, new Object[]{1, 2});

        assertArrayEquals(list1.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertArrayEquals(list2.toArray(), new Object[]{1, 2, 1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExceptionLower() {
        ImmutableArrayList list = (ImmutableArrayList) immutableArrayList.add(-2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExceptionBigger() {
        ImmutableArrayList list = (ImmutableArrayList) immutableArrayList.add(16, 1);
    }

    @Test
    public void testGet() {
        assertEquals(3, immutableArrayList.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExceptionLower() {
        ImmutableArrayList list = (ImmutableArrayList) immutableArrayList.get(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExceptionBigger() {
        ImmutableArrayList list = (ImmutableArrayList) immutableArrayList.get(16);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList list = (ImmutableArrayList) immutableArrayList.remove(2);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 4, 5, 6, 7, 8});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveExceptionLower() {
        ImmutableArrayList list = (ImmutableArrayList) immutableArrayList.remove(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveExceptionBigger() {
        ImmutableArrayList list = (ImmutableArrayList) immutableArrayList.remove(16);
    }

    @Test
    public void testSet() {
        ImmutableArrayList list = (ImmutableArrayList) immutableArrayList.set(1, 3);
        assertArrayEquals(list.toArray(), new Object[]{1, 3, 3, 4, 5, 6, 7, 8});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetExceptionLower() {
        ImmutableArrayList list = (ImmutableArrayList) immutableArrayList.set(-2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetExceptionBigger() {
        ImmutableArrayList list = (ImmutableArrayList) immutableArrayList.set(16, 3);
    }

    @Test
    public void testIndexOf() {
        int i1 = immutableArrayList.indexOf(1);
        int i2 = immutableArrayList.indexOf(49);

        assertEquals(i1, 0);
        assertEquals(i2, -1);
    }

    @Test
    public void testSize() {
        assertEquals(immutableArrayList.size(), 8);
    }

    @Test
    public void testClear() {
        ImmutableArrayList list = (ImmutableArrayList) immutableArrayList.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(new ImmutableArrayList().isEmpty());
        assertFalse(immutableArrayList.isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(immutableArrayList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }
}