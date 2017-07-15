package lesson130717;

/**
 * Created by Daria on 11.07.2017.
 */
public class WorkerWithBlockingQueue {

    final private BlockingQueue<Runnable> tasks;
    final private Thread thread;

    volatile private boolean mayAcceptTasks;

    // not static - because we can use more than one worker
    final private Runnable POISON_PILL = () -> {};

    public WorkerWithBlockingQueue() {
        synchronized (POISON_PILL) {
            tasks = new BlockingQueue<>();
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
            Runnable task = tasks.take();
            if (task == POISON_PILL) {
                System.out.println("I'm dying");
                break;
            }
            task.run();
        }
    }

    public boolean submit(Runnable task) {
        synchronized (POISON_PILL) {
            if (!mayAcceptTasks) {
                return false;
            }
            if (task == POISON_PILL) {
                mayAcceptTasks = false;
            }
            tasks.put(task);
            return true;
        }
    }

}
