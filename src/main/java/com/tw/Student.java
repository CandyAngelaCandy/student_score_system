package com.tw;

import java.util.Map;

/**
 * Created by 22935 on 2018/4/11.
 */
public class Student {

    private String name;

    private String studentNum;

    private  Map<String,Integer> studentScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public  Map<String,Integer> getStudentScore() {
        return studentScore;
    }

    public void setStudentScore( Map<String,Integer> studentScore) {
        this.studentScore = studentScore;
    }

    public  Student(String name,String studentNum, Map<String,Integer> studentScore) {
         this.name = name;
         this.studentNum = studentNum;
         this.studentScore = studentScore;
    }
}
