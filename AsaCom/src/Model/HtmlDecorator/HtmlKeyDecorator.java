/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.HtmlDecorator;

import Model.TextDecorator.*;
import Model.GeneradorDecorator;
import Model.IDecorador;

/**
 *
 * @author eadan
 */
public class HtmlKeyDecorator extends GeneradorDecorator{

    
    public HtmlKeyDecorator(IDecorador wrappee) {
        super(wrappee);
    }

    @Override
    public void setStr(String str) {
        this.str=str; 
    }

    
 
    @Override
    public String getSource() {
        return wrappee.getSource()+"<b>"+str+": </b>"; 
    }
    
}
