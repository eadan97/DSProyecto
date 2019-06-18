/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author eadan
 */
public class GeneradorBasePdf extends GeneradorBase {

    public GeneradorBasePdf(String str) {
        super(str);
    }
  
    @Override
    public String getSource() {
        return str.toUpperCase()
                + "\n***************************************"; 
    }
    
}
