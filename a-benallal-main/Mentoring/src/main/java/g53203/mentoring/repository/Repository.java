package g53203.mentoring.repository;

import g53203.mentoring.dto.Dto;
import g53203.mentoring.exception.RepositoryException;
import java.util.List;

/**
 *
 * @author g53203 - Anas Ben Allal
 * @param <K>
 * @param <T>
 */
public interface Repository<K, T extends Dto<K>> {

     /**
     * Add an element to the repository. If the element exists, the repository
     * updates this element.
     *
     * @param item the element to add.
     * @throws RepositoryException if the repository can't access to the element.
     */
    void add(T item) throws RepositoryException;

    /**
     * Removes the element of the specific key.
     *
     * @param key key of the element to removes.
     * @throws RepositoryException if the repository can't access to the element.
     */
    void remove(K key) throws RepositoryException;

    /**
     * Returns all the elements of the repository.
     *
     * @return all the elements of the repository.
     *
     * @throws RepositoryException if the repository can't access to the elements.
     */
    List<T> getAll() throws RepositoryException;

    /**
     * Return the element of the repository with the specific key.
     *
     * @param key key of the element.
     *
     * @return the element of the repository with the specific key.
     * @throws RepositoryException if the repository can't access to the element.
     */
    T get(K key) throws RepositoryException;

    /**
     * Returns true if the element exist in the repository and false otherwise.
     * An element is found by this key.
     *
     * @param key key of the element.
     * @return true if the element exist in the repository and false otherwise.
     * @throws RepositoryException if the repository can't access to the element.
     */
    boolean contains(K key) throws RepositoryException;
}
