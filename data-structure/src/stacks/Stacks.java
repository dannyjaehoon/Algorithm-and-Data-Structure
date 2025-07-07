package stacks;

public class Stacks {
    private int[] arr;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public Stacks(int size) {
        arr = new int[size];
        capacity =size;
        top = -1;
    }

    public void push(int val) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = val;
    }
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return arr[top--];
    }
    public int peek() {
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
