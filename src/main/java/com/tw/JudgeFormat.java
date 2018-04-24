package com.tw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 22935 on 2018/4/12.
 */

//判断输入的学生信息的格式否正确
public class JudgeFormat {

    public boolean isFormatCorectInStuInfo(String infoOfStudent) {//infoOfStudent:输入的学生信息

        String regEx = "^(.)+,(\\d|[a-zA-Z])+,((.)+:(\\d|//.)+,){3}((.)+:(\\d|//.)+){1}$";
        Pattern pattern = Pattern.compile(regEx);

        Matcher matcher = pattern.matcher(infoOfStudent);
        boolean isFormatCorrect = matcher.matches();

        return isFormatCorrect;
    }

    //判断输入的学号信息格式是否正确
    public boolean isFormatCorrectInInputNum(String allNumOfInput) {//allNumOfInput:输入的学号

        String regEx = "^(\\d|[a-zA-Z])+(,{1}(\\d|[a-zA-Z])+)*$";

        Pattern pattern = Pattern.compile(regEx);

        //System.out.println(this.allNumOfInput);
        Matcher matcher = pattern.matcher(allNumOfInput);
        boolean isFormatCorrectOfInputNum = matcher.matches();

        //System.out.println("学号格式正确");

        return isFormatCorrectOfInputNum;
    }
}


