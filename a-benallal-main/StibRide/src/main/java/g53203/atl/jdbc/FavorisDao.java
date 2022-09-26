package g53203.atl.jdbc;

import g53203.atl.dto.FavorisDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.model.ColumnFavoris;
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
public class FavorisDao implements Dao<FavorisDto> {

    private Connection connexion;

    /**
     * Simple constructor FavorisDao
     *
     * @throws RepositoryException
     */
    private FavorisDao() throws RepositoryException {
        connexion = DBManager.getInstance().getConnection();

    }

    /**
     * method for get connexion db
     *
     * @return FavorisDao @throws RepositoryException
     */
    public static FavorisDao getInstance() throws RepositoryException {
        return FavorisDao.FavorisDaoHolder.getInstance();
    }

    @Override
    public List<FavorisDto> selectAll() throws RepositoryException {
        String sql = "SELECT id,name,origin,destination FROM FAVORIS";
        List<FavorisDto> dtos = new ArrayList<>();
        try (
                 Statement stmt = connexion.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                FavorisDto dto = new FavorisDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                dtos.add(dto);
            }

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return dtos;
    }

    /**
     * Simple getter
     *
     * @return connexion
     */
    public Connection getConnexion() {
        return connexion;
    }

    /**
     * Method for add on favoris db
     * @param id of favoris 
     * @param name favoris 
     * @param origin favoris 
     * @param destination favoris 
     * @throws RepositoryException
     */
    public int addFavoris(int id, String name, String origin, String destination) throws RepositoryException {

        String sql = "INSERT INTO FAVORIS (id,name,origin,destination) VALUES (?, ?, ?, ?)";

        int rs;
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, origin);
            pstmt.setString(4, destination);
            rs = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return rs;
    }

    /**
     * Method for updat favoris db 
     * @param name of favoris 
     * @param upName favoris 
     * @throws RepositoryException
     */
    public int upDateFavoris(String name, ColumnFavoris upName) throws RepositoryException {
        String sql = "UPDATE FAVORIS SET name = ? WHERE name = ? AND origin = ? AND destination = ?";
        int rs;
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, upName.getName());
            pstmt.setString(3, upName.getOrigine());
            pstmt.setString(4, upName.getDestination());
            rs = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return rs;
    }

    /**
     * method for delet on favoris db
     * @param upName of favoris
     * @throws RepositoryException
     */
    public int deleteFavoris(ColumnFavoris upName) throws RepositoryException {
        String sql = "DELETE FROM FAVORIS WHERE name = ? AND origin = ? AND destination = ?";
        int rs;
        try ( PreparedStatement pstmt = connexion.prepareStatement(sql)) {
            pstmt.setString(1, upName.getName());
            pstmt.setString(2, upName.getOrigine());
            pstmt.setString(3, upName.getDestination());
            rs = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
        return rs;
    }

    /**
     * class for get Instance 
     */
    private static class FavorisDaoHolder {

        private static FavorisDao getInstance() throws RepositoryException {
            return new FavorisDao();
        }
    }
}
