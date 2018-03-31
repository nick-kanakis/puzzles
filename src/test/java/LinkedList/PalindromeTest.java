package LinkedList;

import LinkedList.helper.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 30/3/2018.
 */
public class PalindromeTest {
    @Test
    public void testIsPermutation() throws Exception {

        LinkedListNode head = new LinkedListNode(1);

        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(3);
        head.next.next.next.next.next = new LinkedListNode(2);
        head.next.next.next.next.next.next = new LinkedListNode(1);
        assertTrue(Palindrome.isPermutation(head));

        head.next.next.next.next.next.next = new LinkedListNode(5);
        assertFalse(Palindrome.isPermutation(head));

        head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(3);
        head.next.next.next.next = new LinkedListNode(2);
        head.next.next.next.next.next= new LinkedListNode(1);
        assertTrue(Palindrome.isPermutation(head));
    }
}
