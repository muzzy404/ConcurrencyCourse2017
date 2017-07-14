package lesson130717;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Daria on 11.07.2017.
 */
public class WorkerThreadWithPoisonPill {

    private Queue<Runnable> tasks = new LinkedList<>();
    private Thread thread;

    volatile private boolean mayAcceptTasks;

    static final private Runnable POISON_PILL = () -> {
        Thread.currentThread().stop(); // not recommended
    };

    public WorkerThreadWithPoisonPill() {
        synchronized (tasks) {
            thread = new Thread(this::process);
            thread.start();
            mayAcceptTasks = true;
        }
    }

    public void shutdown() {
        submit(POISON_PILL);
    }

    private void process() {
        while (true) {
            Runnable task = null;

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

            // commented because of using stop method
            /*if (task == POISON_PILL) {
                System.out.println("I'm dying");
                break;
            }*/

            task.run();
        }
    }

    public boolean submit(Runnable task) {
        synchronized (tasks) {
            if (!mayAcceptTasks) {
                return false;
            }

            if (task == POISON_PILL) {
                mayAcceptTasks = false;
            }
            tasks.add(task);
            tasks.notify();
        }
        return true;
    }

}
