package Bit_Manipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 25/5/2018.
 */
public class AddWithoutPlusTest {

    @Test
    public void testAdd() throws Exception {
        assertEquals(5, AddWithoutPlus.add(2, 3));
        assertEquals(15, AddWithoutPlus.add(12, 3));
        assertEquals(41, AddWithoutPlus.add(20, 21));
    }
}
