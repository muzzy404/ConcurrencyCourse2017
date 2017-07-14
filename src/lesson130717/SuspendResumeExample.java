package lesson130717;

import common.Utils;

/**
 * Created by Daria on 14.07.2017.
 */
public class SuspendResumeExample {

    public static void main(String[] args) {

        System.out.println("start");

        Object lock = new Object();

        // to create local variable ctrl + alt + v

        // bad example
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                Utils.pause(10_000); // pause is a bad practice
                System.out.println("Woke up");
            }
        });
        thread.start();

        Utils.pause(1_000);

        // deprecated! do not use
        thread.suspend();
        thread.resume();

    }

}
