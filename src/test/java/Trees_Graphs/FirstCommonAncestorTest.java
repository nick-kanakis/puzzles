package Trees_Graphs;

import Trees_Graphs.helper.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 16/4/2018.
 */
public class FirstCommonAncestorTest {
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
    public void testFindFirstAncestor() throws Exception {
        assertEquals(new Integer(2), FirstCommonAncestor.findCommonAncestor(node1, node7, node8).value);
        assertEquals(new Integer(1), FirstCommonAncestor.findCommonAncestor(node1, node7, node6).value);
        assertEquals(new Integer(3), FirstCommonAncestor.findCommonAncestor(node1, node3, node6).value);
    }
}
