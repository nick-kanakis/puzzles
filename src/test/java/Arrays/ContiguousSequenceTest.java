package Arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 23/5/2018.
 */
public class ContiguousSequenceTest {
    @Test
    public void testMaxContiguousSequence() throws Exception {
        int[] input = new int[]{2, -8, 3, -2, 4, -10};
        assertEquals(5, ContiguousSequence.maxContiguousSequence(input));
    }
}
