package OOD;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 20/4/2018.
 */
public class CircularArrayTest {

    @Test
    public void testCircularArray() throws Exception {
        CircularArray<Integer> ca = new CircularArray<>(5);
        ca.add(0, 1);
        ca.add(1, 2);
        ca.add(2, 3);
        ca.add(3, 4);
        ca.add(4, 5);
        ca.add(4, 6);

        int previous = 0;
        int count = 0;
        for (Integer value : ca) {
            assertTrue(value > previous);
            previous = value;
            count++;
            if(count ==5)
                break;
        }

        ca.shiftRightBy(1);
        assertEquals(new Integer(5), ca.get(0));
        assertEquals(new Integer(1), ca.get(1));
        assertEquals(new Integer(2), ca.get(2));
        assertEquals(new Integer(3), ca.get(3));
        assertEquals(new Integer(4), ca.get(4));

    }
}
