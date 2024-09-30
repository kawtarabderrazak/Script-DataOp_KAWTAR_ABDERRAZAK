/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX3;

/**
 *
 * @author PC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class ExoJDBC {
    
    public static void main(String[] args) {
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        
        try {
            // Connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/scriptsdéveloppeurs";
            String user = "root";
            String password = "";
            cn = DriverManager.getConnection(url, user, password);
            st = cn.createStatement();
            
            // Demander une requête à l'utilisateur
            System.out.print("donnez la requête SQL : ");
            String userQuery = sc.nextLine();

            // Exécuter la requête
            boolean isResultSet = st.execute(userQuery);
            if (isResultSet) {
                // Obtenir le ResultSet
                rs = st.getResultSet();
                
                // Obtenir les méta-données
                ResultSetMetaData resmd = rs.getMetaData();
                int columnCount = resmd.getColumnCount();
                
                // Afficher le nombre de colonnes
                System.out.println("Nombre de colonnes est: " + columnCount);
                
                // Afficher les noms et types de données des colonnes
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = resmd.getColumnName(i);
                    String columnType = resmd.getColumnTypeName(i);
                    System.out.println("Colonne " + i + ": " + columnName + " (Type: " + columnType + ")");
                }
                
                // Afficher le contenu de la table ligne par ligne
                System.out.println("\nContenu de la table :");
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rs.getString(i) + "\t");
                    }
                    System.out.println();
                }
            } else {
                // Si ce n'est pas une requête qui produit un ResultSet
                int rowCount = st.getUpdateCount();
                System.out.println("Nombre de lignes modifiées : " + rowCount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Libérer les ressources
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (cn != null) cn.close();
                sc.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
