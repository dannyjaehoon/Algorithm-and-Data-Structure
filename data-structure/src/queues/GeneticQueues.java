package queues;

public class GeneticQueues<T> {
    private T[] arr;
    private int front, rear, size, capacity;

    @SuppressWarnings("unchecked")
    public GeneticQueues(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T val) {
        if(size == capacity) throw new RuntimeException("Empty Queue");

        rear = (rear + 1) % capacity;
        arr[rear] = val;

        size++;
    }

    public T dequeue() {
        if(size == 0) throw new RuntimeException("Queue Overflow");
        T val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    public T peek() {
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
