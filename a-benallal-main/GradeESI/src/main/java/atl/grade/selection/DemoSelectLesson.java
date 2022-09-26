
package atl.grade.selection;

import atl.grade.Demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 53203 - Anas Ben Allal
 */
public class DemoSelectLesson extends Demo {

    @Override
    public void execute(String url) {
        try {
            Connection connexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            Statement stmt = connexion.createStatement();

            String query = "SELECT acronym FROM LESSONS";

            ResultSet result = stmt.executeQuery(query);

            while (result.next()) {  
                String lessons = result.getString("acronym");
                System.out.println("\t record : " + lessons);
            }
        } catch (SQLException ex) {
            System.out.println("DEMO_SELECT_ALL | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
    }

    @Override
    public String getTitle() {
        return "TABLE LESSONS";
    }
    
}
