/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p;

/**
 *
 * @author wayne
 */
public class GMBS {

    
    private String[] camSelec;
    private String[] tablas;
    
    public GMBS() {
        
    
    
    }
    
    public int selec(String sel){
        camSelec = sel.split(",");
        return camSelec.length;
        
    }
    
    public int from(String fr){
        tablas = fr.split(",");
        return tablas.length;
    }
    
    public void where(String compa){
        
        
        
    }
    
    
}
