package g53203.atl.model;

import g53203.atl.dto.StationsDto;
import g53203.atl.dto.StopsDto;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 53203 - Anas Ben Allal
 *
 */
public class StationsStops {

    private List<Node> stations;
    private List<NodeNL> stationsNL;
    private List<List<StopsDto>> stops;

    /**
     * Simple constructor of StationsStops
     *
     * @param stationsNL
     * @param stations
     * @param stops
     */
    public StationsStops(List<NodeNL> stationsNL, List<Node> stations, List<List<StopsDto>> stops) {
        this.stations = stations;
        this.stationsNL = stationsNL;
        this.stops = stops;
    }

    /**
     * Simple getter 
     * @return stationsNl
     */
    public List<NodeNL> getStationsNL() {
        return stationsNL;
    }

    /**
     * Simple setter 
     * @param stationsNL to set 
     */
    public void setStationsNL(List<NodeNL> stationsNL) {
        this.stationsNL = stationsNL;
    }

    /**
     * Simple getter 
     * @return stations
     */
    public List<Node> getStations() {
        return stations;
    }

    /**
     * Simple getter 
     * @return stops
     */
    public List<List<StopsDto>> getStops() {
        return stops;
    }

    /**
     * Simple setter
     * @param stations to set
     */
    public void setStations(List<Node> stations) {
        this.stations = stations;
    }

    /**
     * Simple setter 
     * @param stops to set
     */
    public void setStops(List<List<StopsDto>> stops) {
        this.stops = stops;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.stations);
        hash = 13 * hash + Objects.hashCode(this.stops);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StationsStops other = (StationsStops) obj;
        if (!Objects.equals(this.stations, other.stations)) {
            return false;
        }
        return Objects.equals(this.stops, other.stops);
    }

}
