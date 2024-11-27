package com.ll.domain.WiseSaying.service;

import com.ll.domain.WiseSaying.entity.WiseSaying;
import com.ll.domain.WiseSaying.repository.Repository;

import java.util.List;
import java.util.Optional;

public class Service {
    private final Repository repository;

    public Service() {
        this.repository = new Repository();
    }

    public WiseSaying add(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        repository.save(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return repository.findAll();
    }

    public boolean removeById(int id) {
        return repository.removeById(id);
    }

    public Optional<WiseSaying> findById(int id) {
        return repository.findById(id);
    }

    public void modify(WiseSaying wiseSaying, String content, String author) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);

        repository.save(wiseSaying);
    }
}
