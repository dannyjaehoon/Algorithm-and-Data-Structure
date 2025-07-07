package stacks;

public class GeneticStacks<T> {
    private T[] arr;
    private int top;
    private int capacity;

    public GeneticStacks(int size) {
        arr = (T[]) new Object[size];
        capacity =size;
        top = -1;
    }

    public void push(T val) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = val;
    }
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];
    }
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty Stack");
        }
        return arr[top];
    }
    public int size() {
        return top + 1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
}
