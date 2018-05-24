package Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 23/5/2018.
 */
public class SumSwapTest {
    @Test
    public void testSumAndSwap() throws Exception {
        int[] array1 = new int[]{4, 1, 2, 1, 1, 2};
        int[] array2 = new int[]{3, 6, 3, 3};

        int[] swappedValues = SumSwap.sumAndSwap(array1, array2);

        assertEquals(4, swappedValues[0]);
        assertEquals(6, swappedValues[1]);
    }
}
