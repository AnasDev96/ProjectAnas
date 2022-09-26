package g53203.atl.model;

import g53203.atl.config.ConfigManager;
import g53203.atl.dto.StationsDto;
import g53203.atl.dto.StopsDto;
import g53203.atl.repository.StopsRepository;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anasbenallal
 */
public class GraphTest {

    public GraphTest() throws IOException {
        ConfigManager.getInstance().load();
    }

    /**
     * Test of calculDijkstra method, of class Graph.
    */ 
    @Test
    public void testCalculDijkstraGOtoGC() throws Exception {
        System.out.println("calculDijkstraGOtoGC");
        String begin = "GARE DE L'OUEST";
        String end = "GARE CENTRALE";
        StopsRepository DBstop = new StopsRepository();

        Graph instance = new Graph();
        instance.creatStationsGraph(false);
        List<StationsDto> stations = new ArrayList<>();
        stations.add(new StationsDto(8382, "GARE DE L'OUEST"));
        stations.add(new StationsDto(8742, "BEEKKANT"));
        stations.add(new StationsDto(8292, "ETANGS NOIRS"));
        stations.add(new StationsDto(8282, "COMTE DE FLANDRE"));
        stations.add(new StationsDto(8272, "SAINTE-CATHERINE"));
        stations.add(new StationsDto(8012, "DE BROUCKERE"));
        stations.add(new StationsDto(8022, "GARE CENTRALE"));

        List<List<StopsDto>> stopsAll = new ArrayList<>();
        List<StopsDto> stop = new ArrayList<>();

        stop = DBstop.selectAll();

        for (int i = 0; i < stations.size(); i++) {
            stopsAll.add(DBstop.getStopsById(stations.get(i).getId()));
        }
        StationsStops result = instance.calculDijkstra(begin, end,false);

        List stationDto = new ArrayList<StationsDto>();
        for (Node node : result.getStations()) {
            stationDto.add(node.getStations());
        }  
        assertEquals(stopsAll, result.getStops());
        assertEquals(stationDto, stations);
    }
    
    /**
     * Test of calculDijkstra method, of class Graph.
     */
    @Test
    public void testCalculDijkstraPHtoHZ() throws Exception {
        System.out.println("calculDijkstraPHtoHS");
        String begin = "PORTE DE HAL";
        String end = "HEYSEL";
        StopsRepository DBstop = new StopsRepository();

        Graph instance = new Graph();
        instance.creatStationsGraph(false);
        List<StationsDto> stations = new ArrayList<>();
        stations.add(new StationsDto(8342, "PORTE DE HAL"));
        stations.add(new StationsDto(8352, "GARE DU MIDI"));
        stations.add(new StationsDto(8362, "CLEMENCEAU"));
        stations.add(new StationsDto(8372, "DELACROIX"));
        stations.add(new StationsDto(8382, "GARE DE L'OUEST"));
        stations.add(new StationsDto(8742, "BEEKKANT"));
        stations.add(new StationsDto(8754, "OSSEGHEM"));
        
        stations.add(new StationsDto(8764, "SIMONIS"));
        stations.add(new StationsDto(8774, "BELGICA"));
        stations.add(new StationsDto(8784, "PANNENHUIS"));
        stations.add(new StationsDto(8794, "BOCKSTAEL"));
        stations.add(new StationsDto(8804, "STUYVENBERGH"));
        stations.add(new StationsDto(8814, "HOUBA-BRUGMANN"));
        stations.add(new StationsDto(8824, "HEYSEL"));

        List<List<StopsDto>> stopsAll = new ArrayList<>();
        List<StopsDto> stop = new ArrayList<>();

        stop = DBstop.selectAll();

        for (int i = 0; i < stations.size(); i++) {
            stopsAll.add(DBstop.getStopsById(stations.get(i).getId()));
        }
        StationsStops result = instance.calculDijkstra(begin, end,false);

        List stationDto = new ArrayList<StationsDto>();
        for (Node node : result.getStations()) {
            stationDto.add(node.getStations());
        }  
        assertEquals(stopsAll, result.getStops());
        assertEquals(stationDto, stations);
    }

}
