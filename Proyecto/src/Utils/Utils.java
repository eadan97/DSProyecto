/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Date;

/**
 *
 * @author eadan
 */
public class Utils {
    public static String safeParseToString(Date date){
        return date==null?"Null":date.toString();
    }
    public static java.sql.Date sqlDate(Date d) {
        return d!=null ? new java.sql.Date(d.getTime()) : null;
    }
}
