package com.tw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 22935 on 2018/4/12.
 */

//判断输入的学生信息的格式否正确
public class JudgeFormatOfInputStudentInfo {


    private String infoOfStudent;//输入的学生信息
    private String allNumOfInput;//输入的学号

    public JudgeFormatOfInputStudentInfo(String infoOfStudent) {
        this.infoOfStudent = infoOfStudent;
    }


    public boolean isFormatCorectInStuInfo() {

        String regEx = "^(.)+,(\\d|[a-zA-Z])+,((.)+:(\\d|//.)+,){3}((.)+:(\\d|//.)+){1}$";
        Pattern pattern = Pattern.compile(regEx);

        Matcher matcher = pattern.matcher(this.infoOfStudent);
        boolean isFormatCorrect = matcher.matches();

        return isFormatCorrect;
    }

    //判断输入的学生信息格式是否正确
    public boolean isFormatCorrectInInputNum() {

        String regEx = "^(\\d|[a-zA-Z])+((\\d|[a-zA-Z]),)*$";
        Pattern pattern = Pattern.compile(regEx);

        Matcher matcher = pattern.matcher(this.allNumOfInput);
        boolean isFormatCorrectOfInputNum = matcher.matches();

        System.out.println("学号格式正确");

        return isFormatCorrectOfInputNum;
    }
}


