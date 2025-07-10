package heap_priority_queue;

public class PriorityQueue<T extends Comparable<T>> {

    private MinHeap<T> minHeap;

    public PriorityQueue() {
        minHeap = new MinHeap<>();
    }

    public void enqueue(T element) {
        minHeap.insert(element);
    }

    public T dequeue() {
        return minHeap.poll();
    }
    public T peek() {
        return minHeap.peek();
    }
    public boolean isEmpty() {
        return minHeap.isEmpty();
    }
}
