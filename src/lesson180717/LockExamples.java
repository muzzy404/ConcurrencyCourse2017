package lesson180717;

import common.Utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Daria on 18.07.2017.
 */
public class LockExamples {

    public static void main(String[] args) {

        // can be taken few times
        Lock lock = new ReentrantLock();

        new Thread(() -> {
            lock.lock();
            try {
                Utils.pause(5_000);
            } finally {
                lock.unlock();
            }
        }).start();

        System.out.println("start");
        Utils.pause(1_000);

        System.out.println("try to enter");
        // lock - unlock == synchronized
        lock.lock(); // synchronized (lock) {
        try {
            System.out.println("got it!");
        } finally {
            lock.unlock(); // } end of synchronized
        }

    }

}
