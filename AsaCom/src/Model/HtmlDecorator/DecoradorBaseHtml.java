/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.HtmlDecorator;

import Model.GeneradorBase;

/**
 *
 * @author eadan
 */
public class DecoradorBaseHtml extends GeneradorBase {

    public DecoradorBaseHtml(String str) {
        super(str);
    }

    public DecoradorBaseHtml() {
        super("");
    }

    @Override
    public void setStr(String str) {
    }
  
    
    @Override
    public String getSource() {
        //return  "<title>"+str.toUpperCase()+"</title>\n"; 
        return "<html>";
    }
    
}
