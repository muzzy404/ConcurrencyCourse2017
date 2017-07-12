package lesson110717;

import common.Utils;

/**
 * Created by Daria on 11.07.2017.
 */
public class UseWorkerThread {

    public static void main(String[] args) {
        WorkerThread worker = new WorkerThread();

        worker.submit(() -> {
            System.out.println("start " + Thread.currentThread());
            Utils.pause(1_000);
            System.out.println("stop");
        });

        worker.submit(() -> {
            System.out.println("start " + Thread.currentThread());
            Utils.pause(1_000);
            System.out.println("stop");
        });

        worker.submit(() -> {
            System.out.println("start " + Thread.currentThread());
            Utils.pause(1_000);
            System.out.println("stop");
        });

    }

}
