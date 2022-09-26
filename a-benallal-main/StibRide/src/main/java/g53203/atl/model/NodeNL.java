package g53203.atl.model;

import g53203.atl.dto.StationsDto;
import g53203.atl.dto.StationsNLDto;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class NodeNL {

    private final StationsNLDto stations;
    private List<NodeNL> shortestPath;
    private int distance = Integer.MAX_VALUE;
    private final Map<NodeNL, Integer> adjacentNodes;

    /**
     * Simple Constructor of NodeNL
     *
     * @param stations
     */
    public NodeNL(StationsNLDto stations) {
        this.stations = stations;
        adjacentNodes = new HashMap<>();
        shortestPath = new LinkedList<>();
    }

    /**
     * Method for add distance
     *
     * @param destination
     * @param distance
     */
    public void addDestination(NodeNL destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    /**
     * Simple getter
     *
     * @return stations
     */
    public StationsNLDto getStations() {
        return stations;
    }

    /**
     * Simple getter
     *
     * @return shortestPath
     */
    public List<NodeNL> getShortestPath() {
        return shortestPath;
    }

    /**
     * Simple getter
     *
     * @return distance
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * Simple setter
     *
     * @param distance to set
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     * Simplet getter
     *
     * @return Map of Node and Integer
     */
    public Map<NodeNL, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    /**
     * Simple setter 
     *
     * @param shortestPath to set 
     */
    public void setShortestPath(List<NodeNL> shortestPath) {
        this.shortestPath = shortestPath;
    }

    /**
     * Simple setter 
     * @param distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "NodeNL{" + "stations=" + stations + '}';
    }
}
