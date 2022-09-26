
package atl.grade.change;

import atl.grade.Demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 53203
 */
public class DemoLessons extends Demo {
   
    @Override
    public void execute(String url) {
        try {
            Connection connexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            Statement stmt = connexion.createStatement();

            String query = "INSERT INTO LESSONS(acronym) values('ANL')";

            int count = stmt.executeUpdate(query);
            System.out.println("\t Nombre de record modifié : " + count);

            ResultSet result = stmt.getGeneratedKeys();
            while (result.next()) {
                int id = result.getInt(1);
                System.out.println("\t clé ajoutée : " + id);
            }
        } catch (SQLException ex) {
            System.out.println("DEMO_INSERT | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
    }

    @Override
    public String getTitle() {
        return "Insertion d'un utilisateur dans la DB";
    }
}
