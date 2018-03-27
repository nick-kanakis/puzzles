package Arrays;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 26/3/2018.
 */
public class OneAWayTest {

    @Test
    public void testOneAway(){
        assertTrue(OneAway.isOneAway("sale", "sale"));
        assertTrue(OneAway.isOneAway("sale", "sake"));
        assertTrue(OneAway.isOneAway("sale", "sales"));
        assertTrue(OneAway.isOneAway("sale", "kale"));
        assertTrue(OneAway.isOneAway("sale", "sal"));
        assertTrue(OneAway.isOneAway("sale", "satle"));
        assertFalse(OneAway.isOneAway("sale", "satls"));
        assertFalse(OneAway.isOneAway("sale", "salis"));
        assertFalse(OneAway.isOneAway("sale", "sat"));
    }
}
