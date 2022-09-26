package g53203.atl.repository;

import g53203.atl.config.ConfigManager;
import g53203.atl.dto.LinesDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.jdbc.LinesDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author 53203 Anas Ben Allal
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class LinesRepositoryTest {

    @Mock
    private LinesDao mock;

    private List<LinesDto> content;

    public LinesRepositoryTest() throws IOException {
        ConfigManager.getInstance().load();
        content = new ArrayList<>();
        content.add(new LinesDto(1));
        content.add(new LinesDto(2));
        content.add(new LinesDto(5));
        content.add(new LinesDto(6));
    }

    @BeforeEach
    void init() throws RepositoryException {
        Mockito.lenient().when(mock.selectAll()).thenReturn(content);
    }

    /**
     * Test of selectAll method, of class LinesRepository.
     */
    @Test
    public void testSelectAll() throws Exception {
        System.out.println("selectAll");
        LinesRepository instance = new LinesRepository(mock);
        List expResult = new ArrayList<LinesDto>();
        expResult.add(new LinesDto(1));
        expResult.add(new LinesDto(2));
        expResult.add(new LinesDto(5));
        expResult.add(new LinesDto(6));
        List result = instance.selectAll();
        assertEquals(expResult, result);
        Mockito.verify(mock, times(1)).selectAll();
    }

    /**
     * Test of selectAll method, of class LinesRepository.
     */
    @Test
    public void testSelectAllFalse() throws Exception {
        System.out.println("selectAllFalse");
        LinesRepository instance = new LinesRepository(mock);
        List expResult = new ArrayList<LinesDto>();
        expResult.add(new LinesDto(1));
        expResult.add(new LinesDto(2));
        expResult.add(new LinesDto(0));
        expResult.add(new LinesDto(6));
        List result = instance.selectAll();
        assertNotEquals(expResult, result);
        Mockito.verify(mock, times(1)).selectAll();
    }

}
