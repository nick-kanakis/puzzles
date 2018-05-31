package Trees_Graphs.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 26/5/2018.
 */
public class NameNode {
    private String name;
    private int occurrences;
    private boolean visited;
    private List<NameNode> neighbors;

    public NameNode(String name, int occurrences) {
        this.name = name;
        this.occurrences = occurrences;
        visited = false;
        neighbors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<NameNode> getNeighbors(){
        return neighbors;
    }

    public void addNeighbor(NameNode node){
        neighbors.add(node);
    }
}
