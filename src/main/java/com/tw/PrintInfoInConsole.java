package com.tw;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*(张三,152296,数学:75,语文:95,英语:80,编程:80)
(李四,152297,数学:85,语文:80,英语:70,编程:90)*/
/**
 * Created by 22935 on 2018/4/11.
 */
public class PrintInfoInConsole {
    private Set<Student> allStudentInfo = new HashSet<>();
    private List<Integer> allSum = new ArrayList<>();

    public static void main(String[] args) {
        PrintInfoInConsole printInfoInConsole = new PrintInfoInConsole();
        printInfoInConsole.init();
    }

    public void init() {

        //显示主界面信息，按照用户输入的选项数字，处理
        int numOfInput = printMainInterfaceInfoAndUserInput();

        dealInfoOfMainInterface(numOfInput);
    }


    //打印学生成绩信息
    private void printStudentScoreInfo() {

        Set<String> strInfoOfStudent = this.allStudentInfo.stream()
                .map(student -> this.generateStuStrInfo(student))
                .collect(Collectors.toSet());

        System.out.println("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================");

        strInfoOfStudent.stream()
                        .forEach((strInfoOfEveryStu) -> System.out.println(strInfoOfStudent.toString()));

        System.out.println("全班总分平均数：xxx\n" +
                "全班总分中位数：xxx");

    }

    private String generateStuStrInfo(Student student) {

        //数学：75，语文:95,英语:80,编程:80
        // 张三|75|95|80|80|82.5|330  管不管输入顺序

        String nameOfStu = student.getName();
        Map<String, Integer> scoreOfStu = student.getStudentScore();

        List<Integer> allScoreOfEveryStu = new ArrayList<>();

        allScoreOfEveryStu.add(scoreOfStu.get("数学"));
        allScoreOfEveryStu.add(scoreOfStu.get("语文"));
        allScoreOfEveryStu.add(scoreOfStu.get("英语"));
        allScoreOfEveryStu.add(scoreOfStu.get("编程"));

        int sumOfEveryStu = allScoreOfEveryStu.stream()
                .reduce((sum, everyScore) -> sum + everyScore)
                .get();

        //每个学生的平均分成绩保留两位小数
        double averageOfEveryStu = (double) Math.round(
                (double) sumOfEveryStu / allScoreOfEveryStu.size()
                        * 100) / 100;

        String StrInfoOfStu = nameOfStu;

        for (Integer everyScore : allScoreOfEveryStu) {
            StrInfoOfStu += "|" + everyScore;
        }

        StrInfoOfStu +=  "|"+averageOfEveryStu + "|" + sumOfEveryStu + "";
        return StrInfoOfStu;
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


    public int printMainInterfaceInfoAndUserInput() {
        String initInfo = "1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：";
        System.out.println(initInfo);

        //用户输入
        Scanner input1 = new Scanner(System.in);
        int numOfInput = input1.nextInt();

        return numOfInput;
    }

}
