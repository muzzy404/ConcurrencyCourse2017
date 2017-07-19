package hometask180717;

import common.Utils;

/**
 * Created by Daria on 20.07.2017.
 */
public class Cook implements Runnable {

    private WindowBoundedBuffer<String> window;

    public Cook(WindowBoundedBuffer<String> window) {
        this.window = window;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("start cooking");
            Utils.pause(1_000 + Restaurant.random.nextInt(3_000));
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
