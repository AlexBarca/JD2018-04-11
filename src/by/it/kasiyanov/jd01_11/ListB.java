package by.it.kasiyanov.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        }
        elements[size++] = t;
        return false;
    }

    @Override
    public void add(int index, T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] arr = (T[]) c.toArray();
        int tmpSize = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (size == elements.length) {
                elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
            }
            elements[size++] = arr[i];
        }
        return tmpSize != 0;

    }

    @Override
    public T remove(int index) {
        T del = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - (index + 1));
        size--;
        return del;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1) {
            remove(index);
        }
        return index > -1;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        T del = elements[index];
        if (index > -1) {
            elements[index] = element;
        }
        return del;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
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
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
