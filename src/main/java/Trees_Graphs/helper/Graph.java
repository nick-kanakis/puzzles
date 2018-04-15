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

    public void add(Node<T> project) {
        nodes.add(project);
    }

    public void remove(Node<T> project){
        nodes.remove(project);
    }

    public List<Node<T>> getAllNodes(){
        return nodes;
    }

    public int size() {
        return nodes.size();
    }
}
