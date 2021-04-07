package com.example.itookdemodesign.linkList;

/**
 * @author changyanan1
 */
public class DoubleList<E> {
    private Node first;
    private Node last;
    private int length = 0;

    public void addHead(E e) {
        Node<E> eNode = new Node<>(first, last, e);
        if (length == 0) {
            first = eNode;
        }else {

        }
    }

    public void addLast(E e) {

    }
}

class Node<E> {
    private Node previous;
    private Node next;
    private E e;

    public Node(Node previous, Node next, E e) {
        this.previous = previous;
        this.next = next;
        this.e = e;
    }
}