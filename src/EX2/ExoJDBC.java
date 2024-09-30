/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX2;

/**
 *
 * @author PC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ExoJDBC {
    
    public static void main(String[] args) {
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            // Connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/scriptsdéveloppeurs";
            String user = "root";
            String password = "";
            cn = DriverManager.getConnection(url, user, password);
            st = cn.createStatement();

            // (a) Afficher la personne ayant réalisé le nombre max de scripts en une journée
            String req1 = "SELECT Developpeurs, jour, MAX(NBScripts) as maxScripts " +
                          "FROM devdata GROUP BY jour";
            rs = st.executeQuery(req1);
            System.out.println("Personnes ayant réalisé le nombre maximum de scripts par jour :");
            while (rs.next()) {
                String developpeur = rs.getString("Developpeurs");
                String jour = rs.getString("jour");
                int maxScripts = rs.getInt("maxScripts");
                System.out.println("Developpeur: " + developpeur + ", Jour: " + jour + ", Max Scripts: " + maxScripts);
            }

            // (b) Afficher la liste des personnes triée dans l’ordre décroissant selon leur nombre de scripts
            String req2 = "SELECT Developpeurs, SUM(NBScripts) AS totalScripts " +
                          "FROM devdata GROUP BY Developpeurs ORDER BY totalScripts DESC";
            rs = st.executeQuery(req2);
            System.out.println("\nListe des développeurs triée par nombre de scripts (ordre décroissant) :");
            while (rs.next()) {
                String developpeur = rs.getString("Developpeurs");
                int totalScripts = rs.getInt("totalScripts");
                System.out.println("Developpeur: " + developpeur + ", Total Scripts: " + totalScripts);
            }
           // (c) Calculer et afficher le nombre total de scripts réalisés du lundi au vendredi
            String req3 = "SELECT SUM(NBScripts) AS TotalScripts " +
                          "FROM devdata " +
                          "WHERE jour IN ('Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi');";
            rs = st.executeQuery(req3);
            if (rs.next()) {
                int totalScripts = rs.getInt("TotalScripts");
                System.out.println("\nNombre total de scripts réalisés du lundi au vendredi : " + totalScripts);
            }  

            
            // (d) Calculer et afficher le nombre total de scripts réalisés par un programmeur donné
            String developpeurCherche = "WAFI";  // Remplacez "ALAMI" par le nom du programmeur que vous souhaitez rechercher
            String req4 = "SELECT SUM(NBScripts) AS TotalScripts " +
                          "FROM devdata " +
                          "WHERE Developpeurs = '" + developpeurCherche + "';";
            rs = st.executeQuery(req4);
            if (rs.next()) {
                int totalScripts = rs.getInt("TotalScripts");
                System.out.println("\nNombre total de scripts réalisés par " + developpeurCherche + " : " + totalScripts);
            }
            
            
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Libérer les ressources
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
    

