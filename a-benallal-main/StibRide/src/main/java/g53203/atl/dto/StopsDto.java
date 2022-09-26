package g53203.atl.dto;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class StopsDto {

    private int id_line;
    private int id_station;
    private int id_order;

    /**
     * Simple constructor of stops 
     * @param id_line of stops
     * @param id_station of stops
     * @param id_order of stops
     */
    public StopsDto(int id_line, int id_station, int id_order) {
        this.id_line = id_line;
        this.id_station = id_station;
        this.id_order = id_order;
    }

    /**
     * Simple getter
     * @return id line
     */
    public int getId_line() {
        return id_line;
    }

    /**
     * Simple getter id station
     * @return id station
     */
    public int getId_station() {
        return id_station;
    }

    /**
     * Simple getter 
     * @return id order
     */
    public int getId_order() {
        return id_order;
    }

    /**
     * Simple setter 
     * @param id_line to set 
     */
    public void setId_line(int id_line) {
        this.id_line = id_line;
    }

    /**
     * Simple setter
     * @param id_station to set 
     */
    public void setId_station(int id_station) {
        this.id_station = id_station;
    }

    /**
     * Simple setter 
     * @param id_order to set 
     */
    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id_line;
        hash = 37 * hash + this.id_station;
        hash = 37 * hash + this.id_order;
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
        final StopsDto other = (StopsDto) obj;
        if (this.id_line != other.id_line) {
            return false;
        }
        if (this.id_station != other.id_station) {
            return false;
        }
        if (this.id_order != other.id_order) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StopsDto{" + "id_line=" + id_line + ", id_station=" + id_station + ", id_order=" + id_order + '}';
    }

   

}
