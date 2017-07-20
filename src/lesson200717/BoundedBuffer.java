package lesson200717;

import java.util.concurrent.Semaphore;

/**
 * Created by Daria on 20.07.2017.
 *
 * !!! BAD EXAMPLE !!!
 *
 */
class BoundedBuffer {
    // Lock       ---> Semaphore
    // Conditions ---> Semaphore

    final Semaphore lock = new Semaphore(1);
    final Semaphore notFull  = new Semaphore(0);
    final Semaphore notEmpty = new Semaphore(0);

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.acquireUninterruptibly();
        try {
            while (count == items.length) {
                notFull.acquireUninterruptibly();
            }
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.release();
        } finally {
            lock.release();
        }
    }

    public Object take() throws InterruptedException {
        lock.acquireUninterruptibly();
        try {
            while (count == 0) {
                notEmpty.acquireUninterruptibly();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.release();
            return x;
        } finally {
            lock.release();
        }
    }
}

