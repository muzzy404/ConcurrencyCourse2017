package hometask180717;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Daria on 19.07.2017.
 */
public class BlockingQueueWithLock<T> {

    private Queue<T> items = new LinkedList<T>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition canTake = lock.newCondition();

    public void put(T item) {
        lock.lock();
        try {
            items.add(item);
            canTake.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() {
        lock.lock();

        try {
            while (items.isEmpty()) {
                try {
                    canTake.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return items.poll();
        } finally {
            lock.unlock();
        }
    }

}
