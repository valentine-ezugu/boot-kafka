package com.autokonto.pl.xpartner;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private   void take() throws InterruptedException {
        for (int i = 1; i <= 4; i++) {
            queue.take();
            System.out.println("consumed " + i);
        }
    }

}
