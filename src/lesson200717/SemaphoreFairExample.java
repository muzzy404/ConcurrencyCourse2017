package lesson200717;

import common.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Daria on 20.07.2017.
 */
public class SemaphoreFairExample {

    static volatile int count = 0;

    private static final class Runner implements Runnable {

        private final Semaphore sem;

        public Runner(Semaphore sem) {
            this.sem = sem;
        }

        @Override
        public void run() {
            int number = count++;
            System.out.println(number + " waiting for signal");
            sem.acquireUninterruptibly();
            System.out.println(number + " got signal");
        }
    }

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(0, false);

        List<Runner> runners = Arrays.asList(
                new Runner(sem),
                new Runner(sem),
                new Runner(sem),
                new Runner(sem));

        ExecutorService service = Executors.newCachedThreadPool();

        for(Runner runner : runners) {
            Utils.pause(200);
            service.execute(runner);
        }

        Utils.pause(500);

        System.out.println("ready...");
        Utils.pause(1_000);
        System.out.println("steady...");
        Utils.pause(1_000);
        System.out.println("go!");
        Utils.pause(1_000);

        for(int i = 0; i < runners.size(); ++i) {
            sem.release();
            Utils.pause(100);
        }

    }

}
