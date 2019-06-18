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
public class FlatDecorator extends GeneradorDecorator{

    
    public FlatDecorator(IDecorador wrappee) {
        super(wrappee);
    }

 
    @Override
    public String getSource() {
        return wrappee.getSource()+str; //To change body of generated methods, choose Tools | Templates.
    }
    
}
