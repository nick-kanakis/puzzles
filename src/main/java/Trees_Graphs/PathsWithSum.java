package Trees_Graphs;

import Trees_Graphs.helper.BinaryTreeNode;

/**
 * Question:
 *  You are given a binary tree in which each node contains an integer value (positive or negative). Design an algorithm
 *  to count the number of paths that sum to a given value. The path does not need to start or end at the root or a leaf,
 *  but it must go downwards.
 *
 * Mistakes:
 * > Paths of sum can start at all nodes,  DO NOT examine only the case where you start from the root!!!
 *
 * Solution:
 *  > Iterate on both sides the tree, at each node count the paths with given target.
 *    The count of paths starting from a specific node can be done by traversing the tree on both ways, and
 *    recursively adding the sum of node values. If path == target put 1 to the final result else put nothing.
 */
public class PathsWithSum {
    public static int countPathsOfSum(int targetSum, BinaryTreeNode<Integer> node) {
        if(node == null)
            return 0;
        int nodeCount = countSumStartingAt(targetSum, node, 0);
        int rightSum = countPathsOfSum(targetSum, node.right);
        int leftSum = countPathsOfSum(targetSum, node.left);

        return rightSum + leftSum + nodeCount;
    }

    private static int countSumStartingAt(int targetSum, BinaryTreeNode<Integer> node, int currentSum){
        if (node == null)
            return 0;

        currentSum += node.value;
        if( currentSum == targetSum)
            return 1 + countSumStartingAt(targetSum, node.left, currentSum) + countSumStartingAt(targetSum, node.right, currentSum);
        return countSumStartingAt(targetSum, node.left, currentSum) + countSumStartingAt(targetSum, node.right, currentSum);
    }
}
