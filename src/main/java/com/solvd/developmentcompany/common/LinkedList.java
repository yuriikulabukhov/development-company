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

    // NEW METHOD: insert item at a specific position
    public void addAtIndex(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> newNode = new Node<>(item);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            size++;
            return;
        }
        Node<T> previous = head;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }
        newNode.next = previous.next;
        previous.next = newNode;
        size++;
    }

    // NEW METHOD: remove item by index
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedData;

        if (index == 0) {
            removedData = head.data;
            head = head.next;
            size--;
            return removedData;
        }
        Node<T> previous = head;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.next;
        }
        removedData = previous.next.data;
        previous.next = previous.next.next;
        size--;
        return removedData;
    }

    public int size() { return size;}

}