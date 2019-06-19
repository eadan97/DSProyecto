/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.TextDecorator;

import Model.GeneradorDecorator;
import Model.IDecorador;

/**
 *
 * @author eadan
 */
public class TextoHrDecorator extends GeneradorDecorator{

    
    public TextoHrDecorator(IDecorador wrappee) {
        super(wrappee);
        str="\n*****************************";
    }

    @Override
    public void setStr(String str) {
    }

    
 
    @Override
    public String getSource() {
        return wrappee.getSource()+str; //To change body of generated methods, choose Tools | Templates.
    }
    
}
