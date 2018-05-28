package Trees_Graphs;

import Trees_Graphs.helper.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * (CTCI 4.8) Question:
 *   Design an algorithm and write code to find the first common ancestor of 2 nodes in a binary tree. Avoid storing
 *   additional nodes in a DS. This may not be a BST. (Also assume we have no access to the parent)
 *
 * Mistakes:
 *  > Take into consideration that one node may cover the other so this node is the first common ancestor (FCA).
 *    This means that the 2 nodes are in the same tree
 *
 * Solution:
 *   Start from the root if the nodes are on different subtrees then root is the FCA. If they are
 *   in the same subtree recursively call the function but instead of root pass the root of the subtree the 2 nodes belong.
 */
public class FirstCommonAncestor {
    public static BinaryTreeNode<Integer> findCommonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {
        int right = numOfContainingNodes(root.right, node1, node2);
        int left = numOfContainingNodes(root.left, node1, node2);

        if(right == 1 && left == 1)
            return root;

        //In case right node  == node1 or node2 and covers node2 or node1 respectively.
        if(right == 1 && left == 0)
            return root.right;

        //In case left node  == node1 or node2 and covers node2 or node1 respectively.
        if(right == 0 && left == 1)
            return root.left;

        if(right == 2){
           return findCommonAncestor(root.right, node1, node2);
        }

        if(left == 2){
           return findCommonAncestor(root.left, node1, node2);
        }
        return null;
    }

    private static int numOfContainingNodes(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2){
        int found = 0;

        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryTreeNode<Integer> current = queue.remove();
            if(current.right == node1 || current.left == node1){
                found++;
            }
            if(current.right == node2 || current.left == node2){
                found++;
            }
            if(found == 2)
                return found;

            if(current.left != null){
                queue.add(current.left);
            }if(current.right != null){
                queue.add(current.right);
            }
        }

        return found;
    }
}
