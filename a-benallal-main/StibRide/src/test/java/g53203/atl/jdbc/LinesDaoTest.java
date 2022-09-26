package g53203.atl.jdbc;

import g53203.atl.config.ConfigManager;
import g53203.atl.dto.LinesDto;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
@RunWith(JUnitPlatform.class)
public class LinesDaoTest {

    public LinesDaoTest() throws IOException {
        ConfigManager.getInstance().load();
    }

    /**
     * Test of selectAll method, of class LinesDao.
     */
    @Test
    public void testSelectAllTrue() throws Exception {
        System.out.println("selectAllTrue");
        LinesDto id1 = new LinesDto(1);
        LinesDto id2 = new LinesDto(2);
        LinesDto id5 = new LinesDto(5);
        LinesDto id6 = new LinesDto(6);
        List<LinesDto> result = Arrays.asList(id1, id2, id5, id6);
        LinesDao dao = LinesDao.getInstance();
        List<LinesDto> expect = dao.selectAll();
        assertEquals(expect, result);
    }

    /**
     * Test of selectAll method, of class LinesDao.
     */
    @Test
    public void testSelectAllFalse() throws Exception {
        System.out.println("selectAllFalse");
        LinesDto id1 = new LinesDto(1);
        LinesDto id2 = new LinesDto(2);
        LinesDto id5 = new LinesDto(0);
        LinesDto id6 = new LinesDto(6);
        List<LinesDto> result = Arrays.asList(id1, id2, id5, id6);
        LinesDao dao = LinesDao.getInstance();
        List<LinesDto> expect = dao.selectAll();
        assertNotEquals(expect, result);
    }

}
