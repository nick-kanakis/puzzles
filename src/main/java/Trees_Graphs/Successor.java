package Trees_Graphs;

import Trees_Graphs.helper.BinaryTreeNode;

/**
 * (CTCI 4.6) Question:
 *  Write an algorithm to find the "next" node (in-order successor) of a given node in a
 *  bst.
 *
 * Mistakes:
 *  -
 * Solution:
 *  if right child is not null
 *      find the min value of the right subtree,
 *  else
 *      Go up until we are on left side instead of right.
 */
public class Successor {
    public static int findNextNode(BinaryTreeNode<Integer> node) {
        if (node.right != null){
            return findMinNode(node.right);
        }

        //find the first left parent
        while (node.parent != null && node.parent.right == node){
            node = node.parent;
        }
        if (node.parent != null)
            return node.parent.value;


        return -1;
    }

    public static int findMinNode(BinaryTreeNode<Integer> node){
        while(node.left != null){
            node = node.left;
        }
        return node.value;
    }
}
