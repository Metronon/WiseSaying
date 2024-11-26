package com.ll.domain.WiseSaying.controller;

import com.ll.domain.WiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private final Scanner sc;
    private List<WiseSaying> wisesList;
    private int lastId;

    public Controller(Scanner sc) {
        this.sc = sc;
        this.wisesList = new ArrayList<>();
        this.lastId = 0;
    }

    // 명언 및 작가를 등록합니다. 이때 등록시마다 id가 1씩 증가합니다.
    public void actionAdd() {
        System.out.print("명언 : ");
        String content = sc.nextLine().trim();
        System.out.print("작가 : ");
        String author = sc.nextLine().trim();
        int id = ++lastId;

        WiseSaying wises = new WiseSaying(id, content, author);
        wisesList.add(wises);

        System.out.println(id + "번 명언이 등록되었습니다.");
    }

    // 현재 등록된 명언의 id, 작가, 명언을 표시합니다.
    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (WiseSaying wiseSaying : wisesList.reversed()) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    public void actionRemove(String cmd) {
        String[] parts = cmd.split("=");
        int idToRemove = Integer.parseInt(parts[1]);
        boolean isRemoved = wisesList.removeIf(w -> w.getId() == idToRemove);

        if (!isRemoved) {
            System.out.printf("%d번 명언이 삭제되었습니다./n", idToRemove);
        } else {
            System.out.printf("%d번 명언은 존재하지 않습니다./n", idToRemove);
        }
    }
}
