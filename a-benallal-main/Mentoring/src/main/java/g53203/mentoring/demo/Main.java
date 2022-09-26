package g53203.mentoring.demo;

import g53203.mentoring.config.ConfigManager;
import java.io.IOException;

/**
 *
 * @author g53203 - Anas Ben Allal
 */
public class Main {

    public static void main(String[] args) {
        
        try {
            ConfigManager.getInstance().load();
            String fileUrl = ConfigManager.getInstance().getProperties("file.url");
            System.out.println("Fichié : " + fileUrl);
        } catch (IOException e) {
            System.out.println("Chargement" + e.getMessage());
        }
        String author = ConfigManager.getInstance().getProperties("app.author");
        System.out.print("Auteur: " + author);
    }

}
