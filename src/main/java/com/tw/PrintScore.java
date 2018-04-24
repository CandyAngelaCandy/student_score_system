package com.tw;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 22935 on 2018/4/22.
 */
public class PrintScore {

    //打印学生成绩信息
    public void printStudentScoreInfo(String allNumOfInput,Set<Student> allStudentInfo) {
        //根据学号打印成绩信息

        String [] stuNumArr = allNumOfInput.split(",");

        System.out.print("成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n");

       allStudentInfo.stream().filter(student ->
                                  Arrays.asList(stuNumArr).contains(student.getStudentNum())==true)
                                 .forEach(student -> System.out.print(generateStuStrInfo(student)+"\n"));

        //将学生总分添加到Data.allSum中
        allStudentInfo.stream().forEach(student -> Data.allSum.add(calEveryStuSum(student)));

        //全班总分平均数
        double  averageOfAllSum = getAverage(Data.allSum);

        //全班总分中位数
        double medianOfAllSum = getMedian(Data.allSum);

        System.out.print("全班总分平均数："+averageOfAllSum+"\n" +
                "全班总分中位数："+medianOfAllSum+"\n");
    }


    //计算全班总分平均数

    public double getAverage(List<Integer> arrayList) {
        IntSummaryStatistics stats = arrayList.stream()
                .mapToInt(x -> x)
                .summaryStatistics();
        return stats.getAverage();
    }

    //计算全班总分中位数
    public double getMedian(List<Integer> arrayList) {

        List<Integer> sortListFromSmall = arrayList.stream()
                .sorted()
                .collect(Collectors.toList());

        int mediumIndex = sortListFromSmall.size() / 2;

        double medimuNum;
        if (sortListFromSmall.size() % 2 == 0) {
            medimuNum = (double) (sortListFromSmall.get(mediumIndex - 1) +
                    sortListFromSmall.get(mediumIndex)) / 2;
        } else {
            medimuNum = (double) sortListFromSmall.get(mediumIndex);
        }

        return medimuNum;
    }


    private String generateStuStrInfo(Student student) {

        //数学：75，语文:95,英语:80,编程:80
        // 张三|75|95|80|80|82.5|330

        String nameOfStu = student.getName();

        Map<String, Integer> scoreOfStu = student.getStudentScore();

        //将map转为list
        List<Integer> allScoreOfEveryStu = mapToLsit(scoreOfStu);

        int sumOfEveryStu = calEveryStuSum(student);

        //每个学生的平均分成绩保留两位小数
        double averageOfEveryStu = (double) Math.round(
                (double) sumOfEveryStu / allScoreOfEveryStu.size()
                        * 100) / 100;

        String strInfoOfStu = nameOfStu;

        for (Integer everyScore : allScoreOfEveryStu) {
            strInfoOfStu += "|" + everyScore;
        }

        strInfoOfStu +=  "|"+averageOfEveryStu + "|" + sumOfEveryStu;
        return strInfoOfStu;
    }

    private  List<Integer> mapToLsit(Map<String, Integer> scoreOfStu) {

        List<Integer> allScoreOfEveryStu = new ArrayList<>();

        allScoreOfEveryStu.add(scoreOfStu.get("数学"));
        allScoreOfEveryStu.add(scoreOfStu.get("语文"));
        allScoreOfEveryStu.add(scoreOfStu.get("英语"));
        allScoreOfEveryStu.add(scoreOfStu.get("编程"));

        return allScoreOfEveryStu;
    }

    private int calEveryStuSum(Student student) {

        int sumOfEveryStu = student.getStudentScore().values().stream()
                .reduce((sum, everyScore) -> sum + everyScore)
                .get();

        return sumOfEveryStu;
    }

}
