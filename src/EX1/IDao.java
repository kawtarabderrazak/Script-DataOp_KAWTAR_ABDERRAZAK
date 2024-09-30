package EX1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;


public interface IDao <T> {
    
    public abstract boolean create (T o);
    boolean update (T o);
    boolean delete (T o);
    
    
}