package Sorting_Searching;

import Sorting_Searching.SubSort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 22/5/2018.
 */
public class SubSortTest {
    @Test
    public void testSubSort() throws Exception {
        int[] input = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        int[] startEndPoints = SubSort.subSort(input);

        assertEquals(3, startEndPoints[0]);
        assertEquals(9, startEndPoints[1]);
    }
}
