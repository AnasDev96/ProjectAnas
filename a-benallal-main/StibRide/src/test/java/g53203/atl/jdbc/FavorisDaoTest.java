package g53203.atl.jdbc;

import g53203.atl.config.ConfigManager;
import g53203.atl.dto.FavorisDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.model.ColumnFavoris;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
@RunWith(JUnitPlatform.class)
public class FavorisDaoTest {

    private FavorisDao instance;
    private List<FavorisDto> listFavoris;

    public FavorisDaoTest() throws IOException, RepositoryException {

        ConfigManager.getInstance().load();

        instance = FavorisDao.getInstance();

        listFavoris = new ArrayList<>();
        listFavoris.add(new FavorisDto(1, "firstFavoris", "DE BROUCKERE", "MAELBEEK"));
        listFavoris.add(new FavorisDto(2, "secondFavoris", "MONTGOMERY", "JOSEPH.-CHARLOTTE"));
        listFavoris.add(new FavorisDto(3, "thirtFavoris", "TOMBERG", "HANKAR"));

    }

    @BeforeEach
    public void setUp() throws SQLException {
        instance.getConnexion().setAutoCommit(false);
        instance.getConnexion().rollback();
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testSelectAll() throws Exception {
        System.out.println("selectAll");
        instance.addFavoris(1, "firstFavoris", "DE BROUCKERE", "MAELBEEK");
        instance.addFavoris(2, "secondFavoris", "MONTGOMERY", "JOSEPH.-CHARLOTTE");
        instance.addFavoris(3, "thirtFavoris", "TOMBERG", "HANKAR");

        List<FavorisDto> result = instance.selectAll();
        assertEquals(listFavoris, result);

    }

    /**
     * Test of testDeleteFavoris method, of class FavorisDao.
     *
     * @throws Exception
     */
    @Test
    public void testDeleteFavoris() throws Exception {
        System.out.println("deleteFavoris");
        instance.addFavoris(1, "firstFavoris", "DE BROUCKERE", "MAELBEEK");
        instance.addFavoris(2, "secondFavoris", "MONTGOMERY", "JOSEPH.-CHARLOTTE");
        instance.addFavoris(3, "thirtFavoris", "TOMBERG", "HANKAR");
        ColumnFavoris col = new ColumnFavoris("firstFavoris", "DE BROUCKERE", "MAELBEEK");
        int rs = instance.deleteFavoris(col);
        assertEquals(rs, 1);

    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testAddFavoris() throws Exception {
        System.out.println("addFavoris");
        int id = 4;
        String name = "forthFavoris";
        String origin = "BEKKANT";
        String destination = "PARC";
        int test = instance.addFavoris(id, name, origin, destination);
        assertEquals(test, 1);
    }

    @Test
    public void testUpDateFavoris() throws Exception {
        System.out.println("upDateFavoris");
        instance.addFavoris(1, "firstFavoris", "DE BROUCKERE", "MAELBEEK");
        String name = "firstFavoris";
        ColumnFavoris upName = new ColumnFavoris("firstFavoris", "DE BROUCKERE", "MAELBEEK");
        int test = instance.upDateFavoris(name, upName);
        assertEquals(test, 1);
    }

}
