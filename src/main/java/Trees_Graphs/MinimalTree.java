package Trees_Graphs;

import Trees_Graphs.helper.BinaryTreeNode;

/**
 * (CTCI 4.2) Question:
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
        return helper(array, 0, array.length-1);
    }

    private static BinaryTreeNode<Integer>  helper(int[] array, int start, int end){
        if(start>end){
            return  null;
        }

        int middleIndex = (start + end ) / 2;
        BinaryTreeNode<Integer> parent = new BinaryTreeNode<>(array[middleIndex]);

        parent.left = helper(array, start, middleIndex - 1);
        parent.right = helper(array, middleIndex + 1, end);
        return parent;
    }
}
