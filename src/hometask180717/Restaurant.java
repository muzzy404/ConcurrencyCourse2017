package hometask180717;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Daria on 20.07.2017.
 */
public class Restaurant {

    static final Random random = new Random();

    public static void main(String[] args) {
        WindowBoundedBuffer<String> window = new WindowBoundedBuffer<>(3);

        ExecutorService service = Executors.newCachedThreadPool();

        service.execute(new Cook(window));

        service.execute(new Waiter(window));
        service.execute(new Waiter(window));
        service.execute(new Waiter(window));
    }

}
