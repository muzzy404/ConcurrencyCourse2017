package lesson110717;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Daria on 11.07.2017.
 */
public class WorkerThread {

    // queue from tasks
    private Queue<Runnable> tasks = new LinkedList<>();

    public WorkerThread() {
        new Thread(this::process).start();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                process();
            }
        }).start();*/
    }

    private void process() {
        while (true) {
            Runnable task = null;
            // check only in synchronized
            // such checks only in 'while' (do not use 'if')
            synchronized (tasks) {
                while (tasks.isEmpty()) {
                    try {
                        tasks.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                task = tasks.poll();
            }
            task.run();
        } // back to wait
    }

    public void submit(Runnable task) {
        synchronized (tasks) {
            tasks.add(task);
            tasks.notify();
        }
    }

}
