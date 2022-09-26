package g53203.atl.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class DijkstraAlgo {

    /**
     * Algo get from https://www.baeldung.com/java-dijkstra
     * @param graph
     * @param source
     * @return
     */
    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {

        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {

            Node currentNode = getLowestDistanceNode(unsettledNodes);

            unsettledNodes.remove(currentNode);

            for (Entry< Node, Integer> adjacencyPair
                    : currentNode.getAdjacentNodes().entrySet()) {

                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();

                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }

        return graph;
    }

    /**
     * Algo get from https://www.baeldung.com/java-dijkstra
     * @param unsettledNodes
     * @return
     */
    private static Node getLowestDistanceNode(Set< Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    /**
     * Algo get from https://www.baeldung.com/java-dijkstra
     * @param evaluationNode
     * @param edgeWeigh
     * @param sourceNode
     */
    private static void calculateMinimumDistance(Node evaluationNode,
            Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
