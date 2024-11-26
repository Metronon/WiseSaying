package com.ll;

import com.ll.domain.system.controller.SystemController;
import com.ll.domain.WiseSaying.controller.Controller;

import java.util.Scanner;

public class App {
    private final Scanner sc;
    private final SystemController systemController;
    private final Controller controller;

    public App(Scanner sc) {
        this.sc = sc;
        this.systemController = new SystemController();
        this.controller = new Controller(sc);
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            if ("종료".equals(cmd)) {
                systemController.actionExit();
                break;
            } else if ("등록".equals(cmd)) {
                controller.actionAdd();
            } else if ("목록".equals(cmd)) {
                controller.actionList();
            } else if ("삭제?id=1".equals(cmd)) {
                controller.actionRemove(cmd);
            }
        }
    }
}
