package Trees_Graphs.helper;

import java.util.HashMap;

/**
 * Created by Nicolas on 26/5/2018.
 */
public class NamesGraph {
    private HashMap<String, NameNode> map;

    public NamesGraph() {
        map = new HashMap<>();
    }

    public boolean addNode(String name, NameNode node){
        return map.put(name, node)!=null;
    }

    public NameNode getNode(String name){
        return map.get(name);
    }

    public HashMap<String, NameNode> getNodes() {
        return map;
    }

    public void addEdge(String name1, String name2){
        NameNode node1 = map.get(name1);
        NameNode node2 = map.get(name2);

        node1.addNeighbor(node2);
        node2.addNeighbor(node1);
    }
}
