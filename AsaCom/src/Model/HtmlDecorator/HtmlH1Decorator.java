/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.HtmlDecorator;

import Model.GeneradorDecorator;
import Model.IDecorador;

/**
 *
 * @author eadan
 */
public class HtmlH1Decorator extends GeneradorDecorator{

    
    public HtmlH1Decorator(IDecorador wrappee) {
        super(wrappee);
    }

    
    @Override
    public String getSource() {
        return wrappee.getSource()+"<h1>\n" +str+ "</h1>\n"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
