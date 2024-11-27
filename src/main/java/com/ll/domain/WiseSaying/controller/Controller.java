package com.ll.domain.WiseSaying.controller;

import com.ll.Command;
import com.ll.domain.WiseSaying.entity.WiseSaying;
import com.ll.domain.WiseSaying.service.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Controller {
    private final Scanner sc;
    private final Service service;

    public Controller(Scanner sc) {
        this.sc = sc;
        this.service = new Service();
    }

    public void actionAdd() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();

        WiseSaying wiseSaying = service.add(content, author);

        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<WiseSaying> wisesList = service.findAll();

        for (WiseSaying wiseSaying : wisesList) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    public void actionRemove(Command command) {
        int id = command.getParamAsInt("id", 0);

        if (id == 0) {
            System.out.println("id(숫자)를 입력해주세요.");
            return;
        }

        boolean removed = service.removeById(id);

        if (!removed) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    public void actionModify(Command command) {
        int id = command.getParamAsInt("id", 0);

        if (id == 0) {
            System.out.println("id(숫자)를 입력해주세요.");
            return;
        }

        Optional<WiseSaying> opWiseSaying = service.findById(id);

        if (opWiseSaying.isEmpty()) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }

        WiseSaying wiseSaying = opWiseSaying.get();
        System.out.println("명언(기존) : " + wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = sc.nextLine();

        System.out.println("작가(기존) : " + wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = sc.nextLine();

        service.modify(wiseSaying, content, author);
    }
}

