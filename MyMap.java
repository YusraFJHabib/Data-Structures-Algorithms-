import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public interface MyMap<K, V> {

    private final int TABLE_SIZE = 10; 
    private List<Entry<K, V>>[] table; 
    public MyMap() {

        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % TABLE_SIZE;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        List<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; 
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        List<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }


    public void remove(K key) {
        int index = getIndex(key);
        List<Entry<K, V>> bucket = table[index];
        bucket.removeIf(entry -> entry.key.equals(key));
    }

    public void print() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            for (Entry<K, V> entry : table[i]) {
                System.out.println(entry.key + " => " + entry.value);
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