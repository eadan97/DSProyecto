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
public class HtmlHtmlCloseDecorator extends GeneradorDecorator{

    
    public HtmlHtmlCloseDecorator(IDecorador wrappee) {
        super(wrappee);
    }

    @Override
    public void setStr(String str) {
    }

    
    @Override
    public String getSource() {
        return wrappee.getSource()+"</html>\n"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
