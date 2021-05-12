package com.autokonto.pl.xpartner;

import java.util.concurrent.*;

public class LearnFuture {

    ExecutorService executorService = Executors.newFixedThreadPool(2);

    Future<Integer> calculateSomething() {
        return executorService.submit(() -> {
            Thread.sleep(1000);
            return 1;
        });
    }
    Future<Integer> calculateSomething2() {
        return executorService.submit(() -> {
            Thread.sleep(1000);
            return 1;
        });
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        LearnFuture e = new LearnFuture();
        Future<Integer> integerFuture = e.calculateSomething();

        Future<Integer> integerFuture2 = e.calculateSomething2();

        while (!(integerFuture.isDone() && integerFuture2.isDone())) {

            System.out.println(
                    String.format(
                            "future1 is %s and future2 is %s",
                            integerFuture.isDone() ? "done" : "not done",
                            integerFuture2.isDone() ? "done" : "not done"
                    )
            );
            Thread.sleep(300);
        }

        Integer integer = integerFuture.get();
        Integer integer2 = integerFuture2.get();
        System.out.println(integer + " and " + integer2);


    }
}
// example of functional interface runnable callable
