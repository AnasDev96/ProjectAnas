package atl.grade;

import atl.grade.change.DemoGradeUpdate;
import atl.grade.change.DemoLessonDelete;
import atl.grade.change.DemoLessons;
import atl.grade.config.ConfigManager;
import atl.grade.date.DemoDateUpdate;
import atl.grade.injection.DemoInjection;
import atl.grade.selection.DemoSelect;
import atl.grade.selection.DemoSelectAll;
import atl.grade.selection.DemoSelectLesson;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jlc
 */
public class DemoJDBC {

    /**
     * Entry points to the <code> Mentoring </code> application.
     *
     * @param args no arguments needed.
     */
    public static void main(String[] args) {
        try {
            ConfigManager.getInstance().load();
            String dbUrl = ConfigManager.getInstance().getProperties("db.url");
            System.out.println("Base de données stockée : " + dbUrl);

            
            System.out.println("Entrez votre requête ");
            Scanner input = new Scanner(System.in);
            String query = input.nextLine();
            
            Demo demo = new DemoInjection(query);
            demo.printTitle();
            demo.execute(dbUrl);
            
            Demo demo2 = new DemoSelectAll();
            demo2.printTitle();
            demo2.execute(dbUrl);
            
        } catch (IOException ex) {
            System.out.println("Erreur IO " + ex.getMessage());
        }
    }

    private DemoJDBC() {

    }
}
