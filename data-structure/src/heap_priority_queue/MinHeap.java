package heap_priority_queue;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.swap;


public class MinHeap<T extends Comparable<T>> {

    private List<T> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void insert(T t) {
        heap.add(t);
        heapifyUp(heap.size()-1);
    }

    public T poll() {
        if(heap.isEmpty()) return null;

        T value = heap.get(0);
        T last = heap.get(heap.size()-1);
        if(!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return value;
    }
    public T peek() {
        if(heap.isEmpty()) return null;
        return heap.get(0);
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void heapifyUp(int index) {
        while(index > 0) {
            int parentIdx = (index-1) /2;
            if(heap.get(index).compareTo(heap.get(parentIdx)) >= 0) break;

            swap(index, parentIdx);
            index = parentIdx;
        }
    }
    public void heapifyDown(int index) {

        // Initial heap: [1, 3, 6, 8, 5]
        // before heapifyDown
        // [5 3 6 8]
        // leftIdx = 2 * 0 + 1 =1
        // rightIdx = 2 * 0 + 2 = 2
        // smallest = index
                                          //5                        3
        // if(leftIdx < size && heap.get(leftIdx).compareTo(heap.get(smallest)) < 0) smallest = leftIdx;
                                          //5                        6
        // if(rightIdx < size && heap.get(rightIdx).compareTo(heap.get(smallest)) < 0) smallest = rightIdx

        // if(index == smallest) break;
        // swap(index, smallest)
        // index = smallest

        int size = heap.size();

        while(index < size) {
            int leftIdx = 2 * index + 1;
            int rightIdx = 2 * index + 2;
            int smallest = index;

            if(leftIdx < size && heap.get(leftIdx).compareTo(heap.get(smallest)) < 0) smallest = leftIdx;
            if(rightIdx < size && heap.get(rightIdx).compareTo(heap.get(smallest)) < 0) smallest = rightIdx;

            if(smallest == index) break;
            swap(smallest, index);
            index = smallest;

        }
    }

    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);

    }
}
