package com.tw;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by 22935 on 2018/4/22.
 */
public class JudgeFormatTest {
    @Test
    public void should_return_whether_correct_input_student_Info() {
        JudgeFormat judgeFormat = new JudgeFormat();

        String infoOfStudent1 = "张三,152296,数学:75,语文:95,英语:80,编程:80";
        assertThat(judgeFormat.isFormatCorectInStuInfo(infoOfStudent1)).isEqualTo(true);

        String infoOfStudent2 = "张三,数学:75,语文:95,英语:80,编程:80";
        assertThat(judgeFormat.isFormatCorectInStuInfo(infoOfStudent2)).isEqualTo(false);

        String infoOfStudent3 = "李四,152297,数学:85,语文:80,英语:70,编程:90";
        assertThat(judgeFormat.isFormatCorectInStuInfo(infoOfStudent3)).isEqualTo(true);
    }

    @Test
    public void should_return_whether_correct_input_num_format() {

        JudgeFormat judgeFormat = new JudgeFormat();

        String singleNumOfInput = "152296";
        assertThat(judgeFormat.isFormatCorrectInInputNum(singleNumOfInput)).isEqualTo(true);

        String multiNumOfInput1 = "152296,152297";
        assertThat(judgeFormat.isFormatCorrectInInputNum(multiNumOfInput1)).isEqualTo(true);

        String multiNumOfInput2 = "152296.152297";
        assertThat(judgeFormat.isFormatCorrectInInputNum(multiNumOfInput2)).isEqualTo(false);

    }

}