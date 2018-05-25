package LinkedList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 24/5/2018.
 */
public class LRUCacheTest {
    @Test
    public void testCacheInvalidation() throws Exception {
        LRUCache cache = new LRUCache(3);
        cache.insert("key1", "value1");
        cache.insert("key2", "value2");
        cache.insert("key3", "value3");
        /*
        * CACHE NOW
        * Newest
        * ------
        * 3
        * 2
        * 1
        * ------
        * Oldest
        * */

        assertEquals("value1", cache.get("key1"));
        assertEquals("value2", cache.get("key2"));
        assertEquals("value3", cache.get("key3"));

        cache.insert("key4", "value4");

        /*
        * CACHE NOW
        * Newest
        * ------
        * 4
        * 3
        * 2
        * ------
        * Oldest
        * */

        assertEquals("value2", cache.get("key2"));
        assertEquals("value3", cache.get("key3"));
        assertEquals("value4", cache.get("key4"));
        assertEquals("", cache.get("key1"));

        cache.get("key2");

        /*
        * CACHE NOW
        * Newest
        * ------
        * 2
        * 4
        * 3
        * ------
        * Oldest
        * */

        cache.insert("key5", "value5");

        /*
        * CACHE NOW
        * Newest
        * ------
        * 5
        * 2
        * 4
        * ------
        * Oldest
        * */

        assertEquals("", cache.get("key3"));
        assertEquals("value5", cache.get("key5"));
        assertEquals("value4", cache.get("key4"));
        assertEquals("value2", cache.get("key2"));

        cache.get("key2");
        /*
        * CACHE NOW
        * Newest
        * ------
        * 2
        * 5
        * 4
        * ------
        * Oldest
        * */

        assertEquals("value4", cache.get("key4"));
        assertEquals("value5", cache.get("key5"));
        assertEquals("value2", cache.get("key2"));

        cache.insert("key6", "value6");
        /*
        * CACHE NOW
        * Newest
        * ------
        * 6
        * 2
        * 5
        * ------
        * Oldest
        * */

        assertEquals("", cache.get("key4"));
        assertEquals("value5", cache.get("key5"));
        assertEquals("value2", cache.get("key2"));
        assertEquals("value6", cache.get("key6"));
    }
}
