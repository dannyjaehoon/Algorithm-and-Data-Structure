package heap_priority_queue;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<T extends Comparable<T>> {
    private List<T> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public void insert(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }
    public T poll() {
        if(heap.isEmpty()) return null;

        T temp = heap.get(0);
        T last = heap.remove(heap.size() - 1);

        if(!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return temp;
    };
    public T peek() {
        if(heap.isEmpty()) return null;
        return heap.get(0);
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public void heapifyUp(int index) {
        while(index > 0) {
            int parentIdx = (index - 1) /2;
            if(heap.get(index).compareTo(heap.get(parentIdx)) < 0) break;

            swap(index, parentIdx);
            index = parentIdx;
        }
    }
    public void heapifyDown(int index) {
        int size = heap.size();

        while(index < size) {
            int leftChildIdx = 2 * index + 1;
            int rightChildIdx = 2 * index + 2;
            int largest = index;

            if(leftChildIdx < size && heap.get(leftChildIdx).compareTo(heap.get(largest)) > 0) largest = leftChildIdx;
            if(rightChildIdx < size && heap.get(rightChildIdx).compareTo(heap.get(largest)) > 0) largest = rightChildIdx;

            if(largest == index) break;
            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
}
