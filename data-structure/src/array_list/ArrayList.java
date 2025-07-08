package array_list;

public class ArrayList<T> {
    T[] arr;
    int size;
    int capacity;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.capacity = 16;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];
    }

    public void add(T value) {
        if (size == capacity) {
            resize();
        }
        arr[size++] = value;
    }

    public void add(int index, T value) {
        if (size == capacity) resize();
        if(index < 0 || index > size) throw new IndexOutOfBoundsException();

        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = value;
        size++;
    }

    public T remove() {
        if (size == 0) throw new ArrayIndexOutOfBoundsException();
        T value = arr[--size];
        arr[size] = null;
        return value;
    }

    public T remove(int index) {
        if (size == 0 || index <0 || index > size) throw new ArrayIndexOutOfBoundsException();
        T value = arr[index];

        System.arraycopy(arr, index + 1, arr, index, size - index - 1);
        arr[--size] = null;
        return value;
    }

    public T get(int index) {
        if(size == 0 || index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException();
        return arr[index];
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = Math.max(capacity + 1, (int)(capacity * 1.5));
        T[] newArr = (T[]) new Object[newCapacity];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
        capacity = newCapacity;
    }
}
