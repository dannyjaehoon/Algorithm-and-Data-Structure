package queues;

public class Queues {
    private int[] arr;
    private int front, rear, size, capacity;

    public Queues(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int val) {
        if(size == capacity) throw new RuntimeException("Empty Queue");

        rear = (rear + 1) % capacity;
        arr[rear] = val;

        size++;
    }

    public int dequeue() {
        if(size == 0) throw new RuntimeException("Queue Overflow");
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue Underflow");
        return arr[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
}
