package Trees_Graphs;

import Trees_Graphs.helper.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 4/12/2017.
 */
public class PathsWithSumTest {

    private BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
    private BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(-2);
    private BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(4);
    private BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
    private BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
    private BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
    private BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(2);
    private BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(4);

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
    public void testCountPathsOfSum() throws Exception {
        assertEquals(1, PathsWithSum.countPathsOfSum(7, node1));
        assertEquals(3, PathsWithSum.countPathsOfSum(5, node1));
    }
}
