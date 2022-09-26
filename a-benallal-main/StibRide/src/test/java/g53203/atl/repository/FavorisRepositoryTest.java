package g53203.atl.repository;

import g53203.atl.config.ConfigManager;
import g53203.atl.dto.FavorisDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.jdbc.FavorisDao;
import g53203.atl.model.ColumnFavoris;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class FavorisRepositoryTest {

    @Mock
    private FavorisDao mock;

    private List<FavorisDto> content;

    public FavorisRepositoryTest() throws IOException, RepositoryException {
        ConfigManager.getInstance().load();

        content = new ArrayList<>();
        content.add(new FavorisDto(0, "test", "test", "test"));

    }

    @BeforeEach
    void init() throws RepositoryException {
        Mockito.lenient().when(mock.selectAll()).thenReturn(content);
    }

    /**
     * Test of selectAll method, of class FavorisRepository.
     *
     */
    @Test
    public void testSelectAll() throws Exception {
        System.out.println("selectAll");
        FavorisRepository instance = new FavorisRepository(mock);
        List<FavorisDto> expResult = content;
        List<FavorisDto> result = instance.selectAll();
        assertEquals(expResult, result);
        Mockito.verify(mock, times(1)).selectAll();
    }

    @Test
    public void testAddFavoris() throws Exception {
        System.out.println("addFavoris");
        int id = 0;
        String name = "test";
        String origin = "test";
        String destination = "test";
        FavorisRepository instance = new FavorisRepository(mock);
        instance.addFavoris(id, name, origin, destination);

        Mockito.verify(mock, times(1)).addFavoris(id, name, origin, destination);

    }

    @Test
    public void testUpDateFavoris() throws Exception {
        System.out.println("upDateFavoris");
        String name = "test";
        ColumnFavoris upName = new ColumnFavoris("first", "dest", "finih");
        FavorisRepository instance = new FavorisRepository(mock);
        instance.addFavoris(1, "first",
                "dest", "finih");
        instance.upDateFavoris(name, upName);

        Mockito.verify(mock, times(1)).upDateFavoris(name, upName);
    }

    @Test
    public void testDeleteFavoris() throws Exception {
        System.out.println("deleteFavoris");
        ColumnFavoris upName = new ColumnFavoris("first", "dest", "finih");
        FavorisRepository instance = new FavorisRepository(mock);
        instance.deleteFavoris(upName);
        Mockito.verify(mock, times(1)).deleteFavoris(upName);
    }

}
