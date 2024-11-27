package com.ll;

import com.ll.domain.WiseSaying.controller.Controller;
import com.ll.domain.system.controller.SystemController;

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

            Command command = new Command(cmd);

            switch (command.getActionName()) {
                case "종료":
                    systemController.actionExit();
                    return;
                case "등록":
                    controller.actionAdd();
                    break;
                case "목록":
                    controller.actionList();
                    break;
                case "삭제":
                    controller.actionRemove(command);
                    break;
                case "수정":
                    controller.actionModify(command);
                    break;
            }
        }
    }
}
