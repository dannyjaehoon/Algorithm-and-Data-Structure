package hash_map_and_hash_table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HashMap<K,V> {

    private class Entry<K,V> {
        K key;
        V value;

        Entry<K,V> entry;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private int size;
    private List<Entry<K,V>>[] table;

    @SuppressWarnings("unchecked")
    public HashMap() {
        this.capacity = 16;
        this.size = 0;
        this.table = (List<Entry<K,V>>[]) new ArrayList[capacity];

        for(int i = 0; i < capacity; i++) {
            table[i] = new ArrayList<Entry<K,V>>();
        }
    }

    public void put(K key, V value) {
        int idx = hashCode(key);

        for (Entry<K, V> entry : table[idx]) {
            if (entry.key.equals(key)) {
                entry.value = value; // 기존 값 덮어쓰기
                return;
            }
        }

        table[idx].add(new Entry<K,V>(key, value));
        size++;
    }

    public V get(K key) {
        int idx = hashCode(key);

        if(table[idx].size() != 0) {
            for(Entry<K,V> entry : table[idx]) {
                if(entry.key.equals(key)) return entry.value;
            }
        }
        return null;
    }

    public V remove(K key) {
        if(size == 0) return null;
        int idx = hashCode(key);

        int size = table[idx].size();
        for(int i = 0; i < size; i++) {
            if(table[idx].get(i).key.equals(key)) {
                Entry<K,V> entry = table[idx].get(i);
                table[idx].remove(i);
                size--;
                return entry.value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }
    public int size() {
        return size;
    }

    private int hashCode(K key) {
        return Math.abs(key.hashCode()) % this.capacity;
    }
}
