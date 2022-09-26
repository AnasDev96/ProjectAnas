package g53203.atl.repository;

import g53203.atl.exception.RepositoryException;
import java.util.List;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public interface Dao<T> {
    /**
     * Method for get all data from DB 
     * @return list of type T
     * @throws RepositoryException 
     */
    List<T> selectAll() throws RepositoryException;
}
