package OOD;

import java.util.ArrayList;

/**
 * Question:
 *  Design and implement a hash table which uses chaining.
 *
 * Mistakes:
 *
 * Solution:
 *  Create a array of array lists (bucket).
 *  For hash function we use the hashcode of K.
 *
 */
public class HashTable<K,V> {
    private class SavedItem{
        public K key;
        public V value;

        public SavedItem(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    int size = 20;
    ArrayList<SavedItem>[] buckets = new ArrayList[size];

    public void put(K key, V value){
        int bucketIndex = hashFunction(key);
        if(buckets[bucketIndex] == null){
            buckets[bucketIndex] = new ArrayList<>();
        }
        buckets[bucketIndex].add(new SavedItem(key, value));
    }

    public void remove(K key){
        int bucketIndex = hashFunction(key);
        if(buckets[bucketIndex] != null){
            for (int i = 0; i < buckets[bucketIndex].size(); i++) {
                SavedItem item = buckets[bucketIndex].get(i);
                if(item.key.equals(key))
                    buckets[bucketIndex].remove(i);
            }
        }
    }

    public V get(K key){
        int bucketIndex = hashFunction(key);
        if(buckets[bucketIndex] != null){
            for (int i = 0; i < buckets[bucketIndex].size(); i++) {
                 SavedItem item = buckets[bucketIndex].get(i);
                if(item.key.equals(key))
                    return item.value;
            }
        }
        return null;
    }

    private int hashFunction(K key){
        return key.hashCode()%size;
    }
}
