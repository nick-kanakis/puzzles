package General;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 26/5/2018.
 */
public class KthMultiplyTest {
    @Test
    public void testGetKthMultiply() throws Exception {
        assertEquals(35, KthMultiple.getKthMultiply(9));
        assertEquals(45, KthMultiple.getKthMultiply(10));
        assertEquals(49, KthMultiple.getKthMultiply(11));
    }
}
