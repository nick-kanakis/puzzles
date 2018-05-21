package Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 20/5/2018.
 */
public class SmallestDifferenceTest {

    @Test
    public void testGetMinDifference() throws Exception {
        int[] array1 = new int[]{1,2,11,15};
        int[] array2 = new int[]{4,12,19,23,127,235};

        int[] array3 = new int[]{1,3,15,11, 2};
        int[] array4 = new int[]{23,127,235,19,8};

        SmallestDifference.Difference correctDiff = new SmallestDifference.Difference(11, 12, 1);
        SmallestDifference.Difference correctDiff2 = new SmallestDifference.Difference(11, 8, 3);

        assertEquals(correctDiff, SmallestDifference.getMinDifference(array1, array2));
        assertEquals(correctDiff2, SmallestDifference.getMinDifference(array3, array4));
    }
}
