package g53203.mentoring.file;

import g53203.mentoring.config.ConfigManager;
import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class FileManager {

    private final String url;

    private FileManager() {
        url = ConfigManager.getInstance().getProperties("file.url");
    }

    /**
     * Return the instance of the <code> FileManager </code>.
     *
     * @return the instance of the <code> FileManager </code>.
     */
    static FileManager getInstance() {
        return FileManagerHolder.INSTANCE;
    }

    private File getFile() {
        return new File(url);
    }

    /**
     * Return the path of the file.
     *
     * @return the path of the file.
     */
    Path path() {

        return getFile().toPath();
    }

    private static class FileManagerHolder {

        private static final FileManager INSTANCE = new FileManager();
    }
}
