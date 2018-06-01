package Arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Nicolas on 26/5/2018.
 */
public class KthSmallerTest {
    @Test
    public void testKthSmallest() throws Exception {
        int[] input = new int[]{3,12,15,1,1,2,2,2,5,6,7,8,9,10};

        assertArrayEquals(new int[]{1,1,2,2}, KthSmaller.kthSmallest(input, 4));
        assertArrayEquals(new int[]{1,1,2,2,2,3,5,6,7,8}, KthSmaller.kthSmallest(input, 10));
        assertArrayEquals(new int[]{1}, KthSmaller.kthSmallest(input, 1));
    }
}
