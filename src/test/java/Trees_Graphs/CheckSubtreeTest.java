package Trees_Graphs;

import Trees_Graphs.helper.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Nicolas on 3/12/2017.
 */
public class CheckSubtreeTest {

    private BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
    private BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
    private BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
    private BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
    private BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
    private BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
    private BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);
    private BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(8);

    @Before
    public void setUp() throws Exception {
        node1.left = node2;
        node1.right = node3;
        node3.right = node6;
        node2.left = node4;
        node2.right = node5;
        node4.right = node7;
        node5.left = node8;
    }

    @Test
    public void testCheckSubtree() throws Exception {
        assertTrue(CheckSubtree.checkSubtree(node1, node2));
    }

    @Test
    public void testCheckSubtreeShouldFail() throws Exception {
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(12);
        BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(8);

        node2.left = node4;
        node2.right = node5;
        node4.right = node7;
        node5.left = node8;
        assertFalse(CheckSubtree.checkSubtree(node1, node2));
    }
}
