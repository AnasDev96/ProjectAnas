/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atl.grade.change;

import atl.grade.Demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.sqlite.SQLiteConfig;

/**
 *
 * @author 53203
 */
public class DemoGradeUpdate extends Demo {

    @Override
    public void execute(String url) {
        try {
            Connection connexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            
            Statement stmt = connexion.createStatement();
            LocalDateTime localLast = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String formatDateTime = localLast.format(formatter);

            String query = "INSERT INTO GRADES(id,score,date,dateModified,id_student,id_lesson) "
                    + "values('12','15','2022-04-01'," + "'"+formatDateTime+ "'" + " , '5','ANL' )";

            int count = stmt.executeUpdate(query);
            System.out.println("\t Nombre de record modifié : " + count);

        } catch (SQLException ex) {
            System.out.println("DEMO_UPDATE | Erreur " + ex.getMessage() + " SQLState " + ex.getSQLState());
        }
    }

    @Override
    public String getTitle() {
        return "Mise à jour d'un utilisateur dans la DB";
    }
}
