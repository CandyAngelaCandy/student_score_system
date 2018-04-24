package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.fest.assertions.api.Assertions.assertThat;


/**
 * Created by 22935 on 2018/4/23.
 */
public class PrintScoreTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private  List<Student> allStudentInfo = new ArrayList<>();

    @Before
    public void setup() {

        System.setOut(new PrintStream(outContent));

        Map<String,Integer> stu1Score =new HashMap<String,Integer>(){
            {
                put("数学",75 );
                put("语文",95 );
                put("英语",80 );
                put("编程",80);
            }
        };

        Student stu1 = new Student("张三","152296",stu1Score);


        Map<String,Integer> stu2Score =new HashMap<String,Integer>(){
            {
                put("数学",85 );
                put("语文",80 );
                put("英语",70 );
                put("编程",90);
            }
        };

        Student stu2 = new Student("李四","152297",stu2Score);

        allStudentInfo.add(stu1);
        allStudentInfo.add(stu2);

    }


    @Test
    public void should_get_average_of_list() {
        // 获取数组的平均值
        Integer[] array = new Integer[]{12, 34, 56, 78, 90, 21};
        List<Integer> arrayList = Arrays.asList(array);

        PrintScore printScore = new PrintScore();

        assertThat(printScore.getAverage(arrayList)).isEqualTo(48.5);
    }

    @Test
    public void should_get_median_of_list() {
        Integer[] array = new Integer[]{1, 3, 1, 1, 2};
        List<Integer> arrayList = Arrays.asList(array);
        PrintScore printScore = new PrintScore();

        assertThat(printScore.getMedian(arrayList)).isEqualTo(1);


        Integer[] evenArray = new Integer[]{1, 1, 3, 2};
        List<Integer> evenArrayList = Arrays.asList(evenArray);

        assertThat(printScore.getMedian(evenArrayList)).isEqualTo(1.5);
    }

    @Test
    public void should_print_Single_Student_Score_Information(){

        PrintScore printScore = new PrintScore();
        printScore.printStudentScoreInfo("152296",allStudentInfo);

        String result = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330\n" +
                "全班总分平均数：327.5\n" +
                "全班总分中位数：327.5\n";

        assertThat(systemOut()).isEqualTo(result);
    }

    @Test
    public void should_print_Multi_Student_Score_Information(){

        PrintScore printScore = new PrintScore();
        printScore.printStudentScoreInfo("152296,152297",allStudentInfo);


        String result = "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330\n" +
                "李四|85|80|70|90|81.25|325\n" +
               "全班总分平均数：327.5\n" +
                "全班总分中位数：327.5\n";

        assertThat(systemOut()).isEqualTo(result);
    }

    private String systemOut() {
        return outContent.toString();
    }

}