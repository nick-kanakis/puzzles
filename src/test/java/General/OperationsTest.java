package General;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 21/5/2018.
 */
public class OperationsTest {
    @Test
    public void testMultiply() throws Exception {
        assertEquals(15, Operations.multiply(3,5));
        assertEquals(-6, Operations.multiply(-3,2));
        assertEquals(-6, Operations.multiply(2,-3));
        assertEquals(6, Operations.multiply(-2,-3));
        assertEquals(24, Operations.multiply(12,2));
    }

    @Test
    public void testDivide() throws Exception{
        assertEquals(5, Operations.divide(15,3));
        assertEquals(6, Operations.divide(13,2));
        assertEquals(3, Operations.divide(-15,-5));
        assertEquals(-3, Operations.divide(-15,5));
    }

    @Test
    public void testSubtract() throws Exception{
        assertEquals(12, Operations.subtract(15,3));
        assertEquals(-11, Operations.subtract(2,13));
    }
}
