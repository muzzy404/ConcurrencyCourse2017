package lesson250717;

import common.Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<?> one = service.submit(() -> {
            System.out.println("one");
            Utils.pause(1_000);
        });

        Future<?> two = service.submit(() -> {
            System.out.println("two");
            Utils.pause(1_000);
        });

        Future<?> three = service.submit(() -> {
            System.out.println("three");
            Utils.pause(1_000);
        });

        two.cancel(false);

        service.shutdown();

    }

}
