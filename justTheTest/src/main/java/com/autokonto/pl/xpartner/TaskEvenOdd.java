package com.autokonto.pl.xpartner;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;

public class TaskEvenOdd implements Runnable {

    private int max;
    private Printer print;
    private boolean isEvenNumber;

    public TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
        this.print = print;
        this.max = max;
        this.isEvenNumber = isEvenNumber;
    }

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printEven(number);
            } else {
                print.printOdd(number);
            }
            number += 2;
        }
    }

    public static void main(String... args) {
        LocalDateTime localDateTime = LocalDateTime.now().plusSeconds(10);
        while (!LocalDateTime.now().isAfter(localDateTime)) {
        }
        System.out.println("after");
        String dd = "james";
        Optional.of(dd).orElse("");

//        Printer print = new Printer();
//        Thread t1 = new Thread(new TaskEvenOdd(print, 10, false), "Odd");
//        Thread t2 = new Thread(new TaskEvenOdd(print, 10, true), "Even");
//        t1.start();
//        t2.start();
    }

    static class Printer {
        private volatile boolean isOdd;

        synchronized void printEven(int number) {
            while (!isOdd) {
                try {
                    wait(); // curent thread calls
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + number);
            isOdd = false;
            notify(); // other thread executes and calls this
        }

        synchronized void printOdd(int number) {
            while (isOdd) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + number);
            isOdd = true;
            notify();
        }
    }


}
