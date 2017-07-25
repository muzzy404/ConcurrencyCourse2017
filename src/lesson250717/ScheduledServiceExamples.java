package lesson250717;

import common.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledServiceExamples {

    static volatile int count = 0;

    static class Task implements Runnable {

        int number = count++;

        @Override
        public void run() {
            Utils.pause(2_000);
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        List<Task> tasks = new ArrayList<>();

        for(int i = 0; i < 100; ++i) {
            tasks.add(new Task());
        }

        Iterator<Task> iterator = tasks.iterator();
        service.scheduleAtFixedRate(() -> {
            iterator.next().run();
        }, 0, 3, TimeUnit.SECONDS);

        // make task 1 time per sec
        /*service.scheduleAtFixedRate(() -> {
            Utils.pause(2_000);
            System.out.println(count++);
        }, 0, 1, TimeUnit.SECONDS);*/

        // after the end waits delay
        /*service.scheduleWithFixedDelay(() -> {
            System.out.println("two");
        }, 0, 1, TimeUnit.SECONDS);*/

    }

}
