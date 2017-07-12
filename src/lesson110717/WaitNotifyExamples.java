package lesson110717;

import common.Utils;

/**
 * Created by Daria on 11.07.2017.
 */
public class WaitNotifyExamples {

    static class Task implements Runnable {

        private Object pager;

        public Task(Object pager) {
            this.pager = pager;
        }

        @Override
        public void run() {
            synchronized (pager) {
                try {
                    pager.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // got signal
                System.out.println(this);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("start");

        Object pager = new Object();
        new Thread(new Task(pager)).start();

        Utils.pause(3_000);

        // pager.notify(); // exception 'IllegalMonitorStateException'
        synchronized (pager) {
            pager.notify();
        }

        Utils.pause(10_000);

    }

}
