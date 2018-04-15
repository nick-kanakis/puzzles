package Trees_Graphs.helper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nicolas on 1/12/2017.
 */
public class BinaryTreeNode<T> {

    public boolean visited = false;
    public T value;
    public BinaryTreeNode<T> left = null;
    public BinaryTreeNode<T> right = null;
    public BinaryTreeNode<T> parent = null;

    public BinaryTreeNode(T value) {
        this.value = value;
    }
    }
