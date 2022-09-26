package g53203.atl.model;

import g53203.atl.config.ConfigManager;
import g53203.atl.dto.LinesDto;
import g53203.atl.dto.StationsDto;
import g53203.atl.dto.StopsDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.jdbc.FavorisDao;
import g53203.atl.jdbc.StationsDao;
import static g53203.atl.model.DijkstraAlgo.calculateShortestPathFromSource;
import g53203.atl.repository.FavorisRepository;
import g53203.atl.repository.LinesRepository;
import g53203.atl.repository.StationsRepository;
import g53203.atl.repository.StopsRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class MainTest {

    public static void main(String[] args) throws IOException, RepositoryException {
//        try {
        ConfigManager.getInstance().load();
//            String dbUrl = ConfigManager.getInstance().getProperties("db.url");
//            System.out.println("Base de données stockée : " + dbUrl);
//
//            StopsRepository repository = new StopsRepository();
//            List<StopsDto> dtos = repository.selectAll();
//
//            for (StopsDto dto : dtos) {
//
//                System.out.print("Id_Line : " + dto.getId_line() + " ");
//                System.out.print("Id_Stations : " + dto.getId_station() + " ");
//                System.out.print("Id_order : " + dto.getId_order() + " ");
//                System.out.println("");
//            }
//
//        } catch (IOException ex) {
//            System.out.println("Erreur IO " + ex.getMessage());
//        } catch (RepositoryException ex) {
//            System.out.println("Erreur Repository " + ex.getMessage());
//        }
//        Node nodeA = new Node(new StationsDto(1, "A"));
//        Node nodeB = new Node(new StationsDto(2, "B"));
//        Node nodeC = new Node(new StationsDto(3, "C"));
//        Node nodeD = new Node(new StationsDto(4, "D"));
//        Node nodeE = new Node(new StationsDto(5, "E"));
//        Node nodeF = new Node(new StationsDto(6, "F"));
//
//        nodeA.addDestination(nodeB, 1);
//        nodeA.addDestination(nodeC, 1);
//
//        nodeB.addDestination(nodeD, 1);
//        nodeB.addDestination(nodeF, 1);
//
//        nodeC.addDestination(nodeE, 1);
//
//        nodeD.addDestination(nodeE, 1);
//        nodeD.addDestination(nodeF, 1);
//
//        nodeF.addDestination(nodeE, 1);
//
        // Graph graph = new Graph();
//
//        graph.addNode(nodeA);
//        graph.addNode(nodeB);
//        graph.addNode(nodeC);
//        graph.addNode(nodeD);
//        graph.addNode(nodeE);
//        graph.addNode(nodeF);
        // graph.creatStationsGraph();
        //  graph.calculDijkstra("ETANGS NOIRS", "DE BROUCKERE");
        //FavorisRepository fav = new FavorisRepository();

        //fav.addFavoris(0,"test", "station1", "Station2");
//        for (Node gr : graph.getNodes().get(0).getShortestPath()) {
//            System.out.println(gr.getStations().getName());
//        }
//        System.out.println("------------------------------------------------");
//        Node node = new Node(new StationsDto(8012, "DE BROUCKERE"));
//        graph = DijkstraAlgo.calculateShortestPathFromSource(graph, new Node(new StationsDto(8012, "DE BROUCKERE")));
//        for (Node node2 : graph.getnodeFromGraph(graph, node.getStations().getName() ).getShortestPath()) {
//            System.out.println(node2);
//        }
//        graph.getNodes().get(0).getShortestPath();
//        for (Node gr : graph.getNodes().get(0).getShortestPath()) {
//            System.out.println(gr.getStations().getName());
//        }
//        for (int i = 0; i < graph.getNodes().size(); i++) {
//            for (int j = 0; j < graph.getNodes().get(i).getShortestPath().size(); j++) {
//                System.out.println(graph.getNodes().get(i).getShortestPath().get(j));
//            }
//        }
//        Set<String> set = new HashSet<String>(10, (float) 0.8);
//
//        set.add("Two");
//        set.add("One");
//        set.add("Three");
//        set.add("One");
//        Iterator<String> it1 = set.iterator();
//        while (it1.hasNext()) {
//            System.out.println(it1.next());
//        }
//     ConfigManager.getInstance().load();
//     StopsRepository stops = new StopsRepository();
//     
//        System.out.println(stops.getStopsById(1, 6).getId_station());
//        StationsDto test1 = new StationsDto(3, "test1");
//        StationsDto test2 = new StationsDto(3, "test1");
//        if (test1.equals(test2)) {
//            System.out.println("true");
//        }
//       StopsRepository stops = new StopsRepository();
//       List<StopsDto> dto = new ArrayList<>();
//       dto = stops.getStopsById(8012);
//        System.out.println(dto.size());
        StationsDto stat = null;
        List<StationsDto> stations = new ArrayList<>();
        stations.add(new StationsDto(12345, "DBZ"));
        stations.add(new StationsDto(13425, "DEZ"));
        stations.add(new StationsDto(17654, "FBI"));
        List<StationsDto> stationsSec = new ArrayList<>();
        stationsSec.add(new StationsDto(12345, "DBZ"));
        stationsSec.add(new StationsDto(13425, "DEZ"));
        stationsSec.add(new StationsDto(17654, "FBI"));
        stationsSec.add(new StationsDto(12345, "DBZ"));
        System.out.println(stations.equals(stationsSec));
    }
}
