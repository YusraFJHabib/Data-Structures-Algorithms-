import java.util.LinkedList;

public class MyHashMap<K, V> implements MyMap<K, V> {
    private final int TABLE_SIZE = 16; 
    private LinkedList<Entry<K, V>>[] table; 

    public MyHashMap() {
        
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % TABLE_SIZE;
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; 
                return;
            }
        }

        bucket.add(new Entry<>(key, value)); 
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry:bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }
    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];
        bucket.removeIf(entry -> entry.key.equals(key));
    }

    public void print() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (Entry<K, V> entry : table[i]) {
                System.out.println(entry.key + "=>" + entry.value);
            }
        }
    }
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
