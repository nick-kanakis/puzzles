package LinkedList;

import LinkedList.helper.LinkedListNode;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Nicolas on 31/3/2018.
 */
public class LoopDetectionTest {
    @Test
    public void testLoopDetection() throws Exception {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
        head.next.next.next.next.next = new LinkedListNode(6);
        head.next.next.next.next.next.next = new LinkedListNode(7);
        head.next.next.next.next.next.next.next = new LinkedListNode(8);
        head.next.next.next.next.next.next.next.next = new LinkedListNode(9);
        head.next.next.next.next.next.next.next.next.next = head.next.next.next;


        /*
        *                 8 <- 7  <- 6
        *                 |        /
        *                 9     5
        *                 |  /
        *  1 -> 2 -> 3 -> 4
        *
        * */

        assertEquals(4, LoopDetection.loopDetection(head));
    }
}
