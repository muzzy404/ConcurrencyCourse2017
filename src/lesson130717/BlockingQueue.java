package lesson130717;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Daria on 15.07.2017.
 */
public class BlockingQueue<T> {

    private Queue<T> items = new LinkedList<>();

    public void put(T item) {
        synchronized (items) {
            items.add(item);
            items.notify();
        }
    }

    public T take() {
        synchronized (items) {
            while (items.isEmpty()) {
                try {
                    items.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return items.poll();
        }
    }

}
