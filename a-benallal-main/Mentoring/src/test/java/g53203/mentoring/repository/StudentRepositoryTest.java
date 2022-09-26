package g53203.mentoring.repository;

import g53203.mentoring.dto.StudentDto;
import g53203.mentoring.exception.RepositoryException;
import g53203.mentoring.file.StudentDao;
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
 * @author 53203
 */
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class StudentRepositoryTest {

    private final StudentDto bob;

    private final StudentDto patrick;

    private static final int KEY = 12_345;

    private final List<StudentDto> all;

    @Mock
    private StudentDao mock;

    public StudentRepositoryTest() {
        System.out.println("StudentRepositoryTest Constructor");
        //Test data
        bob = new StudentDto(KEY, "SquarePants", "SpongeBob");
        patrick = new StudentDto(99_999, "Star", "Patrick");

        all = new ArrayList<>();
        all.add(bob);
        all.add(patrick);
    }

    @BeforeEach
    void init() throws RepositoryException {
        System.out.println("==== BEFORE EACH =====");
        //Mock behaviour
        Mockito.lenient().when(mock.select(bob.getKey())).thenReturn(bob);
        Mockito.lenient().when(mock.select(patrick.getKey())).thenReturn(null);
        Mockito.lenient().when(mock.selectAll()).thenReturn(all);
        Mockito.lenient().when(mock.select(null)).thenThrow(RepositoryException.class);
    }

    @Test
    public void testGetExist() throws Exception {
        System.out.println("testGetExist");
        //Arrange
        StudentDto expected = bob;
        StudentRepository repository = new StudentRepository(mock);
        //Action
        StudentDto result = repository.get(KEY);
        //Assert
        assertEquals(expected, result);
        Mockito.verify(mock, times(1)).select(KEY);
    }

    @Test
    public void testGetNotExist() throws Exception {
        System.out.println("testGetNotExist");
        //Arrange
        StudentDto expected = null;
        StudentRepository repository = new StudentRepository(mock);
        //Action
        StudentDto result = repository.get(0);
        //Assert
        assertEquals(expected, result);
        Mockito.verify(mock, times(1)).select(0);
    }

    @Test
    public void testGetBadParam() throws Exception {
        System.out.println("testGetBadParam");
        //Arrange

        StudentRepository repository = new StudentRepository(mock);

        assertThrows(RepositoryException.class, () -> {

            StudentDto result = repository.get(null);
            Mockito.verify(mock, times(1)).select(null);

             });
    }

    @Test
    public void testAddWhenExisting() throws Exception {
        System.out.println("testAddWhenExisting");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        repository.add(bob);
        //Assert
        Mockito.verify(mock, times(1)).select(KEY);
        Mockito.verify(mock, times(1)).update(bob);
        Mockito.verify(mock, times(0)).insert(any(StudentDto.class));
    }

    @Test
    public void testAddWhenBadParam() throws Exception {
        System.out.println("testAddWhenBadParam");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        assertThrows(RepositoryException.class, () -> {

            StudentDto pat = null;
            repository.add(pat);
            //Assert
            Mockito.verify(mock, times(1)).select(KEY);
            Mockito.verify(mock, times(1)).update(bob);
            Mockito.verify(mock, times(0)).insert(any(StudentDto.class));

        });

    }

    @Test
    public void testRemoveNotExisting() throws Exception {
        System.out.println("testRemoveNotExisting");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        assertThrows(RepositoryException.class, () -> {
            //Action
            repository.remove(987);

            Mockito.verify(mock, times(1)).delete(987);
            Mockito.verify(mock, times(0)).insert(any(StudentDto.class));
        });

    }

    @Test
    public void testRemoveExisting() throws Exception {
        System.out.println("RemoveExisting");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        repository.remove(KEY);
        //delete  
        Mockito.verify(mock, times(1)).select(KEY);
        Mockito.verify(mock, times(1)).delete(KEY);
        Mockito.verify(mock, times(0)).insert(any(StudentDto.class));

    }

    @Test
    public void testContainsExisting() throws Exception {
        System.out.println("RemoveContainsExisting");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        assertTrue(repository.contains(KEY));
        Mockito.verify(mock, times(1)).select(KEY);
        Mockito.verify(mock, times(0)).insert(any(StudentDto.class));

    }

    @Test
    public void testContainsNotExisting() throws Exception {
        System.out.println("RemoveContainsNotExisting");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        assertFalse(repository.contains(324));
        Mockito.verify(mock, times(1)).select(324);
        Mockito.verify(mock, times(0)).insert(any(StudentDto.class));

    }

    @Test
    public void testContainsBadParam() throws Exception {
        System.out.println("RemoveContainsBadParam");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        assertThrows(RepositoryException.class, () -> {
            //Action
            repository.remove(null);

            Mockito.verify(mock, times(1)).delete(null);
            Mockito.verify(mock, times(0)).insert(any(StudentDto.class));
        });
    }

    @Test
    public void testGetAll() throws Exception {
        System.out.println("GetAll");
        //Arrange
        StudentRepository repository = new StudentRepository(mock);
        //Action
        assertEquals(repository.getAll(), all);
        Mockito.verify(mock, times(1)).selectAll();
        Mockito.verify(mock, times(0)).insert(any(StudentDto.class));

    }
}
