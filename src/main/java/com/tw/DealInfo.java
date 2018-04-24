package com.tw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
* Created by 22935 on 2018/4/12.
*/

//DealInfo类的功能：根据用户在主界面输入的信息进行相应的处理

public class DealInfo {
   private int numOfInput;

   public int getNumOfInput() {
       return numOfInput;
   }

   public void setNumOfInput(int numOfInput) {
       this.numOfInput = numOfInput;
   }

   public DealInfo(int numOfInput) {
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

   //根据输入的学生信息的格式是否正确，进行相应的处理
   private void dealStuInfo(Boolean isCorrectFormatOfStuInfo,String infoOfStudent) {

       if (isCorrectFormatOfStuInfo) {

           addStuInSys(infoOfStudent);

       } else {
           System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");

           //用户继续输入信息，直至格式正确或者退出系统
           Scanner input = new Scanner(System.in);
           String reInputStuInfo = input.nextLine();

           //检测输入的学生信息格式是否正确
           JudgeFormat judgeFormatOfInputStudentInfo = new JudgeFormat();

           while (!judgeFormatOfInputStudentInfo.isFormatCorectInStuInfo(reInputStuInfo)) {
               System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
               Scanner input1 = new Scanner(System.in);
               reInputStuInfo = input1.nextLine();
           }

           //一个学生实例被添加到列表中
           addStuInSys(reInputStuInfo);
       }
   }

    //将正确的学生信息添加到系统中
    private void addStuInSys(String infoOfStudent) {
        //一个学生实例被添加到列表中
        Student stu = generateStudentBasedInfo(infoOfStudent);
        System.out.println("学生"+stu.getName()+"的成绩被添加");
        Data.allStudentInfo.add(stu);

        //用户输入选项数字，进行处理
        DispalyInfo dispalyInfo = new DispalyInfo();
        int numOfInput = dispalyInfo.printMainInterfaceInfoAndUserInput();

        DealInfo dealInfoOfUserInput = new DealInfo(numOfInput);
        dealInfoOfUserInput.dealInfoOfMainInterface();
    }

    //用户输入信息1的处理
   private void addStudent(){

       System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");

       //用户输入学生信息
       Scanner input2 = new Scanner(System.in);
       String infoOfStudent = input2.nextLine();

       //System.out.println("input char: " + infoOfStudent);

       //检测输入的学生信息格式是否正确
       JudgeFormat judgeFormatOfInputStudentInfo = new JudgeFormat();
       boolean isCorrectFormatOfStuInfo = judgeFormatOfInputStudentInfo.isFormatCorectInStuInfo(infoOfStudent);

       dealStuInfo(isCorrectFormatOfStuInfo,infoOfStudent);
   }

   //用户输入信息2的处理
   private void printScore() {

       System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");

       //用户输入学号
       Scanner input4 = new Scanner(System.in);
       String allNumOfInput = input4.nextLine();

       //检测输入的学号格式是否正确
       JudgeFormat judgeFormatOfInputStudentInfo = new JudgeFormat();
       boolean isCorrectFormatOfNum = judgeFormatOfInputStudentInfo.isFormatCorrectInInputNum(allNumOfInput);

       if (isCorrectFormatOfNum) {

           //打印成绩单
           PrintScore printScore = new PrintScore();
           printScore.printStudentScoreInfo(allNumOfInput,Data.allStudentInfo);

           //回到主界面,并处理用户输入
           Library printInfoInConsole = new Library();
           printInfoInConsole.init();

       } else {//学号格式不正确，输出提示信息

           System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");

           //一直输入，直到格式正确
           Scanner input5 = new Scanner(System.in);
           String reInputNum = input5.nextLine();

          //检测输入的学号格式是否正确
          JudgeFormat judgeFormatOfInputStudentInfo1 = new JudgeFormat();

          while (!judgeFormatOfInputStudentInfo1.isFormatCorrectInInputNum(reInputNum)) {
              System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
              Scanner input6 = new Scanner(System.in);
              reInputNum = input6.nextLine();
          }

           //打印成绩单
           PrintScore printScore = new PrintScore();
           printScore.printStudentScoreInfo(reInputNum,Data.allStudentInfo);

           //回到主界面,并处理用户输入
           Library printInfoInConsole = new Library();
           printInfoInConsole.init();

       }

   }

   //用户输入信息3的处理
   private void exitProcess(){
       System.exit(0);//关闭当前进程
   }


   //根据用户输入的信息，生成一个学生实例
   private Student generateStudentBasedInfo(String infoOfStudent) {

       String[] infoArrOfStudent = infoOfStudent.split(",");
       String name = infoArrOfStudent[0];
       String studentNum = infoArrOfStudent[1];

       Map<String, Integer> stuScore = new HashMap<>();

       IntStream.range(2, infoArrOfStudent.length)
               .boxed()
               .forEach((num) ->{
                   String[] stuEveryScoreArr = infoArrOfStudent[num].split(":");
                   stuScore.put(stuEveryScoreArr[0], Integer.valueOf(stuEveryScoreArr[1]));
               });

       Student student = new Student(name, studentNum, stuScore);

       return student;
   }
}
