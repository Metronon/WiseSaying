package com.ll.domain.WiseSaying.repository;

import com.ll.domain.WiseSaying.entity.WiseSaying;
import com.ll.standard.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class FileRepository implements Repository{
    private List<WiseSaying> wisesList;
    private int lastId;

    public static String getTableDirPath() {
        return "db/test/wiseSaying";
    }

    public static String getRowFilePath(int id) {
        return getTableDirPath() + "/" + id + ".json";
    }

    public FileRepository() {
        this.wisesList = new ArrayList<>();
        this.lastId = 0;
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        if (!wiseSaying.isNew()) {
            return wiseSaying;
        }

        wiseSaying.setId(++lastId);

        Map<String, Object> wiseSayingMap = wiseSaying.toMap();
        String jsonStr = Util.json.toString(wiseSayingMap);

        Util.file.set(getRowFilePath(wiseSaying.getId()), jsonStr);

        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wisesList;
    }

    public boolean removeById(int id) {
        return Util.file.delete(getRowFilePath(id));
    }

    public Optional<WiseSaying> findById(int id) {
        return wisesList.stream()
                .filter(w -> w.getId() == id)
                .findFirst();
    }
}

