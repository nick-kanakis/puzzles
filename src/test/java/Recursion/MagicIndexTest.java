package Recursion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 30/4/2018.
 */
public class MagicIndexTest {
    @Test
    public void testFindMagicIndex() throws Exception {
        int[]array1 = new int[]{-1, 1, 3, 4, 5, 6, 7, 10};
        int[]array2 = new int[]{-1, 0, 1, 2, 3, 5, 8};
        int[]arrayDuplicates = new int[]{-1,0,0,2,5,5,5,5};

        assertEquals(1, MagicIndex.findMagicIndex(array1));
        assertEquals(5, MagicIndex.findMagicIndex(array2));
        assertEquals(5, MagicIndex.findMagicIndex(arrayDuplicates));
    }
}
