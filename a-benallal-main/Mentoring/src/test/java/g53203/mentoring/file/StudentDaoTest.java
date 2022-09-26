package g53203.mentoring.file;

import g53203.mentoring.dto.StudentDto;
import g53203.mentoring.exception.RepositoryException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class StudentDaoTest {

    private final StudentDto bob;
    private final StudentDto patrick;

    private static final int KEY = 12_345;
    private static final String FILE_URL = "data/test_repo_students.txt";

    private final String url;

    private final List<StudentDto> all;

    public StudentDaoTest() {
        System.out.println("==== StudentDaoTest Constructor =====");
        bob = new StudentDto(KEY, "SquarePants", "SpongeBob");
        patrick = new StudentDto(99_999, "Star", "Patrick");

        all = new ArrayList<>();
        all.add(new StudentDto(64_931, "Olsen", "Maggy"));
        all.add(new StudentDto(73_780, "Frost", "Phoebe"));
        all.add(new StudentDto(94_853, "Ortega", "Skyler"));
        all.add(new StudentDto(93_371, "Blankenship", "Byron"));
        all.add(new StudentDto(82_227, "Cote", "Molly"));
        all.add(bob);

        url = getClass().getClassLoader()
                .getResource(FILE_URL)
                .getFile();
    }

    private void init(StudentDao dao) throws Exception {

        for (StudentDto line : dao.selectAll()) {
            if (dao.selectAll().contains(line)) {
                dao.delete(line.getKey());
            };
        }
        for (StudentDto line : all) {
            dao.insert(line);
        }
    }

    @Test
    public void testSelectExist() throws Exception {
        System.out.println("testSelectExist");
        //Arrange
        StudentDto expected = bob;
        StudentDao dao = new StudentDao(url);
        init(dao);

        //Action
        StudentDto result = dao.select(KEY);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void testSelectNotExist() throws Exception {
        System.out.println("testSelectNotExist");
        //Arrange
        StudentDao dao = new StudentDao(url);
        //Action
        StudentDto result = dao.select(patrick.getKey());
        //Assert
        assertNull(result);
    }

    @Test
    public void testSelectIncorrectParameter() throws Exception {
        System.out.println("testSelectIncorrectParameter");
        //Arrange
        StudentDao dao = new StudentDao(url);
        Integer incorrect = null;
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            dao.select(incorrect);
        });
    }

    @Test
    public void testSelectWhenFileNotFound() throws Exception {
        System.out.println("testSelectWhenFileNotFound");
        //Arrange
        String url = "test/NoFile.txt";
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);
            dao.select(KEY);
        });
    }

    @Test
    public void testInsertExist() throws Exception {
        System.out.println("testInsertExist");
        //Arrange
        StudentDto expected = new StudentDto(53_456, "Anas", "Ben");
        StudentDao dao = new StudentDao(url);
        //Action
        dao.insert(expected);
        //Assert
        assertEquals(expected, dao.select(53_456));
        init(dao);
    }

    @Test
    public void testInsertIncorrectParam() throws Exception {
        System.out.println("testInsertIncorrectParam");
        //Arrange
        StudentDao dao = new StudentDao(url);
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            dao.insert(null);
        });
    }

    @Test
    public void testInserteFileNotFound() throws Exception {
        System.out.println("testInsertFileNotFound");
        //Arrange
        String url = "test/NoFile.txt";
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);

            dao.insert(new StudentDto(KEY, "rwer", "esfesf"));
        });
    }

    @Test
    public void testUpdateFileNotFound() throws Exception {
        System.out.println("testInsertFileNotFound");
        //Arrange
        String url = "test/NoFile.txt";
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);

            dao.update(new StudentDto(KEY, "rwer", "esfesf"));
        });
    }

    @Test
    public void testUpdateExist() throws Exception {
        System.out.println("testUpdateExist");
        //Arrange
        StudentDto nv = new StudentDto(53_456, "Anas", "Ben");
        StudentDao dao = new StudentDao(url);
        //Action
        dao.insert(nv);
        dao.update(new StudentDto(53_456, "Hello", "Ben"));
        StudentDto expected = new StudentDto(53_456, "Hello", "Ben");
        //Assert
        assertEquals(expected, dao.select(53_456));
        init(dao);
    }

    @Test
    public void testUpdateNotExist() throws Exception {
        System.out.println("testUpdateNotExist");
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);

            dao.update(new StudentDto(456, "rwer", "esfesf"));
        });
    }

    @Test
    public void testDeleteIncorrectParam() throws Exception {
        System.out.println("testUpdateIncorrectParam");
        //Arrange
        StudentDao dao = new StudentDao(url);
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            dao.delete(null);
        });
    }
    
    @Test
    public void testDeleteFileNotFound() throws Exception {
        System.out.println("testInsertFileNotFound");
        //Arrange
        String url = "test/NoFile.txt";
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);

            dao.delete(7865);
        });
    }

    @Test
    public void testDeleteExist() throws Exception {
        System.out.println("testUpdateExist");
        //Arrange
        StudentDto nv = new StudentDto(53_456, "Anas", "Ben");
        StudentDao dao = new StudentDao(url);
        //Action
        dao.insert(nv);
        
        dao.delete(nv.getKey());
       
        //Assert
        assertEquals(all, dao.selectAll());
        init(dao);
    }

    @Test
    public void testDeleteNotExist() throws Exception {
        System.out.println("testUpdateNotExist");
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);

            dao.delete(8753);
        });
    }

    
    
//--------------------------------------
    @Test
    public void testSelectAllExist() throws Exception {
        System.out.println("testSelectAllExist");
        StudentDao dao = new StudentDao(url);
        assertEquals(all, dao.selectAll());
    }

    @Test
    public void testSelectAllFileNotExist() throws Exception {
        System.out.println("testSelectAllNotExist");
        String url = "test/NoFile.txt";
        //Assert
        assertThrows(RepositoryException.class, () -> {
            //Action
            StudentDao dao = new StudentDao(url);

            dao.selectAll();
        });
    }
    
}
