package lesson110717;

import common.Utils;

/**
 * Created by Daria on 11.07.2017.
 */
public class WaitNotifyProblems {

    public static void main(String[] args) {
        System.out.println("start");

        Object pager = new Object();
        new Thread(() -> {
            synchronized (pager) {
                try {
                    pager.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("huuray!");
        }).start();

        Utils.pause(20_000);

        synchronized (pager) {
            pager.notify();
            // foget to go out from sync
            while (true) {}
            // any calculations make outta sync
        }
    }

}
