package Trees_Graphs;

import Trees_Graphs.helper.NameNode;
import Trees_Graphs.helper.NamesGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  (CTCI Q17.7) Question:
 *  Each year the government releases a list of 10.000 most common baby names and their frequencies. The problem is
 *  that some names have multiple spellings. E.G. John, Jon etc. Given 2 lists one names/frequencies and the other with
 *  pair of names write an algorithm to print the new list of the true frequency. Note that if John ~ Jon & Jon ~ Johnny
 *  John and Johnny are synonyms.
 *
 * Mistakes:
 *  - The graph should be a hashmap of node not a list, with key the name and value the node. This will make
 *    the addEdge time efficient.
 *
 * Solution:
 *  1) Create a graph, with the connected nodes being synonyms
 *  2) For each node in the graph, if it is not already visited to a bfs(or dfs) and sum the result of each tree.
 */
public class BabyNames {

    public static HashMap<String, Integer> merge(HashMap<String, Integer> names, String[][] synonyms) {
        NamesGraph graph = createGraph(names, synonyms);
        return mergeTrees(graph);
    }

    private static NamesGraph createGraph(HashMap<String, Integer> names, String[][] synonyms) {

        NamesGraph graph = new NamesGraph();

        //Add nodes to graph
        for (String name : names.keySet()) {
            NameNode node = new NameNode(name, names.get(name));
            graph.addNode(name, node);
        }

        //Connect Edges
        for (int i = 0; i < synonyms.length; i++) {
            graph.addEdge(synonyms[i][0], synonyms[i][1]);
        }
        return graph;
    }

    private static HashMap<String, Integer> mergeTrees(NamesGraph graph) {
        HashMap<String, NameNode> nodes = graph.getNodes();
        HashMap<String, Integer> frequency = new HashMap<>();

        for (NameNode node : nodes.values()) {
            if (node.isVisited()) {
                continue;
            }
            int sumOfOccurrences = bfs(node );
            frequency.put(node.getName(), sumOfOccurrences);
        }
        return frequency;
    }

    private static int bfs(NameNode node) {
        Queue<NameNode> queue = new LinkedList<>();
        queue.add(node);
        int sum = 0;

        while (!queue.isEmpty()) {
            NameNode current = queue.remove();
            current.setVisited(true);
            sum += current.getOccurrences();
            for (NameNode neighbor : current.getNeighbors()) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                }
            }
        }
        return sum;
    }
}
