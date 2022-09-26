package g53203.mentoring.dto;

import java.util.Objects;

/**
 *
 * @author g53203 - Anas Ben Allal
 */
public class StudentDto extends Dto<Integer> {

    /**
     *
     */
    private String firstName;
    private String LastName;

    /**
     *
     * @param matricule
     * @param firstName
     * @param LastName
     */
    public StudentDto(int matricule, String firstName, String LastName) {
        super(matricule);
        this.firstName = firstName;
        this.LastName = LastName;
    }

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return LastName;
    }

    @Override
    public Integer getKey() {
        return key;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @param LastName
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     *
     * @param key
     */
    public void setKey(Integer key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "StudentDto{" + "firstName=" + firstName + ", LastName=" + LastName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.firstName);
        hash = 41 * hash + Objects.hashCode(this.LastName);
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
        final StudentDto other = (StudentDto) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.LastName, other.LastName)) {
            return false;
        }
        return true;
    }


}
