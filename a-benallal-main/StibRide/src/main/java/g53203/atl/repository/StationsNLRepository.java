package g53203.atl.repository;

import g53203.atl.dto.StationsNLDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.jdbc.StationsNLDao;
import java.util.List;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class StationsNLRepository implements Repository<StationsNLDto> {

    private StationsNLDao dao;

    /**
     * Simple constructor of StationsNLRepository
     * @param dao StationsNLDao
     */
    public StationsNLRepository(StationsNLDao dao) {
        this.dao = dao;
    }

    /**
     * Simple constructor of StationsNLRepository
     * @throws RepositoryException
     */
    public StationsNLRepository() throws RepositoryException {
        dao = StationsNLDao.getInstance();
    }

    @Override
    public List<StationsNLDto> selectAll() throws RepositoryException {
        return dao.selectAll();
    }

    /**
     * Method for get stations by Id
     * @param id of station
     * @return StationsNLDto
     * @throws RepositoryException
     */
    public StationsNLDto getStationsById(int id) throws RepositoryException {
        if (id == 0) {
            throw new RepositoryException("id null");
        }
        return dao.getStationsById(id);
    }
}
