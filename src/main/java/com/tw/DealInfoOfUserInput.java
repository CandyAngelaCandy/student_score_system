package com.tw;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 22935 on 2018/4/12.
 */

//DealInfoOfUserInput类的功能：根据用户在主界面输入的信息进行相应的处理

public class DealInfoOfUserInput {
    private int numOfInput;

    public int getNumOfInput() {
        return numOfInput;
    }

    public void setNumOfInput(int numOfInput) {
        this.numOfInput = numOfInput;
    }

    public DealInfoOfUserInput(int numOfInput) {
        this.numOfInput = numOfInput;
    }

    //对主界面输入信息的处理
    public void dealInfoOfMainInterface() {
        switch (this.numOfInput) {
            case 1:
                addStudent();
                break;
            case 2:
                printScore();
                break;
            case 3:
                exitProcess();
                break;
        }

    }

    //使用正则表达式对infoOfStudent的格式进行校验
    private void dealStuInfo(Boolean isCorrectFormatOfStuInfo) {

        if (isCorrectFormatOfStuInfo) {
            System.out.println("学生xxx的成绩被添加");

            //一个学生实例被添加到列表中
            Student stu = generateStudentBasedInfo(infoOfStudent);
            this.allStudentInfo.add(stu);//这个全局变量应该如何声明

            //用户输入选项数字，进行处理
            int numOfInput = printMainInterfaceInfoAndUserInput();
            DealInfoOfUserInput dealInfoOfUserInput = new DealInfoOfUserInput(numOfInput);
            dealInfoOfUserInput.dealInfoOfMainInterface();

        } else {
            System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");

            //用户继续输入信息，直至格式正确或者退出系统
        }
    }


    //用户输入信息1的处理
    private void addStudent(){

        System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");

        //用户输入学生信息
        Scanner input2 = new Scanner(System.in);//?
        String infoOfStudent = input2.nextLine();

        System.out.println("input char: " + infoOfStudent);

        //检测输入的学生信息格式是否正确
        JudgeFormatOfInputStudentInfo judgeFormatOfInputStudentInfo = new JudgeFormatOfInputStudentInfo(infoOfStudent);
        boolean isCorrectFormatOfStuInfo = judgeFormatOfInputStudentInfo.isFormatCorectInStuInfo();

        dealStuInfo(isCorrectFormatOfStuInfo);
    }


    //用户输入信息2的处理
    private void printScore() {

        System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");

        //用户输入学号
        Scanner input4 = new Scanner(System.in);
        String allNumOfInput = input4.nextLine();

        //检测输入的学号格式是否正确
        JudgeFormatOfInputStudentInfo judgeFormatOfInputStudentInfo = new JudgeFormatOfInputStudentInfo(allNumOfInput);
        boolean isCorrectFormatOfNum = judgeFormatOfInputStudentInfo.isFormatCorrectInInputNum();

        if (isCorrectFormatOfNum) {

            //打印成绩单
            printStudentScoreInfo();

            //回到主界面
            printMainInterfaceInfo();

        } else {//学号格式不正确，输出提示信息

            System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");

            //一直输入，直到格式正确
            Scanner input5 = new Scanner(System.in);
            String reInputStudentInfo = input5.nextLine();

           /* while (!isFormatCorrectInInputNum(reInputStudentInfo)) {
                System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                Scanner input6 = new Scanner(System.in);
                reInputStudentInfo = input6.nextLine();
            }*/

        }

    }

    //用户输入信息3的处理
    private void exitProcess(){
        System.exit(0);//关闭当前进程
    }
}
