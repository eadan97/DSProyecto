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
public class HtmlTitleDecorator extends GeneradorDecorator{

    
    public HtmlTitleDecorator(IDecorador wrappee) {
        super(wrappee);
    }
    
 
    @Override
    public String getSource() {
        return wrappee.getSource()+"<title>"+ str + "</title>\n"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
