package com.tw;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 22935 on 2018/4/11.
 */
public class PrintInfoInConsole {
    public static void main(String[] args){
        PrintInfoInConsole printInfoInConsole = new PrintInfoInConsole();
        printInfoInConsole.init();
    }

    public void init() {
        printMainInterfaceInfo();
        Scanner input1 = new Scanner(System.in);
        int numOfInput = input1.nextInt();

        if (numOfInput == 1) {
            System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
        }

        Scanner input2 = new Scanner(System.in);
        String infoOfStudent = input2.nextLine();

        System.out.println("input char: "+infoOfStudent);

        isFormatOfInfputCorrect(infoOfStudent);

    }

    private void isFormatOfInfputCorrect(String infoOfStudent) {
        //使用正则表达式对infoOfStudent的格式进行校验
        String regEx = "^(.)+,(\\d|[a-zA-Z])+,((.)+:(\\d|//.){1,4})+$";
        Pattern pattern = Pattern.compile("^(.)+,(\\d|[a-zA-Z])+,((.)+:(\\d|//.){1,4})+$");
        //Pattern pattern = Pattern.compile("((.)+:(\\d|//.){1,4})+");
        Matcher matcher = pattern.matcher(infoOfStudent);
        boolean isFormatCorrect = matcher.matches();

        System.out.println(isFormatCorrect);

        if (isFormatCorrect) {
            System.out.println("学生xxx的成绩被添加");
            printMainInterfaceInfo();
        } else {
            System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
        }
    }

    public void printMainInterfaceInfo(){
        String initInfo = "1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：";
        System.out.println(initInfo);
    }

}
