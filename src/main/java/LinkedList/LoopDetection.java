package LinkedList;

import LinkedList.helper.LinkedListNode;

/**
 * Question:
 *  Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 *  eg:
 *                 8 <- 7  <- 6
 *                 |        /
 *                 9     5
 *                 |  /
 *  1 -> 2 -> 3 -> 4
 *
 *  Result = 4
 *
 * Mistakes:
 *  - When iterating the list do not forget to check --> fast != null && fast.next != null
 *  - If fast == null or fast.next == null there is no loop so return error code.
 *
 * Solution:
 *  Start a slow (1 step) and a fast pointer (2 steps) the collision point is K nodes from the start of the loop.
 *  K nodes from the start of the loop is the original starting node. Move one pointer at the starting point, and the other
 *  on the collision point, move them at the same pace, the node they meet is the start of the loop.
 *
 *  Collision point is K from the start fo the loop because K = mod(k,LOOP_SIZE) where k is the diff of steps between
 *  fast and slow pointer when they enter the loop.
 */
public class LoopDetection {

    public static int loopDetection (LinkedListNode start){
        LinkedListNode slow = start;
        LinkedListNode fast = start;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                //Collision point
                break;
            }
        }

        if(fast == null || fast.next == null){
            return -1;
        }
        fast = start;

        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast.data;
    }
}
