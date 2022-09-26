package g53203.atl.repository;

import g53203.atl.dto.LinesDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.jdbc.LinesDao;
import java.util.List;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class LinesRepository implements Repository<LinesDto> {

    private LinesDao dao;
    
    /**
     * Simple constructor of LinesRepository
     * @param dao LinesDao
     */
    public LinesRepository(LinesDao dao) {
        this.dao = dao;
    }


    /**
     * Simple constructor of LinesRepository
     * @throws RepositoryException
     */
    public LinesRepository() throws RepositoryException {
        dao = LinesDao.getInstance();
    }

    @Override
    public List<LinesDto> selectAll() throws RepositoryException {
        return dao.selectAll();
    }

    
}
