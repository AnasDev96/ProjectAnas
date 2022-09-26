package g53203.mentoring.app;

import g53203.mentoring.config.ConfigManager;
import g53203.mentoring.dto.StudentDto;
import g53203.mentoring.exception.RepositoryException;
import g53203.mentoring.repository.StudentRepository;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g53203 - Anas Ben Allal
 */
public class Mentoring {

    public Mentoring() {
    }

    public static void main(String[] args) {
       // Mentoring mentoring = new Mentoring();
        // mentoring.checkPath();

        try {
           ConfigManager.getInstance().load();

            StudentRepository students = new StudentRepository();
           
            // Excuter 1 fois le fichier deja remplis -
            students.add(new StudentDto(64931, "Olsen", "Maggy"));
            students.add(new StudentDto(73780, "Frost", "Phoebe"));
            students.add(new StudentDto(94853, "Ortega", "Skyler"));
            students.add(new StudentDto(93371, "Blankenship", "Byron"));
            students.add(new StudentDto(82227, "Cote", "Mollyte"));
            students.add(new StudentDto(53203, "Anas", "Ben Allal"));

            // Affichage du contenu du fichier
            System.out.println("Affichage: ");
            List<StudentDto> list = students.getAll();
            list.forEach(action -> System.out.println(action.getKey() + " " + action.getFirstName() + " " + action.getLastName()));
            System.out.println("");
            // Ajouter un nouveau element 
            System.out.println("Ajout element : ");
            System.out.println("");

            students.add(new StudentDto(43567, "Henry", "Thierry"));
            list = students.getAll();
            list.forEach(action -> System.out.println(action.getKey() + " " + action.getFirstName() + " " + action.getLastName()));
            System.out.println("");
            // Modifier un element
            System.out.println("Modification : ");

            students.add(new StudentDto(53203, "Incognito", "Elpeco"));
            list = students.getAll();
            list.forEach(action -> System.out.println(action.getKey() + " " + action.getFirstName() + " " + action.getLastName()));
            System.out.println("");

            System.out.println("Suppression ");
            students.remove(53203);
            list = students.getAll();
            list.forEach(action -> System.out.println(action.getKey() + " " + action.getFirstName() + " " + action.getLastName()));
            System.out.println("");

        } catch (IOException  | RepositoryException ex) {
            System.out.println("Chargement de la configuration impossible " );
            Logger.getLogger(Mentoring.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(-1);
        }

        String author = ConfigManager.getInstance().getProperties("app.author");
        System.out.println("Auteur : " + author);

    }

    public void checkPath() {
        System.out.println("Chemin courant \t" + new File(".").getAbsolutePath());
        System.out.println("Chemin classe \t"
                + this.getClass().getResource(".").getPath());
        System.out.println("Chemin jar \t" + new File(getClass().getClassLoader().getResource(".").getFile()));
    }
}
