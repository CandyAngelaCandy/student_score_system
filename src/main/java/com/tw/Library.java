package com.tw;

public class Library {

    public static void main(String[] args) {
        Library printInfoInConsole = new Library();
        printInfoInConsole.init();
    }

    public void init() {

        //显示主界面信息，按照用户输入的选项数字，处理
        DispalyInfo dispalyInfo = new DispalyInfo();
        int numOfInput = dispalyInfo.printMainInterfaceInfoAndUserInput();

        DealInfo dealInfoOfUserInput = new DealInfo(numOfInput);
        dealInfoOfUserInput.dealInfoOfMainInterface();
    }
}
