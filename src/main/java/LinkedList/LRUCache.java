package LinkedList;

import LinkedList.helper.DoubleLinkedListNode;

import java.util.HashMap;
import java.util.Objects;

/**
 * (CTCI 16.25) Question:
 *  Design and build a least recently used cache, which evicts the least recently used item. The cache should be map from
 *  key to valeue an be initialized with a max size. When it is full the least recently used item should be evicted.
 *
 * Mistakes:
 *  - When head = null do not forget to return at the end (and also increase the current size)!
 *  - When moving to head a node do not remove this one and create another one, this create inconsistencies.
 *    Also if this node is tail update tail!
 *
 * Solution:
 *  1) Create double linked list to hold the sequence the value are added to the cache, also have a hashmap with value
 *  the node. This will be our cache that has constant access time. Keep track of the head,tail of the list for access to
 *  most/least recently accessed elements
 *
 *  2) When inserting a value check for the maxsize, insert the node in head of the list and the hashmap. If current size ==
 *     max size, remove the tail of the list (from the list and the map) this is the least recently accessed element.
 *
 *  3) When retrieving a value move this value to the top of the list, do not forget to update the tail if this object
 *     is the tail.
 *
 */
public class LRUCache {
    int maxSize = 0;
    int currentSize = 0;
    HashMap<String, DoubleLinkedListNode> cache = new HashMap<>();
    DoubleLinkedListNode head = null;
    DoubleLinkedListNode tail = null;

    public LRUCache(int maxSize) {
        this.maxSize=maxSize;
    }

    public void insert(String key, String value) {
        if(head == null){
            head = new DoubleLinkedListNode(key, value);
            tail = head;
            cache.put(key, head);
            currentSize++;
            return;
        }

        if(currentSize == maxSize){
            removeOldestValue();
            currentSize--;
        }

        addNewHead(key, value);
        cache.put(key, head);

        currentSize++;
    }

    private void removeOldestValue() {
        cache.remove(tail.getKey());

        tail.previous.next = null;
        tail = tail.previous;
    }

    private void addNewHead(String key, String value){
        DoubleLinkedListNode newTop = new DoubleLinkedListNode(key,value);
        head.previous = newTop;
        newTop.next = head;
        head = newTop;
    }

    public String get(String key) {
        if(!cache.containsKey(key))
            return "";
        moveNodeToHead(key);
        return head.getValue();
    }

    private void moveNodeToHead(String key) {
        if(Objects.equals(head.getKey(), key))
            return;

        DoubleLinkedListNode newTop = cache.get(key);
        if(newTop.equals(tail)){
            tail = tail.previous;
        }
        newTop.previous.next = newTop.next;
        head.previous = newTop;
        newTop.next = head;
        head = newTop;


    }

}
