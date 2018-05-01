package Recursion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 30/4/2018.
 */
public class RecursiveMultiplyTest {
    @Test
    public void testMultiplyRecursively() throws Exception {
        assertEquals(24, RecursiveMultiply.multiply(3,8));
        assertEquals(35, RecursiveMultiply.multiply(7,5));

    }
}
