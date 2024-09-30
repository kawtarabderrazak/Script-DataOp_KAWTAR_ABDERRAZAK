/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EX1;

/**
 *
 * @author PC
 */
import EX1.IDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Suivi implements IDao<DevData> {

  
   public boolean create(DevData d) {
    boolean r = false;
    try {
        String req = "INSERT INTO devdata (Developpeurs, Jour, NbScripts) VALUES ('" + d.getDeveloppeurs() + "', '" + d.getJour() + "', " + d.getNbScripts() + ");";
        Statement st = Connexion.getCn().createStatement();
        int n = st.executeUpdate(req);
        if (n == 1) {
            r = true;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Suivi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
}

  
    public boolean update(DevData o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public boolean delete(DevData o) {
    boolean r = false;
    try {
        String req = "DELETE FROM DevData WHERE developpeurs = '" + o.getDeveloppeurs() + "'";
        Statement st = Connexion.getCn().createStatement();
        int n = st.executeUpdate(req);
        if (n == 1) {
            r = true;
        }
    } catch (SQLException ex) {
        Logger.getLogger(Suivi.class.getName()).log(Level.SEVERE, null, ex);
    }
    return r;
}
   
}
    
