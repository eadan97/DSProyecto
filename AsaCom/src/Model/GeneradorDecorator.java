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
public abstract class GeneradorDecorator extends IDecorador{
    
    IDecorador wrappee;

     
    
    
    public GeneradorDecorator(IDecorador wrappee) {
        this.wrappee = wrappee;
    }
    
    
    
}
