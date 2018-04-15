package Trees_Graphs;

import Trees_Graphs.helper.BinaryTreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nicolas on 1/12/2017.
 */
public class MinimalTreeTest {

    @Test
    public void testConstructMinimalBST() throws Exception {
        int[] array = {1, 2, 3, 4, 5, 6};
        BinaryTreeNode<Integer> root = MinimalTree.constructMinimalBST(array);
        assertEquals(new Integer(1), root.left.value);
        assertEquals(new Integer(5), root.right.value);
        assertEquals(new Integer(2), root.left.right.value);
        assertEquals(new Integer(4), root.right.left.value);
        assertEquals(new Integer(6), root.right.right.value);

        array = new int[]{1, 2, 3, 4, 5, 6, 7};
        root = MinimalTree.constructMinimalBST(array);

        assertEquals(new Integer(2), root.left.value);
        assertEquals(new Integer(6), root.right.value);
        assertEquals(new Integer(1), root.left.left.value);
        assertEquals(new Integer(3), root.left.right.value);
        assertEquals(new Integer(5), root.right.left.value);
        assertEquals(new Integer(7), root.right.right.value);
    }
}
