package g53203.mentoring.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private ConfigManager() {
        prop = new Properties();
        url = getClass().getClassLoader().getResource(FILE).getFile();
        System.out.println(url);
    }

    private static final String FILE = "./config/config.properties";

    private final Properties prop;

    private final String url;

    /**
     *
     * @throws IOException
     */
    public void load() throws IOException {
        try ( InputStream input = new FileInputStream(url)) {

            prop.load(input);

        } catch (IOException ex) {

            throw new IOException("Chargement configuration impossible "
                    + ex.getMessage());
        }
    }

    /**
     *
     * @param name
     * @return
     */
    public String getProperties(String name) {
        return prop.getProperty(name);
    }

    /**
     *
     * @return
     */
    public static ConfigManager getInstance() {
        return ConfigManagerHolder.INSTANCE;
    }

    private static class ConfigManagerHolder {

        private static final ConfigManager INSTANCE = new ConfigManager();
    }
}
