
package g53203.atl.jdbc;

import g53203.atl.config.ConfigManager;
import g53203.atl.dto.StationsDto;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
@RunWith(JUnitPlatform.class)
public class StationsDaoTest {

    private List<StationsDto> listStations;

    public StationsDaoTest() throws IOException {     
      
        ConfigManager.getInstance().load();
        
        listStations = new ArrayList<>();
        listStations.add(new StationsDto(8012, "DE BROUCKERE"));
        listStations.add(new StationsDto(8022,	"GARE CENTRALE"));
        listStations.add(new StationsDto(8032, "PARC"));
        listStations.add(new StationsDto(8042, "ARTS-LOI"));
        listStations.add(new StationsDto(8052, "MAELBEEK"));
        listStations.add(new StationsDto(8062, "SCHUMAN"));
        listStations.add(new StationsDto(8072, "MERODE"));
        listStations.add(new StationsDto(8082, "MONTGOMERY"));
        listStations.add(new StationsDto(8092, "JOSEPH.-CHARLOTTE"));
        listStations.add(new StationsDto(8102, "GRIBAUMONT"));
        listStations.add(new StationsDto(8112, "TOMBERG"));
        listStations.add(new StationsDto(8122, "ROODEBEEK"));
        listStations.add(new StationsDto(8132, "VANDERVELDE"));
        listStations.add(new StationsDto(8142, "ALMA"));
        listStations.add(new StationsDto(8152, "CRAINHEM"));
        listStations.add(new StationsDto(8161, "STOCKEL"));
        listStations.add(new StationsDto(8202, "THIEFFRY"));
        listStations.add(new StationsDto(8212, "PETILLON"));
        listStations.add(new StationsDto(8222, "HANKAR"));
        listStations.add(new StationsDto(8232, "DELTA"));
        listStations.add(new StationsDto(8242, "BEAULIEU"));
        listStations.add(new StationsDto(8252, "DEMEY"));
        listStations.add(new StationsDto(8262,	"HERRMANN-DEBROUX"));
        listStations.add(new StationsDto(8272, "SAINTE-CATHERINE"));
        listStations.add(new StationsDto(8282, "COMTE DE FLANDRE"));
        listStations.add(new StationsDto(8292, "ETANGS NOIRS"));
        listStations.add(new StationsDto(8302, "TRONE"));
        listStations.add(new StationsDto(8312, "PORTE DE NAMUR"));
        listStations.add(new StationsDto(8322, "LOUISE"));
        listStations.add(new StationsDto(8332, "HOTEL DES MONNAIES"));
        listStations.add(new StationsDto(8342, "PORTE DE HAL"));
        listStations.add(new StationsDto(8352, "GARE DU MIDI"));
        listStations.add(new StationsDto(8362, "CLEMENCEAU"));
        listStations.add(new StationsDto(8372, "DELACROIX"));
        listStations.add(new StationsDto(8382, "GARE DE L'OUEST"));
        listStations.add(new StationsDto(8412, "MADOU"));
        listStations.add(new StationsDto(8422, "BOTANIQUE"));
        listStations.add(new StationsDto(8432, "ROGIER"));
        listStations.add(new StationsDto(8442, "YSER"));
        listStations.add(new StationsDto(8462, "RIBAUCOURT"));
        listStations.add(new StationsDto(8472, "ELISABETH"));
        listStations.add(new StationsDto(8641, "ERASME"));
        listStations.add(new StationsDto(8652, "EDDY MERCKX"));
        listStations.add(new StationsDto(8662, "CERIA"));
        listStations.add(new StationsDto(8672, "LA ROUE"));
        listStations.add(new StationsDto(8682, "BIZET"));
        listStations.add(new StationsDto(8692, "VEEWEYDE"));
        listStations.add(new StationsDto(8702, "SAINT-GUIDON"));
        listStations.add(new StationsDto(8712, "AUMALE"));
        listStations.add(new StationsDto(8722, "JACQUES BREL"));
        listStations.add(new StationsDto(8742, "BEEKKANT"));
        listStations.add(new StationsDto(8754, "OSSEGHEM"));
        listStations.add(new StationsDto(8764, "SIMONIS"));
        listStations.add(new StationsDto(8774, "BELGICA"));
        listStations.add(new StationsDto(8784, "PANNENHUIS"));
        listStations.add(new StationsDto(8794, "BOCKSTAEL"));
        listStations.add(new StationsDto(8804, "STUYVENBERGH"));
        listStations.add(new StationsDto(8814, "HOUBA-BRUGMANN"));
        listStations.add(new StationsDto(8824, "HEYSEL"));
        listStations.add(new StationsDto(8833, "ROI BAUDOUIN"));
   
    }

    /**
     * Test of selectAll method, of class StationsDao.
     */
    @Test
    public void testSelectAllTrue() throws Exception {     
        System.out.println("selectAllTrue");
        StationsDao instance = StationsDao.getInstance();
        List<StationsDto> expResult = listStations;
        List<StationsDto> result = instance.selectAll();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of selectAll method, of class StationsDao.
     */
    @Test
    public void testSelectAllFalse() throws Exception {       
        System.out.println("selectAllFalse");
        StationsDao instance = StationsDao.getInstance();
        listStations.add(new StationsDto(6543, "abc"));
        List<StationsDto> expResult = listStations;
        List<StationsDto> result = instance.selectAll();
        assertNotEquals(expResult, result);
    }

}
