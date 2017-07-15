package lesson130717.producer_consumer;

import common.Utils;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by Daria on 15.07.2017.
 */
public class SynchQueueExample {

    static final Random random = new Random();

    public static void main(String[] args) {
        BlockingQueue<String> window = new LinkedBlockingQueue<>();

        Cook cook = new Cook(window);
        Waiter waiter = new Waiter(window);

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(cook);
        service.execute(waiter);

        // check the length of queue
        service.execute(() -> {
            while (true) {
                Utils.pause(1_000);
                System.out.println(window.size());

                if (window.size() > 2) {
                    service.execute(new Waiter(window));
                }
            }
        });
    }

}
