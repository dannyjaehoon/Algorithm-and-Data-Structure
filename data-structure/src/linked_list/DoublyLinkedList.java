package linked_list;

import java.util.Objects;

public class DoublyLinkedList<T> {

    private class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            prev = null;
            next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void remove(T value) {

        // if head has T value
        // else if T value is in the middle of the linkedlist
        // else if the tail has the T value
        if(head == null) return;

        Node<T> curNode = head.next;
        Node<T> prevNode = head;

        // Case 1: The node to remove is the head
        // Case 2: The node to remove is the tail
        // Case 3: The node to remove is in the middle of the list

        if(Objects.equals(value, head.value)) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if(Objects.equals(value, tail.value)) {

            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null;
        } else {
            while(curNode != null) {
                if(Objects.equals(value, curNode.value)) {
                    prevNode.next = curNode.next;
                    if (curNode.next != null) curNode.next.prev = prevNode;
                    else tail = prevNode;
                    break;
                }
                prevNode = curNode;
                curNode = curNode.next;
            }
        }
        size--;
    }
    public T get(T value) {
        Node<T> curNode = head;
        while(curNode != null) {

            if(Objects.equals(curNode.value, value)) return curNode.value;
            curNode = curNode.next;
        }

        return null;
    }

    public int size() { return size;}
    public boolean isEmpty() { return size() == 0; }
}
