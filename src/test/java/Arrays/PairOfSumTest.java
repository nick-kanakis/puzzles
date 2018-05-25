package Arrays;

import General.helper.Pair;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 24/5/2018.
 */
public class PairOfSumTest {

    @Test
    public void testFindPairs() throws Exception {
        int[] input = new int[]{1, 2, 3, 8, 2, 4};

        ArrayList<Pair> pairs1 = PairOfSum.findPairs(input, 3);
        assertEquals(1, pairs1.size());
        assertTrue(pairs1.contains(new Pair(1,2)));
        ArrayList<Pair> pairs2 = PairOfSum.findPairs(input, 4);
        assertEquals(2, pairs2.size());
        assertTrue(pairs2.contains(new Pair(1,3)));
        assertTrue(pairs2.contains(new Pair(2,2)));
    }
}
