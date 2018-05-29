package Recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 25/5/2018.
 */
public class RandomSetTest {
    @Test
    public void testRandomPick() throws Exception {
        int[] input = new int[]{1,2,3,4,5,6,7,8};

        /*Not really a test just validating that the execution will not fail*/
        int[] randomPicks = RandomSet.randomPick(input, 5);

        assertEquals(5,randomPicks.length);
        for (int randomPick : randomPicks ) {
            assertTrue(randomPick>0 && randomPick<9);
        }
    }
}
