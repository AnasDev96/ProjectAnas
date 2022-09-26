package g53203.atl.model;

import java.util.List;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class Column {

    private String stations;
    private List<Integer> lines;

    /**
     * Simple constructor of Column
     * @param stations stations
     * @param lines lines
     */
    public Column(String stations, List<Integer> lines) {
        this.stations = stations;
        this.lines = lines;
    }

    /**
     *  Simple getter
     * @return stations
     */
    public String getStations() {
        return stations;
    }

    /**
     * Simple setter 
     * @param stations to set 
     */
    public void setStations(String stations) {
        this.stations = stations;
    }

    /**
     * Simple getter of lines
     * @return lines
     */
    public List<Integer> getLines() {
        return lines;
    }

    /**
     * Simple setter 
     * @param lines to set 
     */
    public void setLines(List<Integer> lines) {
        this.lines = lines;
    }

}
