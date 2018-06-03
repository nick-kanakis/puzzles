package Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 27/5/2018.
 */
public class ShortestSupersequenceTest {
    @Test
    public void testShortestSupersequence() throws Exception {
        int[] small = new int[]{1,5,9};
        int[] big = new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};

        assertEquals(4, ShortestSupersequence.minDistance(big, small));
    }
}
