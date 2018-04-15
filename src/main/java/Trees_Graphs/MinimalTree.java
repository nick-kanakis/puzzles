package Trees_Graphs;

import Trees_Graphs.helper.BinaryTreeNode;

/**
 * Question:
 *  Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search
 *  tree with minimal height.
 *
 * Mistakes:
 * > SOS --> middle index =  (start + end)/2  NOT (end - start)/2! <-- SOS
 *
 * Solution:
 *  > The middle element of the array is the node of the current level, Recursively we can halve the array, each middle
 *   is the subarray is the node of this level.
 *
 */
public class MinimalTree {
    public static BinaryTreeNode<Integer> constructMinimalBST(int[] array) {
        int middleIndex = (array.length - 1)/2;
        BinaryTreeNode<Integer> parent = new BinaryTreeNode<>(array[middleIndex]);
        helper(array, 0, middleIndex - 1, parent, true);
        helper(array, middleIndex + 1, array.length - 1, parent, false);
        return parent;
    }

    private static void helper(int[] array, int start, int end, BinaryTreeNode<Integer> parent, boolean isLeft){
        if(start>end){
            return;
        }

        int middleIndex = (start + end ) / 2;
        BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(array[middleIndex]);

        if(isLeft){
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        helper(array, start, middleIndex - 1, newNode, true);
        helper(array, middleIndex + 1, end, newNode, false);

    }
}
