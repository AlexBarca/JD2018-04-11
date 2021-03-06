package by.it.kashayed.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(T t) {
        if (size==elements.length)
            elements=Arrays.copyOf(elements,size*3/2+1);
        elements[size++]=t;
        return false;
    }

    @Override
    public void add(int index, T element) {
        if (size==elements.length)
            elements=Arrays.copyOf(elements,size*3/2+1);
        System.arraycopy(elements,index,elements,index+1,size-index);  //почему size-index?
        elements[index]=element;
        size++;
    }

    @Override
    public T remove(int index) {
        T delet = elements[index];
        System.arraycopy(elements,index+1,elements,index,size-1-index);
        size--;  //если удалять 2 элемента сразу, почему размер уменьшаем на один?

        return delet;
    }
    @Override
    public boolean remove(Object o) {

        return false;
    }
    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String delimetr = "";
        for (int i = 0; i < size; i++) {

            stringBuilder.append(delimetr).append(elements[i]);
            delimetr=", ";
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
    @Override
    public T set(int index, T element) {
        T change = elements[index];
        elements[index]=element;
        return change;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c) if (add(element)) modified = true;
        return modified;

    }

    @Override
    public int indexOf(Object o) {
        return 0;
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
