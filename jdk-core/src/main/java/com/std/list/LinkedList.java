package com.std.list;

import java.util.Iterator;

public class LinkedList<E> {

    // 生成头结点
    private Node<E> head = new Node<>(null,null,null);

    // 生成尾节点
    private Node<E> tail = new Node<>(null,null,null);

    private int size;

    public LinkedList() {
        head.next = tail;
        tail.prev = head;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {

        return false;
    }

    public Iterator<E> iterator() {

        return new Iterator<E>() {
            int index = 0;
            Node<E> indexNode = head.next;
            @Override
            public boolean hasNext() {
                return index ++ < size;
            }

            @Override
            public E next() {
                E val = indexNode.item;
                indexNode = indexNode.next;
                return val;
            }
        };
    }


    public boolean add(E e) {

        Node<E> newNode = new Node<>(null,e,null);
        Node<E> lastNode = tail.prev;
        newNode.prev = lastNode;
        lastNode.next = newNode;
        newNode.next = tail;
        tail.prev = newNode;
        size++;
        return true;
    }

    public boolean remove(Object o) {



        return false;
    }

    public E get(int index) {




        return null;
    }


    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.add(1);
//        linkedList.add(2);
//        linkedList.add(3);
        System.out.println(linkedList);

        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
