package com.gongj.noproblem.commonsutils.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: noproblem
 * @description: 邮箱校验
 * @author: gongj
 * @Description: TODO
 * @create: 2020-05-31 00:04
 **/
public class MailUtil {
    /**
     *
     * @Title checkMail
     * @Description 检验邮箱格式是否正确
     * @auther gongj
     * @date  2020年1月20日
     */
    public static boolean checkMail(String email){
        boolean tag = true;
        String regex =  "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher mat = pattern.matcher(email);
        if (!mat.find()) {
            tag = false;
        }
        return tag;
    }
}
