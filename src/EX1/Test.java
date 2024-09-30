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


public class Test {
    public static void main(String[] args) {
        DevData  s1 = new DevData("ALAMI", "Lundi",1);
        DevData  s2 = new DevData("WAFI ", "Lundi",2);
        DevData  s3 = new DevData("SALAMI ", "Mardi",9);
        DevData  s4 = new DevData("SAFI ", "Mardi",2);
        DevData  s5 = new DevData("ALAMI", "Mardi",2);
        DevData  s6 = new DevData("SEBIHI ", "Mercredi",2);
        DevData  s7 = new DevData("WAFI", "Jeudi",3);
        DevData  s8 = new DevData("ALAOUI", "Vendredi",9);
        DevData  s9 = new DevData("WAFI ", "Vendredi",3);
        DevData  s10 = new DevData("SEBIHI", "Vendredi",4);
        
        
        
        Suivi ss = new Suivi();
        //ss.create(s);
        ss.create(s1);
         ss.create(s2);
          ss.create(s3);
           ss.create(s4);
           ss.create(s5);
           ss.create(s6);
             ss.create(s7);
               ss.create(s8);
                 ss.create(s9);
                   ss.create(s10); 
        ss.delete(s1);
        
                
       
                   
            
       
          
    }        
    
   
        }
        
        
         
         
        
        
        
        
        
        
        
        
        
      
        
        
    
