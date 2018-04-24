package com.tw;

import java.util.Scanner;

/**
 * Created by 22935 on 2018/4/22.
 */
public class DispalyInfo {

    public int printMainInterfaceInfoAndUserInput() {
        String initInfo = "1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：";
        System.out.println(initInfo);

        //用户输入
        Scanner input1 = new Scanner(System.in);
        int numOfInput = input1.nextInt();

        return numOfInput;
    }


}
