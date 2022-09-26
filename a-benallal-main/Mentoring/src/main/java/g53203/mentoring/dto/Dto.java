package g53203.mentoring.dto;

import java.util.Objects;

/**
 *
 * @author 53203 Anas Ben Allal
 */
public class Dto<K> {

    /**
     *
     */
    protected K key;

    /**
     *
     * @param key
     */
    protected Dto(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Clé absente " + key);
        }
        this.key = key;
    }

    /**
     *
     * @return
     */
    public K getKey() {
        return key;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.key);
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
        final Dto<?> other = (Dto<?>) obj;
        return Objects.equals(this.key, other.key);
    }

}
