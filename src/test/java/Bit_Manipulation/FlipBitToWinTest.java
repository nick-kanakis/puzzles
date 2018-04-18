package Bit_Manipulation;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 18/4/2018.
 */
public class FlipBitToWinTest {
    @Test
    public void testFlipToWin() throws Exception {
        assertEquals(8, FlipBitToWin.flipToWin(1775));
        assertEquals(2, FlipBitToWin.flipToWin(1));
    }
}
