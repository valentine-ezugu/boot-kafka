package com.autokonto.pl.xpartner;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            put();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private   void put() throws InterruptedException {
        for (int i = 1; i <= 4; i++) {
            queue.put(i);
            System.out.println("Produced " + i);
        }
    }

}
