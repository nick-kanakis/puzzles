package Trees_Graphs;

import Trees_Graphs.helper.BinaryTreeNode;

/**
 * (CTCI 4.10) Question:
 *  T1 & T2 are 2 very large binary trees. T1 is much larger than T2. Create an algorithm to determine if T2 is
 *  a subtree of T1
 *
 * Mistakes:
 *  > Watch when calling recursively use && or || not if statements
 *      checkSubtree(rootT1.right, rootT2) || checkSubtree(rootT1.left, rootT2)
 *      isEqualSubtrees(node1.right, node2.right) && isEqualSubtrees(node1.left, node2.left)
 *
 * Solution:
 *  First search recursively (BOTH SIDES) the tree to find a node that is equal to rootT2.
 *  Then check recursively again on both sides if the subtree and the tree at rootT2 are equal, by comparing each node.
 */
public class CheckSubtree {
    public static boolean checkSubtree(BinaryTreeNode<Integer> rootT1, BinaryTreeNode<Integer> rootT2) {
        if(rootT1 == null || rootT2 == null)
            return false;
        if(rootT1.value == rootT2.value && isEqualSubtrees(rootT1, rootT2))
            return true;
        return checkSubtree(rootT1.right, rootT2) || checkSubtree(rootT1.left, rootT2);
    }

    private static boolean isEqualSubtrees(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2){
        if(node1 == null && node2 == null)
            return true;
        if(node1 == null || node2 == null)
            return false;

        if(node1.value == node2.value){
            return isEqualSubtrees(node1.right, node2.right) && isEqualSubtrees(node1.left, node2.left);
        }
        return false;
    }
}
