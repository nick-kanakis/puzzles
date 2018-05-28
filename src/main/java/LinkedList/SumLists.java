package LinkedList;

import LinkedList.helper.LinkedListNode;

/**
 * (CTCI 2.5) Question:
 *  You have 2 numbers represented by a linked list, each node contains a single digit. Write a function that adds the two
 *  numbers returns the sum as a linked list.
 *
 * Mistakes:
 *  - Do not try to solve it without recursion!!!
 *  - Calculate the length diff and pad zeros in the front so both lists are the same length
 *  - When the result from the recursive function returns, remember to add the carry
 *
 * Solution:
 *  1) Make both lists the same size by adding zeros
 *  2) Recursively (from end to start) add elements and keep track of the carry
 *      2.1) When adding a new element the result should be the new head (As we go from end to start)
 */
public class SumLists {

    private static class SumHelper{
        LinkedListNode head;
        boolean carry;

        public SumHelper(int value, boolean carry) {
            head = new LinkedListNode(value);
            this.carry = carry;
        }

        public SumHelper addHead(int value, boolean carry){
            LinkedListNode node = new LinkedListNode(value);
            node.next = head;
            head = node;
            this.carry = carry;
            return this;
        }
    }


    public static LinkedListNode sumListsForwardOrder(LinkedListNode node1, LinkedListNode node2) {
        int length1 = lengthOfList(node1);
        int length2 = lengthOfList(node2);

        if (length1 > length2) {
            node2 = addZerosToListHead(node2, length1 - length2);
        } else if (length2 > length1) {
            node1 = addZerosToListHead(node1, length2 - length1);
        }


        SumHelper helperResult = sumListsForwardOrderHelper(node1, node2);

        if (helperResult.carry) {
            LinkedListNode node = new LinkedListNode(1);
            node.next = helperResult.head;
            return node;
        } else {
            return helperResult.head;
        }
    }

    private static SumHelper sumListsForwardOrderHelper(LinkedListNode node1, LinkedListNode node2){
        if (node1.next == null && node2.next == null){
            int result = node1.data + node2.data;
            if (result >9) {
                return new SumHelper(result%10, true);
            } else {
                return new SumHelper(result, false);
            }
        }
        SumHelper previousResult = sumListsForwardOrderHelper(node1.next, node2.next);

        int carry = previousResult.carry ? 1: 0;
        int result = node1.data + node2.data + carry ;
        if (result >9) {
            return previousResult.addHead(result%10, true);
        } else {
            return previousResult.addHead(result, false);
        }
    }

    private static int lengthOfList(LinkedListNode current) {
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    private static LinkedListNode addZerosToListHead(LinkedListNode head, int zerosNumber) {
        if (zerosNumber < 1)
            return head;

        LinkedListNode newHead = null;
        for (int i = 0; i < zerosNumber; i++) {
            newHead = new LinkedListNode(0);
            newHead.next = head;
        }
        return newHead;
    }
}
