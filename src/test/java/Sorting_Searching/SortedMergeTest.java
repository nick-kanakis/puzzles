package Sorting_Searching;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by Nicolas on 13/5/2018.
 */
public class SortedMergeTest {

    @Test
    public void testSortedMerge() throws Exception {
        int[] a = new int[]{3,8,15,0,0,0,0};
        int[] b = new int[]{2,5,7,18};
        SortedMerge.sortedMerge(a,b,2);
        int[] result = new int[]{2,3,5,7,8,15,18};
        assertTrue(Arrays.equals(result,a));
    }

}
