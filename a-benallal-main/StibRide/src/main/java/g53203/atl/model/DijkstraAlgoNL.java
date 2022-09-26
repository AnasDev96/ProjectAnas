/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g53203.atl.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class DijkstraAlgoNL {
       /**
     * Algo get from https://www.baeldung.com/java-dijkstra
     * @param graph
     * @param source
     * @return
     */
    public static Graph calculateShortestPathFromSource(Graph graph, NodeNL source) {

        source.setDistance(0);

        Set<NodeNL> settledNodes = new HashSet<>();
        Set<NodeNL> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {

            NodeNL currentNode = getLowestDistanceNode(unsettledNodes);

            unsettledNodes.remove(currentNode);

            for (Map.Entry< NodeNL, Integer> adjacencyPair
                    : currentNode.getAdjacentNodes().entrySet()) {

                NodeNL adjacentNode = adjacencyPair.getKey();
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
    private static NodeNL getLowestDistanceNode(Set< NodeNL> unsettledNodes) {
        NodeNL lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (NodeNL node : unsettledNodes) {
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
    private static void calculateMinimumDistance(NodeNL evaluationNode,
            Integer edgeWeigh, NodeNL sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<NodeNL> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
