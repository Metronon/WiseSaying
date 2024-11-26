package com.ll;

import com.ll.standard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {

    @Test
    @DisplayName("구동 확인")
    public void t1() {
        String output = AppTest.run("");

        assertThat(output)
                .contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("명령) ")
    public void t2() {
        String output = AppTest.run("");

        assertThat(output)
                .contains("명령) ");
    }

    public static String run(String input) {
        input = input.stripIndent().trim() + "\n종료";
        Scanner sc = TestUtil.getScanner(input);
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();

        App app = new App(sc);
        app.run();

        String output = outputStream.toString();

        TestUtil.clearSetOutToByteArray(outputStream);

        return output;
    }
}
