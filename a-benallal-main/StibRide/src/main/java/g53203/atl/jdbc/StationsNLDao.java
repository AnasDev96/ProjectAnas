package g53203.atl.jdbc;

import g53203.atl.dto.StationsDto;
import g53203.atl.dto.StationsNLDto;
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
public class StationsNLDao implements Dao<StationsNLDto> {

    private Connection connexion;

    /**
     * Simple constructor 
     * @throws RepositoryException
     */
    private StationsNLDao() throws RepositoryException {
        connexion = DBManager.getInstance().getConnection();

    }

    /**
     * method for get instance 
     * @return @throws RepositoryException
     */
    public static StationsNLDao getInstance() throws RepositoryException {
        return StationsNLDaoHolder.getInstance();
    }

    @Override
    public List<StationsNLDto> selectAll() throws RepositoryException {
        String sql = "SELECT id,name FROM STATIONS_NL";
        List<StationsNLDto> dtos = new ArrayList<>();
        try (
                 Statement stmt = connexion.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StationsNLDto dto = new StationsNLDto(rs.getInt(1), rs.getString(2));
                dtos.add(dto);
            }

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }

    /**
     * Method for get stations by id 
     * @param id 
     * @return StationsNLDto
     * @throws RepositoryException
     */
    public StationsNLDto getStationsById(int id) throws RepositoryException {
        StationsNLDto result = new StationsNLDto(0, "");
        String sql = "SELECT id,name FROM STATIONS_NL WHERE id = ?";
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                result = new StationsNLDto(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return result;
    }

    /**
     * Class for get instance
     */
    private static class StationsNLDaoHolder {

        private static StationsNLDao getInstance() throws RepositoryException {
            return new StationsNLDao();
        }
    }

}
