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
public abstract class IDecorador {
    public String str;

    public abstract String getSource();
    public String getStr() {
        return str;
    }
    public void setStr(String str) {
        this.str = str;
    }
    
}
