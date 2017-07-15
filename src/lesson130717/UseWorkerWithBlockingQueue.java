package lesson130717;

import common.Utils;

/**
 * Created by Daria on 15.07.2017.
 */
public class UseWorkerWithBlockingQueue {

    static class Task implements Runnable {

        private int number;

        public Task(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            System.out.println("start " + number);
            Utils.pause(2_000);
            System.out.println("stop " + number);
        }
    }

    public static void main(String[] args) {

        WorkerWithBlockingQueue worker = new WorkerWithBlockingQueue();

        worker.submit(new Task(1));
        worker.submit(new Task(2));
        worker.submit(new Task(3));

        worker.shutdown();
        System.out.println("finished tasks planning");
    }

}
