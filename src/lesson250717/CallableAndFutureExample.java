package lesson250717;

import java.util.Random;
import java.util.concurrent.*;

public class CallableAndFutureExample {

    static class Task implements Callable<Double> {

        @Override
        public Double call() throws Exception {
            double result = 0.0;

            for(int i = 0; i < 100_000_000; ++i) {
                Random r = new Random();
                result += Math.pow(Math.PI, r.nextDouble());
            }

            return result;
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Double> future = service.submit(new Task());

        // do something else

        try {
            Double result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
