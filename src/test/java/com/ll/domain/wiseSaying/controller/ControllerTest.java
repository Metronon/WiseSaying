package com.ll.domain.wiseSaying.controller;

import com.ll.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {
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
    @Test
    @DisplayName("ID 확인 테스트")

    public void t6() {
        String output = AppTest.run("""
                    등록
                    현재를 사랑하라.
                    작자미상
                    """);

        assertThat(output)
                .contains("명언 : ")
                .contains("작가 : ")
                .containsPattern(".*번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("ID 증가 테스트")
    public void t7() {
        String output = AppTest.run("""
                    등록
                    현재를 사랑하라.
                    작자미상
                    등록
                    과거를 회상하라.
                    작자미상
                    """);

        assertThat(output)
                .contains("2번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록 테스트")
    public void t8() {
        String output = AppTest.run("""
                목록
                """);

        assertThat(output)
                .contains("번호 / 작가 / 명언")
                .contains("----------------------");
    }
}
