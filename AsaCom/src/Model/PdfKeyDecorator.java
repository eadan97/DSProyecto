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
public class PdfKeyDecorator extends GeneradorDecorator{

    
    public PdfKeyDecorator(IDecorador wrappee) {
        super(wrappee);
    }

    @Override
    public void setStr(String str) {
        this.str="\n"+str+": "; 
    }

    
 
    @Override
    public String getSource() {
        return wrappee.getSource()+str; //To change body of generated methods, choose Tools | Templates.
    }
    
}
