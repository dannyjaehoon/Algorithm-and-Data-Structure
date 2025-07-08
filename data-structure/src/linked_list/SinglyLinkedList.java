package linked_list;


public class SinglyLinkedList<T> {

    private class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(T value) {
        if(head == null) {
            head = new Node<>(value);
            tail = head;

        } else {
            tail.next = new Node<>(value);
            tail = tail.next;
        }
        size++;
    }
    public void addAt(int index, T value) {
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node<T> node = head;
        Node<T> prev = null;

        if(index == 0) {
            Node<T> newNode = new Node<>(value);
            newNode.next = head;
            head = newNode;
            if(size == 0) tail = newNode;
        } else {
            while(index-- > 0) {
                prev = node;
                node = node.next;
            }

            prev.next = new Node<>(value);
            prev.next.next = node;
        }
        size++;
    }
    public T remove(T value) {
        if(isEmpty()) return null;
        Node<T> node = head;
        Node<T> prev = null;

        while(node != null) {
            if(node.value.equals(value)) {
                if(prev == null) {
                    head = node.next;
                    if (node == tail) tail = null;
                } else {
                    prev.next = node.next;
                    if (node == tail) tail = prev;
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

    public boolean contains(T value) {
        if(head == null) return false;
        Node<T> node = head;

        while(node != null) {
            if(node.value.equals(value)) return true;
            node = node.next;
        }
        return false;
    }
    public T get(int index) {
        if(isEmpty() || index >= size || index <0) throw new IndexOutOfBoundsException();

        Node<T> node = head;

        while(index-- > 0) {
            node = node.next;
        }
        return node.value;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }


}


