package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest{
    Node node1;
    Node node2;
    @Before
    public void setUp(){
        node1 = new Node();
        node2 = new Node();
        node1.setValue(1);
        node2.setValue(2);
        node1.setNext(node2);
        node2.setPrevious(node1);
    }

    @Test
    public void testToString() {
        assertEquals("2", node2.toString());
    }

    @Test
    public void testGetPrevious() {
        assertEquals(node1, node2.getPrevious());
    }

    @Test
    public void testGetValue() {
        assertEquals(1, node1.getValue());
    }

    @Test
    public void testGetNext() {
        assertEquals(node2, node1.getNext());
    }
}