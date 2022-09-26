package g53203.mentoring.repository;

import g53203.mentoring.exception.RepositoryException;
import java.util.List;

/**
 *
 * @author 53203
 * @param <K>
 * @param <T>
 */
public interface Dao<K, T> {

    /**
     *
     * @param item
     * @throws g53203.mentoring.exception.RepositoryException
     */
    public void insert(T item) throws RepositoryException;

    /**
     *
     * @param key
     */
    public void delete(K key) throws RepositoryException;

    /**
     *
     * @param item
     * @throws g53203.mentoring.exception.RepositoryException
     */
    public void update(T item) throws RepositoryException;

    /**
     * Returns all the elements of the resource. This method can be long.
     *
     * @return all the elements of the resource.
     * @throws RepositoryException if the resource can't be accessed.
     */
    List<T> selectAll() throws RepositoryException;

    /**
     * Returns an element based on its key.
     *
     * @param key key of the element to select.
     * @return an element based on its key.
     * @throws RepositoryException if the resource can't be accessed.
     */
    T select(K key) throws RepositoryException;

   
}
