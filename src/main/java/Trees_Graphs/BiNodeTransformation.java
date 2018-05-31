package Trees_Graphs;

import Trees_Graphs.helper.BiNode;
import Trees_Graphs.helper.BiNodePair;

/**
 * (CTCI Q17.12) Question:
 *  Consider a simple data structure called BiNode, which has pointers to other nodes, Given a binary tree (constructed
 *  by BiNode) create double linked list. The values should be kept in order and should be performed in place.
 *
 * Mistakes:
 *  - What's out for leafs that return null!!
 *
 * Solution:
 *  What we need at each step is the head and the tail of the linked list sto far. At right subtree connect the root
 *  with the head, and at the left subtree connect the root with the tail.
 *
 *  1) recursive call left & right subtree (if there is no right & left subtree the results will be null)
 *  2) If leftPart is not null, we have a double linked list (with at least one element) connect the tail of the list
 *     with the root.
 *  3) If rightPart is not null, we have a double linked list (with at least one element) connect the head of the list
 *     with the root.
 *  4) Return a new pair with the head and tail of this levels linked list, the head is the head of the left part
 *     and the tail is the tail of the right part (if any of those parts is null add the root as head/tail!!
 */
public class BiNodeTransformation {
    public static BiNodePair convertBST2DoubleLL(BiNode root) {
        if (root == null)
            return null;

        BiNodePair leftPair = convertBST2DoubleLL(root.node1);
        BiNodePair rightPair = convertBST2DoubleLL(root.node2);

        //LEFT SUBTREE
        if (leftPair != null){
            root.node1 = leftPair.tail;
            leftPair.tail.node2 = root;
        }
        //RIGHT SUBTREE
        if(rightPair != null){
            root.node2 = rightPair.head;
            rightPair.head.node1 = root;
        }

        BiNode head = leftPair == null? root: leftPair.head;
        BiNode tail = rightPair == null? root: rightPair.tail;

        return new BiNodePair(head, tail);
    }
}
