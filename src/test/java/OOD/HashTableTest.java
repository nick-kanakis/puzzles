package OOD;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 * Created by Nicolas on 20/4/2018.
 */
public class HashTableTest {

    @Test
    public void testHashTable()throws Exception{
        HashTable<Integer, String> htable = new HashTable<>();

        for (int i = 0; i < 50; i++) {
            htable.put(i, "The key is: "+i);
        }

        assertEquals("The key is: 20", htable.get(20));
        assertEquals("The key is: 0", htable.get(0));
        assertEquals("The key is: 49", htable.get(49));

        htable.remove(20);
        assertNull(htable.get(20));
    }
}
