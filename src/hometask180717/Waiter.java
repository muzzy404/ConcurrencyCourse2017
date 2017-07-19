package hometask180717;

import common.Utils;

/**
 * Created by Daria on 20.07.2017.
 */
public class Waiter implements Runnable {

    private WindowBoundedBuffer<String> window;

    public Waiter(WindowBoundedBuffer<String> window) {
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
            System.out.println("serving, " + Thread.currentThread());
            Utils.pause(10_000 + Restaurant.random.nextInt(3_000));
        }
    }

}
