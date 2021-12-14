package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private final Node tail;

    public ImmutableLinkedList(Object[] elements) {
        Node prev = null;
        for (Object elem: elements) {
            Node currNode = new Node();
            currNode.setPrevious(prev);
            currNode.setValue(elem);

            if (prev == null) {
                head = currNode;
            } else {
                prev.setNext(currNode);
            }

            prev = currNode;
        }

        tail = prev;
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index >= 0 && index <= size()) {
            Object[] immutableLinkedListCopy = toArray();
            Object[] immutableLinkedListExpanded = new Object[size()+c.length];
            int currInd = 0;
            int prevInd = 0;

            while (currInd < index) {
                immutableLinkedListExpanded[currInd] =
                        immutableLinkedListCopy[prevInd];
                currInd++;
                prevInd++;
            }

            for (Object elem: c) {
                immutableLinkedListExpanded[currInd] = elem;
                currInd++;
            }

            while (currInd < size() + c.length) {
                immutableLinkedListExpanded[currInd] =
                        immutableLinkedListCopy[prevInd];
                currInd++;
                prevInd++;
            }
            return new ImmutableLinkedList(immutableLinkedListExpanded);
        }

        throw new IllegalArgumentException("Index out of bounds error");
    }

    @Override
    public Object get(int index) {
        if (index >= 0 && index < size()) {
            Object[] immutableLinkedListCopy = toArray();
            return immutableLinkedListCopy[index];
        }

        throw new IllegalArgumentException("Index out of bounds error");
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= 0 && index < size()) {
            Object[] immutableLinkedListDecreased = new Object[size()-1];
            for (int i = 0; i < size()-1; i++) {
                if (i < index) {
                    immutableLinkedListDecreased[i] = get(i);
                } else {
                    immutableLinkedListDecreased[i] = get(i+1);
                }
            }

            return new ImmutableLinkedList(immutableLinkedListDecreased);
        }

        throw new IllegalArgumentException("Index out of bounds error");
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= 0 && index < size()) {
            Object[] immutableLinkedListCopy = toArray();
            immutableLinkedListCopy[index] = e;
            return new ImmutableLinkedList(immutableLinkedListCopy);
        }

        throw new IllegalArgumentException("Index out of bounds error");
    }

    @Override
    public int indexOf(Object e) {
        int currInd = 0;
        Node currNode = getHead();

        while (currNode != null && !currNode.getValue().equals(e)) {
            currNode = currNode.getNext();
            currInd++;
        }

        if(currInd == size()) {
            return -1;
        }

        return currInd;
    }

    @Override
    public int size() {
        int listSize = 0;
        Node currNode = getHead();
        while (currNode != null) {
            listSize++;
            currNode = currNode.getNext();
        }

        return listSize;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        int currInd = 0;
        Node currNode = getHead();
        Object[] result = new Object[size()];

        while (currNode != null) {
            result[currInd] = currNode.getValue();
            currNode = currNode.getNext();
            currInd++;
        }

        return result;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(size(), e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        if (size() > 0) {
            return head.getValue();
        }

        throw new IndexOutOfBoundsException("The list is empty");
    }

    public Object getLast() {
        if (size() > 0) {
            return tail.getValue();
        }

        throw new IndexOutOfBoundsException("The list is empty");
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size()-1);
    }
}
