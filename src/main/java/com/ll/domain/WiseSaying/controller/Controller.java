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
}
