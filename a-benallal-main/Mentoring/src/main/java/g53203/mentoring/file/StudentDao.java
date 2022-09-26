package g53203.mentoring.file;

import g53203.mentoring.dto.StudentDto;
import g53203.mentoring.exception.RepositoryException;
import g53203.mentoring.repository.Dao;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author g53203 - Anas Ben Allal
 */
public class StudentDao implements Dao<Integer, StudentDto> {

    private final Path path;

    private StudentDao() {
        this.path = FileManager.getInstance().path();
        
    }

    /**
     * Creates a new instance of <code>StudentDao</code> with a specific file.
     * Useful for unit test.
     *
     * @param uri address of the file to access.
     */
    StudentDao(String uri) {
        //System.out.println(uri);
      //  this.path = Paths.get(uri);
        this.path = Paths.get(uri.substring(1));
    }

    /**
     * Returns the single instance of the <code>StudentDao</code>.
     *
     * @return the single instance of the <code>StudentDao</code>.
     */
    public static StudentDao getInstance() {
        return StudentDaoHolder.INSTANCE;
    }

    @Override
    public void insert(StudentDto item) throws RepositoryException {
        if (item == null) {
            throw new RepositoryException("Aucun élement en paramètre " + item);
        }
        try {
            String out = buildLine(item);
           
            Files.write(path, out.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
            throw new RepositoryException(ex);
        }
    }

    @Override
    public List<StudentDto> selectAll() throws RepositoryException {
        List<StudentDto> result = new ArrayList<>();
        try {
            List<String> out = Files.lines(path)
                    .collect(Collectors.toList());
            
            for (String line : out) {
                StudentDto studentDto = buildDto(line);
                result.add(studentDto);
            }
        } catch (IOException ex) {
            throw new RepositoryException(ex);
        }
        return result;
    }

    @Override
    public void update(StudentDto item) throws RepositoryException {
        if (item == null) {
            throw new RepositoryException("Aucun élement en paramètre " + item);
        }
        delete(item.getKey());
        insert(item);
    }

    @Override
    public void delete(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé en paramètre " + key);
        }
        try {
            List<String> out = Files.lines(path)
                    .filter(line -> !line.split(",")[0]
                    .contains(Integer.toString(key)))
                    .collect(Collectors.toList());
            if (out.size() == Files.lines(path).count()) {
                throw new RepositoryException("Absent du fichier " + key);
            }
            Files.write(path, out,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            throw new RepositoryException(ex);
        }
    }

    private static String buildLine(StudentDto student) {
        return student.getKey() + ","
                + student.getFirstName() + ","
                + student.getLastName()
                + System.lineSeparator();
    }

    private StudentDto buildDto(String line) {
        String[] splited = line.split(",");
        int matricule = Integer.parseInt(splited[0]);
        String lastName = splited[1];
        String fisrtName = splited[2];
        return new StudentDto(matricule, lastName, fisrtName);
    }

    @Override
    public StudentDto select(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException("Aucune clé en paramètre " + key);
        }
        StudentDto result = null;
        try {
            List<String> out = Files.lines(path)
                    .filter(line -> line.split(",")[0]
                    .equals(Integer.toString(key)))
                    .collect(Collectors.toList());
            if (!out.isEmpty()) {
                result = buildDto(out.get(0));
            }
        } catch (IOException ex) {
            throw new RepositoryException(ex);
        }
        return result;
    }

   

    private static class StudentDaoHolder {

        private static final StudentDao INSTANCE = new StudentDao();
    }
}
