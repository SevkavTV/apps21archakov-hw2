package ua.edu.ucu.collections.immutable;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest{
    ImmutableLinkedList immutableLinkedList;
    @Before
    public void setUp(){
        immutableLinkedList = new ImmutableLinkedList(new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList list1 = (ImmutableLinkedList) immutableLinkedList.add(9);
        ImmutableLinkedList list2 = (ImmutableLinkedList) immutableLinkedList.add(0, 2);

        assertArrayEquals(list1.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        assertArrayEquals(list2.toArray(), new Object[]{2, 1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList list1 = (ImmutableLinkedList) immutableLinkedList.addAll(new Object[]{9, 10});
        ImmutableLinkedList list2 = (ImmutableLinkedList) immutableLinkedList.addAll(0, new Object[]{1, 2});

        assertArrayEquals(list1.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        assertArrayEquals(list2.toArray(), new Object[]{1, 2, 1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExceptionLower() {
        ImmutableLinkedList list = (ImmutableLinkedList) immutableLinkedList.add(-2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddExceptionBigger() {
        ImmutableLinkedList list = (ImmutableLinkedList) immutableLinkedList.add(16, 1);
    }

    @Test
    public void testGet() {
        assertEquals(3, immutableLinkedList.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExceptionLower() {
        ImmutableLinkedList list = (ImmutableLinkedList) immutableLinkedList.get(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetExceptionBigger() {
        ImmutableLinkedList list = (ImmutableLinkedList) immutableLinkedList.get(16);
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList list = (ImmutableLinkedList) immutableLinkedList.remove(2);
        assertArrayEquals(list.toArray(), new Object[]{1, 2, 4, 5, 6, 7, 8});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveExceptionLower() {
        ImmutableLinkedList list = (ImmutableLinkedList) immutableLinkedList.remove(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveExceptionBigger() {
        ImmutableLinkedList list = (ImmutableLinkedList) immutableLinkedList.remove(16);
    }

    @Test
    public void testSet() {
        ImmutableLinkedList list = (ImmutableLinkedList) immutableLinkedList.set(1, 3);
        assertArrayEquals(list.toArray(), new Object[]{1, 3, 3, 4, 5, 6, 7, 8});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetExceptionLower() {
        ImmutableLinkedList list = (ImmutableLinkedList) immutableLinkedList.set(-2, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetExceptionBigger() {
        ImmutableLinkedList list = (ImmutableLinkedList) immutableLinkedList.set(16, 3);
    }

    @Test
    public void testIndexOf() {
        int i1 = immutableLinkedList.indexOf(1);
        int i2 = immutableLinkedList.indexOf(49);

        assertEquals(i1, 0);
        assertEquals(i2, -1);
    }

    @Test
    public void testSize() {
        assertEquals(immutableLinkedList.size(), 8);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList list = (ImmutableLinkedList) immutableLinkedList.clear();
        assertEquals(list.size(), 0);
    }

    @Test
    public void testIsEmpty() {
        assertTrue(new ImmutableLinkedList().isEmpty());
        assertFalse(immutableLinkedList.isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(immutableLinkedList.toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testAddFirst() {
        assertEquals(0, immutableLinkedList.addFirst(0).getFirst());
    }

    @Test
    public void testAddLast() {
        assertEquals(0, immutableLinkedList.addLast(0).getLast());
    }

    @Test
    public void testGetHead() {
        assertEquals(immutableLinkedList.getHead().getValue(), 1);
    }

    @Test
    public void testGetTail() {
        assertEquals(immutableLinkedList.getTail().getValue(), 8);
    }

    @Test
    public void testGetFirst() {
        assertEquals(immutableLinkedList.getFirst(), 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstNull() {
        new ImmutableLinkedList().getFirst();
    }

    @Test
    public void testGetLast() {
        assertEquals(immutableLinkedList.getLast(), 8);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastNull() {
        new ImmutableLinkedList().getLast();
    }

    @Test
    public void testRemoveFirst() {
        assertArrayEquals(immutableLinkedList.removeFirst().toArray(), new Object[]{2, 3, 4, 5, 6, 7, 8});
    }

    @Test
    public void testRemoveLast() {
        assertArrayEquals(immutableLinkedList.removeLast().toArray(), new Object[]{1, 2, 3, 4, 5, 6, 7});
    }
}