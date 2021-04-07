package com.example.itookdemodesign.tree;

/**
 * @author changyanan1
 */
public class DoubleList {
    private Node head, tail;
    private int size;

    public void addFirst(Node node) {
        if (head == null) {
            head = tail = node;
        } else {
            Node n = head;
            n.prev = node;
            node.next = n;
            head = node;
        }
        size++;
    }

    /**
     * @param node
     */
    public void remove(Node node) {
        if (head == node && tail == node) {
            head = null;
            tail = null;
        } else if (tail == node) {
            node.prev.next = null;
            tail = node.prev;
        } else if (head == node) {
            node.next.prev = null;
            head = node.next;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size++;
    }

    public Node removeLast() {
        Node node = tail;
        remove(node);
        return node;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        Node node1 = new Node(1, 1);
        doubleList.addFirst(node1);
        Node node2 = new Node(2, 2);
        doubleList.addFirst(node2);
        Node node3 = new Node(3, 3);
        doubleList.addFirst(node3);
        Node node4 = new Node(4, 4);
        doubleList.addFirst(node4);

        Node node5 = new Node(3, 3);
        doubleList.remove(node5);
        System.out.println(doubleList);
    }
}
