package Sorting_Searching;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 13/5/2018.
 */
public class SearchRotatedArrayTest {

    @Test
    public void testSearch() throws Exception {
        int[] input = new int[]{10,11,12,13,14,15,16,1,2,3,4,5};
        int[] inputDup = new int[]{10,11,12,13, 13, 13, 13, 14,15,16,1,2,3,4,5,5,5,5};

        assertEquals(9,SearchRotatedArray.search(input,3));
        assertEquals(2,SearchRotatedArray.search(input,12));
        assertEquals(2,SearchRotatedArray.search(inputDup,12));
        assertEquals(12,SearchRotatedArray.search(inputDup,3));
    }
}
