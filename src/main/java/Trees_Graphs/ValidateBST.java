package Trees_Graphs;

import Trees_Graphs.helper.BinaryTreeNode;

/**
 * Question:
 *  Implement a function to check if a binary tree is a binary search tree
 * Mistakes:
 *  -
 * Solution:
 *  Check if node is within min, max, then recursively check if left child is within (min, node value) and
 *  right child is within (node value, max).
 */
public class ValidateBST {
    public static boolean checkBST(BinaryTreeNode<Integer> root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(BinaryTreeNode<Integer> node, int min, int max){
        if(node == null)
            return true;
        if(node.value < min || node.value > max)
            return false;

        return helper(node.left, min, node.value) && helper(node.right, node.value, max);
    }
}
