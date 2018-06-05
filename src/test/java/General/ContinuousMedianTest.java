package General;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 27/5/2018.
 */
public class ContinuousMedianTest {
    @Test
    public void testFindMedian() throws Exception {
        ContinuousMedian cm = new ContinuousMedian();

        cm.addElement(1);
        cm.addElement(2);
        assertEquals(1, cm.findMedian());
        cm.addElement(3);
        assertEquals(2, cm.findMedian());
        cm.addElement(4);
        assertEquals(2, cm.findMedian());
        cm.addElement(10);
        assertEquals(3, cm.findMedian());
        cm.addElement(15);
        assertEquals(3, cm.findMedian());
        cm.addElement(20);
        assertEquals(4, cm.findMedian());
        cm.addElement(11);
        assertEquals(7, cm.findMedian());
        cm.addElement(12);
        assertEquals(10, cm.findMedian());
        cm.addElement(0);
        assertEquals(7, cm.findMedian());


    }
}
