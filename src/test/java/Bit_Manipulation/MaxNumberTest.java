package Bit_Manipulation;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 21/5/2018.
 */
public class MaxNumberTest {
    @Test
    public void testfindMax() throws Exception {
        assertEquals(10, MaxNumber.findMax(3,10));
        assertEquals(10, MaxNumber.findMax(10,7));
    }
}
