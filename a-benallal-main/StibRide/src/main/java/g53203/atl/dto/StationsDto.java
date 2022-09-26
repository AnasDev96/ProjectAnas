package g53203.atl.dto;

import java.util.Objects;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class StationsDto {

    private int id;
    private String name;

    /**
     * Simple constructor of StationsDto
     * @param id id of stations 
     * @param name name of station
     */
    public StationsDto(int id, String name) {
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
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.name);
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
        final StationsDto other = (StationsDto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StationsDto{" + "id=" + id + ", name=" + name + '}';
    }

   

}
