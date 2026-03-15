package com.solvd.developmentcompany.common;

public class LinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) { this.data = data;}
    }

    private Node<T> head;
    private Integer size;

    public void add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() { return size; }

}