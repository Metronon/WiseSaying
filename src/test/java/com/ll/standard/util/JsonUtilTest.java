package com.ll.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonUtilTest {
    @Test
    @DisplayName("맵을 Json으로 출력하는 테스트")
    public void t1() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "이름");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "name" : "이름"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("Json 출력 테스트 (2개 이상의 필드)")
    public void t2() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", "이름");
        map.put("gender", "남자");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "name" : "이름",
                    "gender" : "남자"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("인수에 숫자(정수)가 나왔을때")
    public void t3() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("age", 15);
        map.put("name", "이름");
        map.put("gender", "남자");

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "age" : 15,
                    "name" : "이름",
                    "gender" : "남자"
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("인수에 숫자(실수)가 나왔을때")
    public void t4() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("age", 15);
        map.put("name", "이름");
        map.put("gender", "남자");
        map.put("height", 158.152);

        String jsonStr = Util.json.toString(map);

        assertThat(jsonStr).isEqualTo("""
                {
                    "age" : 15,
                    "name" : "이름",
                    "gender" : "남자",
                    "height" : 158.152
                }
                """.stripIndent().trim());
    }

    @Test
    @DisplayName("Json to Map (필드 1개)")
    public void t5 () {
            String jsonStr = """
                    {
                        "name" : "철수"
                    }
                    """.stripIndent().trim();

            Map<String, Object> map = Util.json.toMap(jsonStr);

            assertThat(map).containsEntry("name", "철수");
    }

    @Test
    @DisplayName("Json to Map (필드 2개)")
    public void t6() {
        String jsonStr = """
                    {
                        "name" : "철수",
                        "gender" : "남자"
                    }
                    """.stripIndent().trim();

        Map<String, Object> map = Util.json.toMap(jsonStr);

        assertThat(map)
                .containsEntry("name", "철수")
                .containsEntry("gender", "남자");
    }

    @Test
    @DisplayName("Json to Map (필드 다수, boolean, 숫자)")
    public void t7() {
        String jsonStr = """
                    {
                        "age" : 15,
                        "height" : 174.1229,
                        "name" : "철수",
                        "gender" : "남자",
                        "married" : false
                    }
                    """.stripIndent().trim();

        Map<String, Object> map = Util.json.toMap(jsonStr);

        assertThat(map)
                .containsEntry("age", 15)
                .containsEntry("height", 174.1229)
                .containsEntry("name", "철수")
                .containsEntry("gender", "남자")
                .containsEntry("married", false);
    }
}
