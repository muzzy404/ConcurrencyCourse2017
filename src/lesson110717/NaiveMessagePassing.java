package lesson110717;

import common.Utils;

/**
 * Created by Daria on 11.07.2017.
 */
public class NaiveMessagePassing {

    volatile static boolean ready = false;

    static class Task implements Runnable {

        @Override
        public void run() {
            while (!ready) {}
            System.out.println("got it!");
        }

    }

    public static void main(String[] args) {

        System.out.println("start");
        new Thread(new Task()).start();

        Utils.pause(3000);
        ready = true;

    }

}
