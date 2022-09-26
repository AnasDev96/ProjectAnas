package g53203.atl.presenter;

import g53203.atl.dto.FavorisDto;
import g53203.atl.dto.StationsDto;
import g53203.atl.dto.StationsNLDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.model.Column;
import g53203.atl.model.ColumnFavoris;
import g53203.atl.model.Graph;
import g53203.atl.model.StationsStops;
import g53203.atl.repository.FavorisRepository;
import g53203.atl.repository.StationsRepository;
import g53203.atl.view.ViewController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import g53203.atl.obs.Observable;
import g53203.atl.obs.Observer;
import g53203.atl.repository.StationsNLRepository;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class Presenter implements Observer {

    private final ViewController viewController;
    private Graph graph;

    /**
     * Simple constructor of Presenter
     * @param viewController
     */
    public Presenter(ViewController viewController) {
        this.viewController = viewController;
        graph = new Graph();
    }

    /**
     * Method for get strations
     * @return list of stations 
     * @throws RepositoryException
     */
    public List<StationsDto> getStations() throws RepositoryException {
        StationsRepository station = new StationsRepository();
        return station.selectAll();
    }

     /**
     * Method for get strations NL
     * @return list of stations NL
     * @throws RepositoryException
     */
    public List<StationsNLDto> getStationsNL() throws RepositoryException {
        StationsNLRepository station = new StationsNLRepository();
        return station.selectAll();
    }

    /**
     * Method for get Favoris
     * @return list of Favoris 
     * @throws RepositoryException
     */
    public List<FavorisDto> getFavoris() throws RepositoryException {
        FavorisRepository favoris = new FavorisRepository();
        return favoris.selectAll();
    }

    /**
     * Method for set data on DB 
     * @param id favoris 
     * @param name favoris 
     * @param origin of favoris
     * @param destination of favoris 
     * @throws RepositoryException
     */
    public void setDBFavoris(int id, String name, String origin, String destination) throws RepositoryException {
        FavorisRepository favoris = new FavorisRepository();
        favoris.addFavoris(id, name, origin, destination);
    }

    /**
     * method for update the db favoris from a name
     * @param name of favoris
     * @param upName  of favoris
     * @throws RepositoryException
     */
    public void updateDBFavoris(String name, ColumnFavoris upName) throws RepositoryException {
        FavorisRepository favoris = new FavorisRepository();
        favoris.upDateFavoris(name, upName);
    }

    /**
     * Method for delete a favoris 
     * @param upName the favoris to delete
     * @throws RepositoryException
     */
    public void deleteFavoris(ColumnFavoris upName) throws RepositoryException {
        FavorisRepository favoris = new FavorisRepository();
        favoris.deleteFavoris(upName);
    }

    /**
     * Method for creat stations and the shortpath of graph
     * @param debut the begin station
     * @param fin the end station
     * @throws RepositoryException
     * @throws IOException
     */
    public void handleDijkstra(String debut, String fin, boolean ndls) throws RepositoryException, IOException {
        graph.addObserver(this);
        graph.creatStationsGraph(ndls);
        graph.calculDijkstra(debut, fin, ndls);
    }

    @Override
    public void update(Observable o, Object arg) {
        StationsStops stationStop = (StationsStops) arg;

        List<Column> column = new ArrayList<>();
        List<Integer> line = new ArrayList<>();

        for (int i = 0; i < stationStop.getStops().size(); i++) {
            for (int j = 0; j < stationStop.getStops().get(i).size(); j++) {
                line.add(stationStop.getStops().get(i).get(j).getId_line());
            }
            if (stationStop.getStations() != null) {
                column.add(new Column(stationStop.getStations().get(i).getStations().getName(), line));
            } else {
                column.add(new Column(stationStop.getStationsNL().get(i).getStations().getName(), line));
            }
            line = new ArrayList<>();
            System.out.println("");
        }

        viewController.newDataUpdate(column);
    }
}
