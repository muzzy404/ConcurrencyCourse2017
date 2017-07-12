package lesson110717;

/**
 * Created by Daria on 11.07.2017.
 */
public class SimpleWorker {

    public void process(Runnable task) {
        new Thread(task).start();
    }

}
