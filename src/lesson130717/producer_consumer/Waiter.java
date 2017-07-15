package lesson130717.producer_consumer;

import common.Utils;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Daria on 15.07.2017.
 */
class Waiter implements Runnable {

    private BlockingQueue<String> window;

    public Waiter(BlockingQueue<String> window) {
        this.window = window;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("start waiting");

            // take dish from window
            try {
                String dish = window.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("serving");
            Utils.pause(10_000 + SynchQueueExample.random.nextInt(3_000));
        }
    }

}
