package g53203.atl.repository;

import g53203.atl.config.ConfigManager;
import g53203.atl.dto.StopsDto;
import g53203.atl.exception.RepositoryException;
import g53203.atl.jdbc.StationsDao;
import g53203.atl.jdbc.StopsDao;
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
 * @author 53203 - Anas Ben Allal
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class StopsRepositoryTest {

    @Mock
    private StopsDao mock;

    private List<StopsDto> listStop;
    private List<StopsDto> listStopOne;
    private static final int KEY = 1;

    private StopsDto bob;
    private StopsDto patrik;

    public StopsRepositoryTest() throws IOException {
        ConfigManager.getInstance().load();

        patrik = new StopsDto(45, 12345, 87);

        listStop = new ArrayList<>();
        listStopOne = new ArrayList<>();
        listStopOne.add(new StopsDto(1, 8382, 1));
        listStopOne.add(new StopsDto(1, 8742, 2));
        listStopOne.add(new StopsDto(1, 8292, 3));
        listStopOne.add(new StopsDto(1, 8282, 4));
        listStopOne.add(new StopsDto(1, 8272, 5));
        listStopOne.add(new StopsDto(1, 8012, 6));
        listStopOne.add(new StopsDto(1, 8022, 7));
        listStopOne.add(new StopsDto(1, 8032, 8));
        listStopOne.add(new StopsDto(1, 8042, 9));
        listStopOne.add(new StopsDto(1, 8052, 10));
        listStopOne.add(new StopsDto(1, 8062, 11));
        listStopOne.add(new StopsDto(1, 8072, 12));
        listStopOne.add(new StopsDto(1, 8082, 13));
        listStopOne.add(new StopsDto(1, 8092, 14));
        listStopOne.add(new StopsDto(1, 8102, 15));
        listStopOne.add(new StopsDto(1, 8112, 16));
        listStopOne.add(new StopsDto(1, 8122, 17));
        listStopOne.add(new StopsDto(1, 8132, 18));
        listStopOne.add(new StopsDto(1, 8142, 19));
        listStopOne.add(new StopsDto(1, 8152, 20));
        listStopOne.add(new StopsDto(1, 8161, 21));

        listStop.add(new StopsDto(1, 8382, 1));
        listStop.add(new StopsDto(1, 8742, 2));
        listStop.add(new StopsDto(1, 8292, 3));
        listStop.add(new StopsDto(1, 8282, 4));
        listStop.add(new StopsDto(1, 8272, 5));
        listStop.add(new StopsDto(1, 8012, 6));
        listStop.add(new StopsDto(1, 8022, 7));
        listStop.add(new StopsDto(1, 8032, 8));
        listStop.add(new StopsDto(1, 8042, 9));
        listStop.add(new StopsDto(1, 8052, 10));
        listStop.add(new StopsDto(1, 8062, 11));
        listStop.add(new StopsDto(1, 8072, 12));
        listStop.add(new StopsDto(1, 8082, 13));
        listStop.add(new StopsDto(1, 8092, 14));
        listStop.add(new StopsDto(1, 8102, 15));
        listStop.add(new StopsDto(1, 8112, 16));
        listStop.add(new StopsDto(1, 8122, 17));
        listStop.add(new StopsDto(1, 8132, 18));
        listStop.add(new StopsDto(1, 8142, 19));
        listStop.add(new StopsDto(1, 8152, 20));
        listStop.add(new StopsDto(1, 8161, 21));
        listStop.add(new StopsDto(2, 8764, 1));
        listStop.add(new StopsDto(2, 8754, 2));
        listStop.add(new StopsDto(2, 8742, 3));
        listStop.add(new StopsDto(2, 8382, 4));
        listStop.add(new StopsDto(2, 8372, 5));
        listStop.add(new StopsDto(2, 8362, 6));
        listStop.add(new StopsDto(2, 8352, 7));
        listStop.add(new StopsDto(2, 8342, 8));
        listStop.add(new StopsDto(2, 8332, 9));
        listStop.add(new StopsDto(2, 8322, 10));
        listStop.add(new StopsDto(2, 8312, 11));
        listStop.add(new StopsDto(2, 8302, 12));
        listStop.add(new StopsDto(2, 8042, 13));
        listStop.add(new StopsDto(2, 8412, 14));
        listStop.add(new StopsDto(2, 8422, 15));
        listStop.add(new StopsDto(2, 8432, 16));
        listStop.add(new StopsDto(2, 8442, 17));
        listStop.add(new StopsDto(2, 8462, 18));
        listStop.add(new StopsDto(2, 8472, 19));
        listStop.add(new StopsDto(5, 8641, 1));
        listStop.add(new StopsDto(5, 8652, 2));
        listStop.add(new StopsDto(5, 8662, 3));
        listStop.add(new StopsDto(5, 8672, 4));
        listStop.add(new StopsDto(5, 8682, 5));
        listStop.add(new StopsDto(5, 8692, 6));
        listStop.add(new StopsDto(5, 8702, 7));
        listStop.add(new StopsDto(5, 8712, 8));
        listStop.add(new StopsDto(5, 8722, 9));
        listStop.add(new StopsDto(5, 8382, 10));
        listStop.add(new StopsDto(5, 8742, 11));
        listStop.add(new StopsDto(5, 8292, 12));
        listStop.add(new StopsDto(5, 8282, 13));
        listStop.add(new StopsDto(5, 8272, 14));
        listStop.add(new StopsDto(5, 8012, 15));
        listStop.add(new StopsDto(5, 8022, 16));
        listStop.add(new StopsDto(5, 8032, 17));
        listStop.add(new StopsDto(5, 8042, 18));
        listStop.add(new StopsDto(5, 8052, 19));
        listStop.add(new StopsDto(5, 8062, 20));
        listStop.add(new StopsDto(5, 8072, 21));
        listStop.add(new StopsDto(5, 8202, 22));
        listStop.add(new StopsDto(5, 8212, 23));
        listStop.add(new StopsDto(5, 8222, 24));
        listStop.add(new StopsDto(5, 8232, 25));
        listStop.add(new StopsDto(5, 8242, 26));
        listStop.add(new StopsDto(5, 8252, 27));
        listStop.add(new StopsDto(5, 8262, 28));
        listStop.add(new StopsDto(6, 8833, 1));
        listStop.add(new StopsDto(6, 8824, 2));
        listStop.add(new StopsDto(6, 8814, 3));
        listStop.add(new StopsDto(6, 8804, 4));
        listStop.add(new StopsDto(6, 8794, 5));
        listStop.add(new StopsDto(6, 8784, 6));
        listStop.add(new StopsDto(6, 8774, 7));
        listStop.add(new StopsDto(6, 8764, 8));
        listStop.add(new StopsDto(6, 8754, 9));
        listStop.add(new StopsDto(6, 8742, 10));
        listStop.add(new StopsDto(6, 8382, 11));
        listStop.add(new StopsDto(6, 8372, 12));
        listStop.add(new StopsDto(6, 8362, 13));
        listStop.add(new StopsDto(6, 8352, 14));
        listStop.add(new StopsDto(6, 8342, 15));
        listStop.add(new StopsDto(6, 8332, 16));
        listStop.add(new StopsDto(6, 8322, 17));
        listStop.add(new StopsDto(6, 8312, 18));
        listStop.add(new StopsDto(6, 8302, 19));
        listStop.add(new StopsDto(6, 8042, 20));
        listStop.add(new StopsDto(6, 8412, 21));
        listStop.add(new StopsDto(6, 8422, 22));
        listStop.add(new StopsDto(6, 8432, 23));
        listStop.add(new StopsDto(6, 8442, 24));
        listStop.add(new StopsDto(6, 8462, 25));
        listStop.add(new StopsDto(6, 8472, 26));
    }

    @BeforeEach
    void init() throws RepositoryException {
        Mockito.lenient().when(mock.selectAll()).thenReturn(listStop);
        Mockito.lenient().when(mock.getStopsById(KEY)).thenReturn(listStopOne);
        Mockito.lenient().when(mock.getStopsById(patrik.getId_line())).thenReturn(null);
        Mockito.lenient().when(mock.getStopsById(0)).thenReturn(null);
    }

    /**
     * Test of selectAll method, of class StopsRepository.
     */
    @Test
    public void testSelectAll() throws Exception {
        System.out.println("selectAll");
        StopsRepository instance = new StopsRepository(mock);
        List expResult = listStop;
        List result = instance.selectAll();
        assertEquals(expResult, result);
        Mockito.verify(mock, times(1)).selectAll();
    }

    /**
     * Test of selectAllFalse method, of class StopsRepository.
     */
    @Test
    public void testSelectAllFalse() throws Exception {
        System.out.println("selectAllFalse");
        List<StopsDto> listStopsTwo = new ArrayList<>();
        StopsRepository instance = new StopsRepository(mock);
        List expResult = listStopsTwo;
        for (StopsDto dto : listStop) {
            listStopsTwo.add(dto);
        }
        expResult.add(new StopsDto(6, 267, 34));
        List result = instance.selectAll();
        assertNotEquals(expResult, result);
        Mockito.verify(mock, times(1)).selectAll();
    }

    
     
    @Test
    public void testGetId() throws Exception {
        System.out.println("testGetId");
        StopsRepository instance = new StopsRepository(mock);
        List<StopsDto> expResult = listStopOne;
        List<StopsDto> result = instance.getStopsById(KEY);
        assertEquals(expResult, result);
        Mockito.verify(mock, times(1)).getStopsById(KEY);
    }

   
    @Test
    public void testGetBadParam() throws Exception {
        System.out.println("testGetBadParam");
        StopsRepository repository = new StopsRepository(mock);        
        List<StopsDto> result = repository.getStopsById(patrik.getId_line());
        Mockito.verify(mock, times(1)).getStopsById(patrik.getId_line());

    }
    
    /**
     * Test of testGetId method, of class StationsRepository. */
    @Test
    public void testGetBadParamEx() throws Exception {
        System.out.println("testGetBadParam");
      

        StopsRepository repository = new StopsRepository(mock);

        assertThrows(RepositoryException.class, () -> {

            List<StopsDto> result = repository.getStopsById(0);
            Mockito.verify(mock, times(1)).getStopsById(0);

        });
    }
}
