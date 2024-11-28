package com.ll.domain.wiseSaying.repository;

import com.ll.domain.WiseSaying.entity.WiseSaying;
import com.ll.domain.WiseSaying.repository.FileRepository;
import com.ll.standard.util.Util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class FileRepositoryTest {
    private final FileRepository fileRepository = new FileRepository();

    @BeforeEach
    public void beforeEach() {
        Util.file.rmdir(FileRepository.getTableDirPath());
    }

    @AfterEach
    public void afterEach() {
        Util.file.rmdir(FileRepository.getTableDirPath());
    }

    @Test
    @DisplayName("명언 저장 및 단건 조회 가능 여부")
    public void t1() {
        WiseSaying wiseSaying = new WiseSaying(0, "명언1", "작가1");
        fileRepository.save(wiseSaying);

        Optional<WiseSaying> opWiseSaying = fileRepository.findById(wiseSaying.getId());

        assertThat(
                opWiseSaying.get()
        ).isEqualTo(wiseSaying);
    }

    @Test
    @DisplayName("명언 삭제")
    public void t2() {
        WiseSaying wiseSaying = new WiseSaying(0, "명언1", "저자1");
        fileRepository.save(wiseSaying);

        fileRepository.removeById(wiseSaying.getId());

        String filePath = FileRepository.getRowFilePath(wiseSaying.getId());

        assertThat(
                Util.file.exists(filePath)
        ).isFalse();
    }

    @Test
    @DisplayName("명언 다건조회")
    public void t3() {
        WiseSaying wiseSaying1 = new WiseSaying(0, "꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "괴테");
        fileRepository.save(wiseSaying1);

        WiseSaying wiseSaying2 = new WiseSaying(0, "나의 삶의 가치는 나의 결정에 달려있다.", "아인슈타인");
        fileRepository.save(wiseSaying2);

        assertThat(
                fileRepository.findAll()
        ).containsExactlyInAnyOrder(wiseSaying1, wiseSaying2);
    }
}
