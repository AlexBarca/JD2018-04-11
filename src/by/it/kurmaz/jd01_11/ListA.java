package by.it.kurmaz.jd01_11;

import java.util.*;

public class ListA<T> implements List<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, size+1);
        elements[size++] = t;
        return true;
    }

    @Override
    public void add(int index, T t) {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, size+1);
        System.arraycopy(elements, index, elements, index +1, size - index);
        elements[index] = t;
        size++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimeter).append(elements[i]);
            delimeter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T remove(int index) {
        T element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        size--;
        return element;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1)
            remove(index);
        return (index > -1);
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                return i;
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }


    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }



    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
