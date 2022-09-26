package g53203.atl.model;

import g53203.atl.dto.StationsDto;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class Node {

    private final StationsDto stations;
    private  List<Node> shortestPath;
    private int distance = Integer.MAX_VALUE;
    private final Map<Node, Integer> adjacentNodes;

    /**
     * Simple constructor of Node 
     * @param stations
     */
    public Node(StationsDto stations) {
        this.stations = stations;
        adjacentNodes = new HashMap<>();
        shortestPath = new LinkedList<>();
    }

    /**
     * Method for add disctance for each node
     * @param destination
     * @param distance
     */
    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    /**
     * Simple getter of stations
     * @return StationsDto
     */
    public StationsDto getStations() {
        return stations;
    }

    /**
     * Simple getter
     * @return List of Node
     */
    public List<Node> getShortestPath() {
        return shortestPath;
    }

    /**
     * Simple getter of distance
     * @return distance
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * Simple setter 
     * @param distance to set 
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * Simple getter of node
     * @return adjacentNodes
     */
    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    /**
     * Simple setter of distance 
     * @param distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Node{" + "stations=" + stations + '}';
    }
}
