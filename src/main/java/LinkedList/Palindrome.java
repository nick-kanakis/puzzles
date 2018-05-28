package LinkedList;

import LinkedList.helper.LinkedListNode;

import java.util.Stack;

/**
 * (CTCI 2.6) Question:
 * Implement a function to check if a linked list is a palindrome.
 * <p>
 * Mistakes:
 * - A palindrome is not ANAN but ANNA (this is a permutation)
 * - We do not need to know the size of the list we can use the fast/slow pointer technique.
 * - Do not forget to move the slow/fast pointer (and cause an infinite loop)
 * - Watch for null pointer exc. when working with slow/fast ptr
 * <p>
 * Solution:
 * - You can reverse the linked list and compare both lists
 * - You can use a stack and store half elements in the stack, and compare them
 *      1) use slow/fast technique to find the middle (slow ptr will be at the middle)
 *      2) push remaining elements of slow ptr to a stack
 *      3) compare stack elements with original list.
 */
public class Palindrome {

    public static boolean isPermutation(LinkedListNode head) {
        Stack<Integer> stack = new Stack<Integer>();

        LinkedListNode fast = head;
        LinkedListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //Slow ptr is at the middle
        while (slow != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        while (!stack.empty()) {
            if (head.data != stack.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

}
