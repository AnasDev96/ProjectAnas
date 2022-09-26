package g53203.atl.model;

import g53203.atl.dto.StationsDto;
import g53203.atl.dto.StationsNLDto;
import g53203.atl.dto.StopsDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.repository.StationsRepository;
import g53203.atl.repository.StopsRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import g53203.atl.obs.Observable;
import g53203.atl.repository.StationsNLRepository;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class Graph extends Observable {

    private List<Node> nodes;
    private List<NodeNL> nodesNL;

    /**
     * Simple constructor of graph
     */
    public Graph() {
        nodes = new ArrayList<>();
        nodesNL = new ArrayList<>();
    }

    /**
     * 
     * Method for give all stations on graph
     * @throws RepositoryException
     * @throws IOException
     */
    public void creatStationsGraph(boolean ndls) throws RepositoryException, IOException {
        if (ndls) {
            List<StopsDto> stops;
            StopsRepository instanceStop = new StopsRepository();
            StationsNLRepository instance = new StationsNLRepository();
            List<StationsNLDto> stations = instance.selectAll();
            for (StationsNLDto dto : stations) {
                nodesNL.add(new NodeNL(dto));
            }
            for (int i = 0; i < nodesNL.size(); i++) {
                stops = instanceStop.getStopsById(nodesNL.get(i).getStations().getId());
                for (int j = 0; j < stops.size(); j++) {
                    List<StopsDto> allNeighbor = instanceStop.getStopNeighbor(stops.get(j).getId_line(),
                            stops.get(j).getId_order());
                    for (int k = 0; k < allNeighbor.size(); k++) {
                        nodesNL.get(i).addDestination(getNodeNLFromGraphById(allNeighbor.get(k).getId_station()), 1);
                    }
                }
            }
        } else {
            List<StopsDto> stops;
            StopsRepository instanceStop = new StopsRepository();
            StationsRepository instance = new StationsRepository();
            List<StationsDto> stations = instance.selectAll();
            for (StationsDto dto : stations) {
                nodes.add(new Node(dto));
            }
            for (int i = 0; i < nodes.size(); i++){
                stops = instanceStop.getStopsById(nodes.get(i).getStations().getId());
                for (int j = 0; j < stops.size(); j++) {
                    List<StopsDto> allNeighbor = instanceStop.getStopNeighbor(stops.get(j).getId_line(),
                            stops.get(j).getId_order());
                    for (int k = 0; k < allNeighbor.size(); k++) {
                        nodes.get(i).addDestination(getNodeFromGraphById(allNeighbor.get(k).getId_station()), 1);
                    }
                }
            }
        }

    }

    /**
     * Mehtod for calculate the short way between two stations
     * @param begin stations
     * @param end stations
     * @return StationsStops
     * @throws RepositoryException
     */
    public StationsStops calculDijkstra(String begin, String end, boolean ndls) throws RepositoryException {
        StationsStops stationStops = null;
        if (ndls) {
            DijkstraAlgoNL.calculateShortestPathFromSource(this, getNodeNLFromGraph(begin));

            StopsRepository instanceStop = new StopsRepository();
            List<List<StopsDto>> stops = new ArrayList<>();

            List<NodeNL> stations = getNodeNLFromGraph(end).getShortestPath();

            stations.add(getNodeNLFromGraph(end));

            for (int i = 0; i < stations.size(); i++) {
                stops.add(instanceStop.getStopsById(stations.get(i).getStations().getId()));
            }
            stationStops = new StationsStops(stations, null, stops);
            notifyObservers(stationStops);

        } else {
            DijkstraAlgo.calculateShortestPathFromSource(this, getNodeFromGraph(begin));

            StopsRepository instanceStop = new StopsRepository();
            List<List<StopsDto>> stops = new ArrayList<>();
            List<Node> stations = getNodeFromGraph(end).getShortestPath();

            stations.add(getNodeFromGraph(end));

            for (int i = 0; i < stations.size(); i++) {
                stops.add(instanceStop.getStopsById(stations.get(i).getStations().getId()));
            }
            stationStops = new StationsStops(null, stations, stops);
            notifyObservers(stationStops);
        }

        return stationStops;
    }

    /**
     *
     *  Method for get node by id
     * @param id_station
     * @return Node
     */
    public Node getNodeFromGraphById(int id_station) {
        Node node = null;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getStations().getId() == id_station) {
                node = nodes.get(i);
            }
        }
        return node;
    }
    
    /**
     * Method for get NodeNL by id
     * @param id_station
     * @return NodeNL
     */
    public NodeNL getNodeNLFromGraphById(int id_station) {
        NodeNL node = null;
        for (int i = 0; i < nodesNL.size(); i++) {
            if (nodesNL.get(i).getStations().getId() == id_station) {
                node = nodesNL.get(i);
            }
        }
        return node;
    }

    /**
     * Method for get node from graph
     * @param string
     * @return Node
     */
    public Node getNodeFromGraph(String string) {
        Node node = null;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).getStations().getName().equals(string)) {
                node = nodes.get(i);
            }
        }
        return node;
    }

    /**
     * Method get  NodeNL from graph
     * @param string
     * @return NodeNL
     */
    public NodeNL getNodeNLFromGraph(String string) {
        NodeNL nodeNL = null;
        for (int i = 0; i < nodesNL.size(); i++) {
            if (nodesNL.get(i).getStations().getName().equals(string)) {
                nodeNL = nodesNL.get(i);
            }
        }
        return nodeNL;
    }

    /**
     * Simple getter 
     * @return nodes
     */
    public List<Node> getGraph() {
        return nodes;
    }

}
