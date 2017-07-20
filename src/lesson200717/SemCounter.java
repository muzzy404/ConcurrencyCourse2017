package lesson200717;

import java.util.concurrent.Semaphore;

/**
 * Created by Daria on 20.07.2017.
 */
public class SemCounter {

    int count = 0;

    Semaphore sem = new Semaphore(1);

    public int get() {
        sem.acquireUninterruptibly(); // synchronized (sem) {
        try {
            return count;
        } finally {
            sem.release(); // }
        }
    }

    public void inc() {
        sem.acquireUninterruptibly(); // synchronized (sem) {
        try {
            count++;
        } finally {
            sem.release(); // }
        }
    }

}
