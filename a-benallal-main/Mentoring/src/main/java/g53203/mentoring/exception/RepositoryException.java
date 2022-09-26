package g53203.mentoring.exception;

/**
 *
 * @author 53203 Anas Ben Allal
 */
public class RepositoryException extends Exception {

    /**
     *
     */
    public RepositoryException() {
        super();
    }

    /**
     *
     * @param message
     */
    public RepositoryException(String message) {
        super(message);
    }

    /**
     *
     * @param exception
     */
    public RepositoryException(Exception exception) {
        super(exception);
    }
}
