package g53203.atl.repository;

import g53203.atl.dto.StopsDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.jdbc.StopsDao;

import java.util.List;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class StopsRepository implements Repository<StopsDto> {

    private StopsDao dao;

    /**
     * Simple constructor of StopsRepository
     * @param dao StopsDao
     */
    public StopsRepository(StopsDao dao) {
        this.dao = dao;
    }

    /**
     * Simple contructor of StopsRepository
     * @throws RepositoryException
     */
    public StopsRepository() throws RepositoryException {
        dao = StopsDao.getInstance();
    }

    @Override
    public List<StopsDto> selectAll() throws RepositoryException {
        return dao.selectAll();
    }

    /**
     * Methode for get stops by id 
     * @param id_station of stops
     * @return List of StopsDto
     * @throws RepositoryException
     */
    public List<StopsDto> getStopsById(int id_station) throws RepositoryException {
        if (id_station == 0) {
            throw new RepositoryException("id null");
        }
        return dao.getStopsById(id_station);
    }

    /**
     * Method for get the neighbor of stop by id
     * @param id_line of stop
     * @param id_order of stop
     * @return list of StopsDto
     * @throws RepositoryException
     */
    public List<StopsDto> getStopNeighbor(int id_line, int id_order) throws RepositoryException {
        return dao.getStopNeighbor(id_line, id_order);
    }
}
