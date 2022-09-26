package g53203.atl.repository;

import g53203.atl.config.ConfigManager;
import g53203.atl.dto.FavorisDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.jdbc.FavorisDao;
import g53203.atl.jdbc.StationsDao;
import g53203.atl.model.ColumnFavoris;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class FavorisRepository implements Repository<FavorisDto> {

    private FavorisDao dao;

    /**
     * Simple constructor of FavorisRepository
     *
     * @param dao
     */
    public FavorisRepository(FavorisDao dao) {
        this.dao = dao;
    }

    /**
     * Simple constructor of FavorisRepository
     *
     * @throws RepositoryException
     */
    public FavorisRepository() throws RepositoryException {
        dao = FavorisDao.getInstance();
    }

    @Override
    public List<FavorisDto> selectAll() throws RepositoryException {
        return dao.selectAll();
    }

    /**
     * Method for set data on DB
     *
     * @param id favoris
     * @param name favoris
     * @param origin of favoris
     * @param destination of favoris
     * @throws RepositoryException
     */
    public int addFavoris(int id, String name, String origin, String destination) throws RepositoryException {
        return dao.addFavoris(id, name, origin, destination);
    }

    /**
     * Method for update the db favoris from a name
     *
     * @param name of favoris
     * @param upName of favoris
     * @throws RepositoryException
     */
    public int upDateFavoris(String name, ColumnFavoris upName) throws RepositoryException {
        return dao.upDateFavoris(name, upName);
    }

     /**
     * Method for delete a favoris 
     * @param upName the favoris to delete
     * @throws RepositoryException
     */
    public int deleteFavoris(ColumnFavoris upName) throws RepositoryException {
        return dao.deleteFavoris(upName);
    }

}
