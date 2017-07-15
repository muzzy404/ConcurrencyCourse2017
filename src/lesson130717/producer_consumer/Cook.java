package lesson130717.producer_consumer;

import common.Utils;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Daria on 15.07.2017.
 */
public class Cook implements Runnable {

    private BlockingQueue<String> window;

    public Cook(BlockingQueue<String> window) {
        this.window = window;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("start cooking");
            Utils.pause(1_000 + SynchQueueExample.random.nextInt(3_000));
            System.out.println("dish is ready, waiting for waiter");

            // put dish to window
            try {
                window.put("dish");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
