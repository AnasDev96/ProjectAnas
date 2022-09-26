package g53203.atl.dto;

import java.util.Objects;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class StationsNLDto {

    private int id;
    private String name;

    /**
     * Simple constructor 
     * @param id for stations
     * @param name of stations
     */
    public StationsNLDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Simple getter
     * @return id 
     */
    public int getId() {
        return id;
    }

    /** 
     * Simple getter 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Simple setter 
     * @param id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Simple setter
     * @param name to set 
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StationNLDto{" + "id=" + id + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.name);
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
        final StationsNLDto other = (StationsNLDto) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }

}
