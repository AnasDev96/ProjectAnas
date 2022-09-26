package g53203.atl.jdbc;

import g53203.atl.repository.Dao;
import g53203.atl.dto.LinesDto;
import g53203.atl.exception.RepositoryException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class LinesDao implements Dao<LinesDto> {

    private Connection connexion;

    /**
     * Simple constructor
     *
     * @throws RepositoryException
     */
    private LinesDao() throws RepositoryException {
        connexion = DBManager.getInstance().getConnection();

    }

    /**
     * Method for getInscance 
     * @return @throws RepositoryException
     */
    public static LinesDao getInstance() throws RepositoryException {
        return LinesDaoHolder.getInstance();
    }

    @Override
    public List<LinesDto> selectAll() throws RepositoryException {
        String sql = "SELECT id FROM LINES";
        List<LinesDto> dtos = new ArrayList<>();
        try (
                 Statement stmt = connexion.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                LinesDto dto = new LinesDto(rs.getInt(1));
                dtos.add(dto);
            }

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }

    /**
     * Class for get instance 
     */
    private static class LinesDaoHolder {

        private static LinesDao getInstance() throws RepositoryException {
            return new LinesDao();
        }
    }

}
