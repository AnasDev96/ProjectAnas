package g53203.atl.repository;

import g53203.atl.dto.StationsDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.jdbc.StationsDao;
import java.util.List;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class StationsRepository implements Repository<StationsDto> {

    private StationsDao dao;

    /**
     * Simple constructor StationsRepository
     * @param dao StationsDao
     */
    public StationsRepository(StationsDao dao) {
        this.dao = dao;
    }

    /**
     * Simple constructor StationsRepository
     * @throws RepositoryException
     */
    public StationsRepository() throws RepositoryException {
        dao = StationsDao.getInstance();
    }

    @Override
    public List<StationsDto> selectAll() throws RepositoryException {
        return dao.selectAll();
    }

    /**
     * Method for get stations by Id
     * @param id of stations 
     * @return StationsDto
     * @throws RepositoryException
     */
    public StationsDto getStationsById(int id) throws RepositoryException {
        if (id == 0) {
            throw new RepositoryException("id null");
        }
        return dao.getStationsById(id);
    }

}
