package Trees_Graphs.helper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nicolas on 1/12/2017.
 */
public class Node<T> {

    public boolean visited;
    public int depth;
    public T value;
    public List<Node<T>> neighbors;

    public Node( T value) {
        this.visited = false;
        this.value = value;
        this.neighbors = new LinkedList<>();
    }

    public void addNeighbor(Node<T> node){
        this.neighbors.add(node);
    }

}
