package com.autokonto.pl.xpartner;

import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class Task implements Runnable {

    @Override
    public void run() {

        printOdd("1");
        printEven("2");
    }

    private synchronized void printOdd(String name) {




        Random random = new Random();
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + name);
        notify();
    }

    private synchronized void printEven(String name) {
        try {
            wait();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(Thread.currentThread().getName() + name);
        notify();
    }

    public static void main(String[] args) {
//        Task runner = new Task();
//        Thread one = new Thread(runner, "oddPrinter");
//        Thread two = new Thread(runner, "evenPrinter");
//
//        one.start();
//        two.start();
        Parent p = new Parent();

    }

}
