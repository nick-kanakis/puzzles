package Sorting_Searching.RankFromStream;

/**
 * Question:
 *  You are reading a stream of integers. Implement the method track(int x) which is called each time a new number is
 *  generated, and the method gtRankOfNumber(int x) which returns the number of values less than or equal to x (excluding x)
 *
 * Mistakes:
 *
 *
 * Solution:
 *  Create a BST that each node represent a generated number.
 *
 *  When a new number is generated we call track(int number) this function inserts the number in the tree. It starts from the root
 *  and updates the size of the left subtree every time the number is less than the node. If the node exists it just update the leftSubtreeCount
 *  value, if it is not exist, we need to add a new node.
 *
 *  When we need to know the rank of a number we call getRankOfNumber(int number) and we search for the number in the tree.
 *  Every time we go right we count the size of all left subtrees as well as the size of the node.
 */
public class RankFromStream {
    private static RankNode root;

    public static void track(Integer value) {
        if (root == null) {
            root = new RankNode(value);
        } else {
            root.insert(value);
        }
    }

    public static int getRankOfNumber(int target) {
        return getRankHelper(root, target);
    }

    private static int getRankHelper( RankNode current, int target){
        if( current == null)
            return -1;

        if(current.value == target)
            return current.leftSubtreeCount;
        else if(current.value < target){
            return getRankHelper(current.right, target) + current.leftSubtreeCount;
        } else {
            return getRankHelper(current.left, target) ;
        }
    }
}
