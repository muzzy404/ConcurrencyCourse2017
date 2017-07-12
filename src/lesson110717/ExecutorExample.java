package lesson110717;

import common.Utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Daria on 11.07.2017.
 */
public class ExecutorExample {

    public static void main(String[] args) {

        // there are a lot of different executor types
        Executor service = Executors.newSingleThreadExecutor();

        service.execute(() -> {
            System.out.println("start");
            Utils.pause(2_000);
            System.out.println("stop");
        });

        service.execute(() -> {
            System.out.println("start");
            Utils.pause(2_000);
            System.out.println("stop");
        });

        service.execute(() -> {
            System.out.println("start");
            Utils.pause(2_000);
            System.out.println("stop");
        });

    }

}
