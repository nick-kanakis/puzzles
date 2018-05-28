package Trees_Graphs.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 3/12/2017.
 */
public class Graph<T> {
    private List<Node<T>> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void add(Node<T> node) {
        nodes.add(node);
    }

    public void remove(Node<T> node){
        nodes.remove(node);
    }

    public List<Node<T>> getAllNodes(){
        return nodes;
    }

    public int size() {
        return nodes.size();
    }
}
