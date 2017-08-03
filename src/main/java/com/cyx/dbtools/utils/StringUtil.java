package com.cyx.dbtools.utils;

public class StringUtil {

    public final static Integer toInteger(String str) {
        Integer result = 0;
        if (str != null) {
           try {
               result = Integer.valueOf(str);
           }catch (NumberFormatException e){
               e.printStackTrace();
           }
        }
        return result;
    }
}
