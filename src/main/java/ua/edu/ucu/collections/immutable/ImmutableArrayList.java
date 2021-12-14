package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] immutableArrayList;

    public ImmutableArrayList(Object[] elements) {
        immutableArrayList = Arrays.copyOf(elements, elements.length);
    }

    public ImmutableArrayList() {
        immutableArrayList = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        return add(immutableArrayList.length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(immutableArrayList.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index >= 0 && index <= size()) {
            Object[] immutableArrayListCopy = toArray();
            Object[] immutableArrayListExpanded = new Object[size()+c.length];
            int currInd = 0;
            int prevInd = 0;

            while (currInd < index) {
                immutableArrayListExpanded[currInd] =
                        immutableArrayListCopy[prevInd];
                currInd++;
                prevInd++;
            }

            for (Object elem: c) {
                immutableArrayListExpanded[currInd] = elem;
                currInd++;
            }

            while (currInd < size() + c.length) {
                immutableArrayListExpanded[currInd] =
                        immutableArrayListCopy[prevInd];
                currInd++;
                prevInd++;
            }
            return new ImmutableArrayList(immutableArrayListExpanded);
        }

        throw new IllegalArgumentException("Index out of bounds error");
    }

    @Override
    public Object get(int index) {
        if (index >= 0 && index < size()) {
            return immutableArrayList[index];
        }

        throw new IllegalArgumentException("Index out of bounds error");
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= 0 && index < size()) {
            Object[] immutableArrayListDecreased = new Object[size()-1];
            for (int i = 0; i < size()-1; i++) {
                if (i < index) {
                    immutableArrayListDecreased[i] = get(i);
                } else {
                    immutableArrayListDecreased[i] = get(i+1);
                }
            }
            return new ImmutableArrayList(immutableArrayListDecreased);
        }

        throw new IllegalArgumentException("Index out of bounds error");
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= 0 && index < size()) {
            Object[] immutableArrayListCopy = toArray();
            immutableArrayListCopy[index] = e;
            return new ImmutableArrayList(immutableArrayListCopy);
        }

        throw new IllegalArgumentException("Index out of bounds error");
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size(); i++) {
            if (e.equals(get(i))) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return immutableArrayList.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(immutableArrayList, immutableArrayList.length);
    }
}
