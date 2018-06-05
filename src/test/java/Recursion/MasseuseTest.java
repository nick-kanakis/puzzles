package Recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 27/5/2018.
 */
public class MasseuseTest {
    @Test
    public void testMaxMinutesRecursively() throws Exception {
        int[] appointments = new int[]{30, 15, 60, 75,45, 15, 15, 45};
        assertEquals(180, Masseuse.maxMinutesRecursively(appointments));
    }
}
