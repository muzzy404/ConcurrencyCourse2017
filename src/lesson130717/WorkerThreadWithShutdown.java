package lesson130717;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Daria on 11.07.2017.
 */
public class WorkerThreadWithShutdown {

    // queue from tasks
    private Queue<Runnable> tasks = new LinkedList<>();
    Thread thread;

    public WorkerThreadWithShutdown() {
        thread = new Thread(this::process);
        thread.start();
    }

    public void shutdown() {
        //thread.stop(); // bad practice!
        thread.interrupt();
    }

    // hometask - what to do with interrupt?
    private void process() {
        OUTER: while (true) {
            Runnable task = null;

            synchronized (tasks) {
                while (tasks.isEmpty()) {
                    try {
                        tasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                        break OUTER;
                    }
                }
                task = tasks.poll();
            }
            task.run();
        } // back to wait

        for (Runnable runnable : tasks) {
            runnable.run();
        }

    }

    public void submit(Runnable task) {
        synchronized (tasks) {
            tasks.add(task);
            tasks.notify();
        }
    }

}
