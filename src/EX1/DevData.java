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
public class DevData {
   private String developpeurs;
   private int nbScripts;
   private String jour;
   
   public DevData(String developpeurs,String jour ,int nbScripts){
   this.developpeurs=developpeurs;
   this.nbScripts=nbScripts;
   this.jour=jour;
   }

    public String getDeveloppeurs() {
        return developpeurs;
    }

    public int getNbScripts() {
        return nbScripts;
    }

    public String getJour() {
        return jour;
    }

    public void setDeveloppeurs(String developpeurs) {
        this.developpeurs = developpeurs;
    }

    public void setNbScripts(int nbScripts) {
        this.nbScripts = nbScripts;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }
   
   
}
