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
        String output = AppTest.run("""
                목록
                """);

        assertThat(output)
                .contains("명령) ");
    }

    @Test
    @DisplayName("반복문 체크")
    public void t3() {
        String output = AppTest.run("""
                목록
                목록
                """);

        assertThat(output)
                .contains("명령) ");
    }

    @Test
    @DisplayName("종료 테스트")
    public void t4() {
        String output = AppTest.run("""
                종료
                """);

        assertThat(output)
                .contains("명언 앱을 종료합니다.");
    }

    @Test
    @DisplayName("등록 테스트")
    public void t5() {
        String output = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        assertThat(output)
                .contains("명언 : ")
                .contains("작가 : ");
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
