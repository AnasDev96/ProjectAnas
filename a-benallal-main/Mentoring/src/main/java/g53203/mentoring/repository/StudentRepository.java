package g53203.mentoring.repository;

import g53203.mentoring.file.StudentDao;
import g53203.mentoring.dto.StudentDto;
import g53203.mentoring.exception.RepositoryException;
import java.util.List;

/**
 *
 * @author g53203 - Anas Ben Allal
 */
public class StudentRepository implements Repository<Integer, StudentDto> {

    private final StudentDao dao;

    /**
     * Creates a new instance of <code>StudentRepository</code> with a
     * compatible <code>StudentDao</code>.
     */
    public StudentRepository() {
        dao = StudentDao.getInstance();
    }

    /**
     * Creates a new instance of <code>StudentRepository</code>. The compatible
     * <code>StudentDao</code> has to be given. Useful for the unit test.
     *
     * @param dao compatible <code>StudentDao</code>.
     */
    StudentRepository(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(StudentDto item) throws RepositoryException {
        if (item == null) {
            throw new RepositoryException(" Key null");
        }
        if (contains(item.getKey())) {
            dao.update(item);
        } else {
               System.out.println(dao.selectAll());
            dao.insert(item);
               System.out.println(dao.selectAll());
        }
        
    }

    @Override
    public void remove(Integer key) throws RepositoryException {
     
        if (key == null || !contains(key) ) {
            throw new RepositoryException("Key null ou existe pas");
        }
        dao.delete(key);
    }

    @Override
    public List<StudentDto> getAll() throws RepositoryException {
        return dao.selectAll();
    }

    @Override
    public StudentDto get(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException(" Key null");
        }
        return dao.select(key);
    }

    @Override
    public boolean contains(Integer key) throws RepositoryException {
        if (key == null) {
            throw new RepositoryException(" Key null");
        }
        StudentDto refreshItem = dao.select(key);
        return refreshItem != null;
    }
}
