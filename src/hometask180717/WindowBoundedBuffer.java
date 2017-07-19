package hometask180717;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Daria on 20.07.2017.
 */
public class WindowBoundedBuffer<T> {

    private final Lock lock = new ReentrantLock();

    private final Condition notFull  = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final ArrayList<T> items;
    private final int size;

    public WindowBoundedBuffer(int size) {
        items = new ArrayList<T>(size);
        this.size = size;
    }

    public void put(T item) throws InterruptedException {
        lock.lock();

        try {
            while (items.size() == size) {
                notFull.await();
            }
            items.add(item);
            System.out.println("added, size = " + items.size());

            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (items.size() == 0) {
                notEmpty.await();
            }
            T item = items.get(0);
            items.remove(0);
            System.out.println("taken, size = " + items.size());

            notFull.signal();
            return item;
        } finally {
            lock.unlock();
        }
    }

}
