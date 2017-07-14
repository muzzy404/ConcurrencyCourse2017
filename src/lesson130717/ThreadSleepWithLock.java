package lesson130717;

import common.Utils;

/**
 * Created by Daria on 14.07.2017.
 */
public class ThreadSleepWithLock {

    public static void main(String[] args) {

        System.out.println("start");

        Object lock = new Object();

        // bad example
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    //Utils.pause(10_000);        - bad
                    lock.wait(10_000); // - good
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Woke up");
            }
        });
        thread.start();

        Utils.pause(1_000);

        synchronized (lock) {
            System.out.println("hello");
        }

    }

}
