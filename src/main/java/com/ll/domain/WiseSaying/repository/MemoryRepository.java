package com.ll.domain.WiseSaying.repository;

import com.ll.domain.WiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryRepository implements Repository{
    private List<WiseSaying> wisesList;
    private int lastId;

    public MemoryRepository() {
        this.wisesList = new ArrayList<>();
        this.lastId = 0;
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        if (!wiseSaying.isNew()) {
            return wiseSaying;
        }

        wiseSaying.setId(++lastId);
        wisesList.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wisesList;
    }

    public boolean removeById(int id) {
        return wisesList.removeIf(w -> w.getId() == id);
    }

    public Optional<WiseSaying> findById(int id) {
        return wisesList.stream()
                .filter(w -> w.getId() == id)
                .findFirst();
    }
}

