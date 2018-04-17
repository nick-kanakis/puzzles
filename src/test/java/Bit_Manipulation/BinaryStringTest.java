package Bit_Manipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 17/4/2018.
 */
public class BinaryStringTest {
    @Test
    public void testPrintBinary() throws Exception {
        assertEquals("0.1010001", BinaryString.printBinary(0.6328125));
        assertEquals("ERROR", BinaryString.printBinary(0.7232323211));
    }
}
