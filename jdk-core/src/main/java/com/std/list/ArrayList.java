package com.std.list;


import java.util.*;

/**
 * 实现自的ArrayList
 */
public class ArrayList<E> {

    private Object[] elementData;
    private static final int DEFAULT_CAPACITY = 16;
    private int size;// 当前index


    public ArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int size) {
        if (size < 0) throw new IllegalArgumentException("size not be negative");
        elementData = new Object[size];
    }

    public int size() {
        return elementData.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Object o) {
        for (Object date : elementData) {
            if (date.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public Iterator iterator() {

        return new Iterator() {
            Object[] ite = ArrayList.this.elementData;
            int index;

            @Override
            public boolean hasNext() {
                return index + 1 <= elementData.length;
            }

            @Override
            public Object next() {
                return ite[index++];
            }
        };
    }


    public boolean add(E e) {
        ensureCapacity(size + 1);
        this.elementData[size++] = e;
        return true;
    }


    private void ensureCapacity(int minCapacity) {
        if (elementData.length < minCapacity) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        // 扩容
        int newCapacity = minCapacity << 1;
        // 把原数组拷贝到新数组
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public boolean remove(Object o) {


        return false;
    }

    public void add(int index, E element) {

    }

    public E get(int index) {
        if (index >= elementData.length) {
            throw new IndexOutOfBoundsException();
        }
        return (E) elementData[index];
    }


    @Override
    public String toString() {
        return "ArrayListStd{" +
                "elementData=" + Arrays.toString(elementData) +
                '}';
    }


    public static void main(String[] args) {


        ArrayList<Integer> arrayListStd = new ArrayList<>(1);
        arrayListStd.add(1);
        arrayListStd.add(2);
//        System.out.println(arrayListStd);
//        System.out.println(arrayListStd.get(1));
        Iterator iterator = arrayListStd.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


}
