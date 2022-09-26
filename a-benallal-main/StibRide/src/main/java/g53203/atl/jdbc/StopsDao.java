package g53203.atl.jdbc;

import g53203.atl.dto.StationsDto;
import g53203.atl.dto.StopsDto;
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
public class StopsDao implements Dao<StopsDto> {

    private Connection connexion;

    /**
     * Simple constructor 
     * @throws RepositoryException
     */
    private StopsDao() throws RepositoryException {
        connexion = DBManager.getInstance().getConnection();

    }

    /**
     * Method for get instance 
     * @return @throws RepositoryException
     */
    public static StopsDao getInstance() throws RepositoryException {
        return StopsDaoHolder.getInstance();
    }

    @Override
    public List<StopsDto> selectAll() throws RepositoryException {
        String sql = "SELECT id_line,id_station,id_order FROM STOPS";
        List<StopsDto> dtos = new ArrayList<>();
        try (
                 Statement stmt = connexion.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                StopsDto dto = new StopsDto(rs.getInt(1), rs.getInt(2), rs.getInt(3));
                dtos.add(dto);
            }

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }

    /**
     *
     * Method for get stops by id 
     * @param id_station
     * @return list of stops dto
     * @throws RepositoryException
     */
    public List<StopsDto> getStopsById(int id_station) throws RepositoryException {
        List<StopsDto> result = new ArrayList<>();

        String sql = "SELECT id_line, id_station, id_order FROM STOPS WHERE  id_station = ?";

        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, id_station);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                result.add(new StopsDto(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }

        return result;
    }

    /**
     * Method for get neighbor of stations
     * @param id_line
     * @param id_order
     * @return list of stops dto
     * @throws RepositoryException
     */
    public List<StopsDto> getStopNeighbor(int id_line, int id_order) throws RepositoryException {
        List<StopsDto> result = new ArrayList<>();

        int neighbor = id_order - 1;
        int i = 0;
        String sql = "SELECT id_line, id_station, id_order FROM STOPS WHERE id_line = ? AND id_order = ?";

        while (i < 2) {
            try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
                pstmt.setInt(1, id_line);
                pstmt.setInt(2, neighbor);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    result.add(new StopsDto(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
                }
            } catch (SQLException e) {
                throw new RepositoryException(e);
            }
            i++;
            neighbor = id_order + 1;
        }
        return result;
    }

    /**
     * Class for get instance 
     */
    private static class StopsDaoHolder {

        private static StopsDao getInstance() throws RepositoryException {
            return new StopsDao();
        }
    }
}
