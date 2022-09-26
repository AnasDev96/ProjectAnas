package g53203.atl.dto;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class LinesDto {

    private int id;

    /**
     * Simple constructor of LinesDto
     * @param id id lines
     */
    public LinesDto(int id) {
        this.id = id;
    }

    /**
     * Simple getter
     * @return id 
     */
    public int getId() {
        return id;
    }

    /**
     * Simple setter
     * @param id to change
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final LinesDto other = (LinesDto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
