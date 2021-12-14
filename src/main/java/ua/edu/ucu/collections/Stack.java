package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack = new ImmutableLinkedList();
    public void push(Object e) {
        stack = stack.addLast(e);
    }

    public Object pop() {
        Object last = peek();
        stack = stack.removeLast();
        return last;
    }

    public Object peek() {
        return stack.getLast();
    }
}
