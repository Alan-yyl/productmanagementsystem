package com.alan.pms.utils;

/**
 * @author yyl
 * @version 1.0
 * @date 2020/12/20 11:24
 */
public class StringUtils {
    /**
     * 字符串判空
     * @param str
     * @return
     */
    public static String safeString(String str){
        if (str==null){
            return "";
        }
        return str;
    }
}
