package g53203.atl.jdbc;

import g53203.atl.dto.StationsDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.repository.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class StationsDao implements Dao<StationsDto> {

    private Connection connexion;

    /**
     * Simple constructor of stations
     * @throws RepositoryException
     */
    private StationsDao() throws RepositoryException {
        connexion = DBManager.getInstance().getConnection();

    }

    /**
     * method for get instance connexion DB
     * @return StationsDao @throws RepositoryException
     */
    public static StationsDao getInstance() throws RepositoryException {
        return StationsDaoHolder.getInstance();
    }

    @Override
    public List<StationsDto> selectAll() throws RepositoryException {
        String sql = "SELECT id,name FROM STATIONS";
        List<StationsDto> dtos = new ArrayList<>();
        try (
                 Statement stmt = connexion.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StationsDto dto = new StationsDto(rs.getInt(1), rs.getString(2));
                dtos.add(dto);
            }

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }

    /**
     * method for get stations by id
     * @param id
     * @return stations dto
     * @throws RepositoryException
     */
    public StationsDto getStationsById(int id) throws RepositoryException {
        StationsDto result = new StationsDto(0, "");
        String sql = "SELECT id,name FROM STATIONS WHERE id = ?";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = new StationsDto(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return result;
    }

    /**
     * Class for get instance
     */
    private static class StationsDaoHolder {

        private static StationsDao getInstance() throws RepositoryException {
            return new StationsDao();
        }
    }
}
