package lesson130717;

import common.Utils;

import java.util.Arrays;

/**
 * Created by Daria on 14.07.2017.
 */
public class StopExample {

    static class Task implements Runnable {

        Object lock = new Object();

        // (x + y) == 0
        int x = 0;
        int y = 0;

        @Override
        public void run() {
            synchronized (lock) {
                x += 10;
                Utils.pause(1_000);
                y -= 10;
            }
        }

        public int[] get() {
            int [] result = new int[2];
            synchronized (lock) {
                result[0] = x;
                result[1] = y;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println("start");

        Task task = new Task();

        Thread thread = new Thread(task);
        thread.start();

        Utils.pause(200);
        thread.stop(); // out: [10, 0]

        System.out.println(Arrays.toString(task.get()));

    }

}
